/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.codeCheck.ui

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.android.codeCheck.R
import jp.co.yumemi.android.codeCheck.databinding.SearchRepositoryFragmentBinding
import jp.co.yumemi.android.codeCheck.domain.Item
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchRepositoryFragment : Fragment(R.layout.search_repository_fragment) {

    private val viewModel: SearchRepositoryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = SearchRepositoryFragmentBinding.bind(view)

        val layoutManager = GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
        val dividerItemDecoration =
            DividerItemDecoration(requireContext(), layoutManager.orientation)
        val adapter = ItemAdapter(object : ItemAdapter.OnItemClickListener {
            override fun itemClick(item: Item) {
                gotoDetailFragment(item)
            }
        })

        binding.searchInputText
            .setOnEditorActionListener { editText, action, _ ->
                if (action == EditorInfo.IME_ACTION_SEARCH) {
                    lifecycleScope.launch {
                        if (editText.text.isNotEmpty()) {
                            viewModel.searchResults(editText.text.toString())
                            viewModel.itemState.collect {
                                adapter.submitList(it)
                            }
                        }
                    }
                    return@setOnEditorActionListener true
                }
                return@setOnEditorActionListener false
            }

        binding.recyclerView.also {
            it.layoutManager = layoutManager
            it.addItemDecoration(dividerItemDecoration)
            it.adapter = adapter
        }
    }

    private fun gotoDetailFragment(item: Item) {
        val action = SearchRepositoryFragmentDirections
            .actionRepositoriesFragmentToDetailFragment(item = item)
        findNavController().navigate(action)
    }
}
