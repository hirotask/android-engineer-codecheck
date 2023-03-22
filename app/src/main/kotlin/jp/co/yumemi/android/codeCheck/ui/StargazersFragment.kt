package jp.co.yumemi.android.codeCheck.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.android.codeCheck.R
import jp.co.yumemi.android.codeCheck.domain.Stargazer
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StargazersFragment : Fragment(R.layout.only_recyclerview) {

    private val viewModel: StargazersViewModel by viewModels()
    private val args: StargazersFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.one_recyclerView)

        val layoutManager = LinearLayoutManager(requireContext())
        val dividerItemDecoration =
            DividerItemDecoration(requireContext(), layoutManager.orientation)
        val adapter = StargazersAdapter(object : StargazersAdapter.OnItemClickListener {
            override fun itemClick(item: Stargazer) {
                gotoWebView(item.url)
            }
        })

        viewModel.searchResults(args.userName, args.repoName)
        lifecycleScope.launch {
            viewModel.itemState.collect {
                adapter.submitList(it)
            }
        }
        recyclerView.also {
            it.layoutManager = layoutManager
            it.addItemDecoration(dividerItemDecoration)
            it.adapter = adapter
        }
    }

    private fun gotoWebView(url: String) {
        val action = StargazersFragmentDirections.actionStargazersFragmentToWebViewFragment(url)
        findNavController().navigate(action)
    }
}
