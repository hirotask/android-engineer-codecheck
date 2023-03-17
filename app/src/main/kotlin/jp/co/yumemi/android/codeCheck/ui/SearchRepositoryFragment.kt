/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.codeCheck.ui

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.android.codeCheck.R
import jp.co.yumemi.android.codeCheck.databinding.SearchRepositoryFragmentBinding
import jp.co.yumemi.android.codeCheck.domain.Item

@AndroidEntryPoint
class SearchRepositoryFragment : Fragment(R.layout.search_repository_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = SearchRepositoryFragmentBinding.bind(view)

        val viewModel = SearchRepositoryViewModel(requireContext())

        val layoutManager = LinearLayoutManager(requireContext())
        val dividerItemDecoration =
            DividerItemDecoration(requireContext(), layoutManager.orientation)
        val adapter = CustomAdapter {
            gotoDetailFragment(it)
        }

        binding.searchInputText
            .setOnEditorActionListener { editText, action, _ ->
                if (action == EditorInfo.IME_ACTION_SEARCH) {
                    editText.text.toString().let {
                        viewModel.searchResults(it).apply {
                            adapter.submitList(this)
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
