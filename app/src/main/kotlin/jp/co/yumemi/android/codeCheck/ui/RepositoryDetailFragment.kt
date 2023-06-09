/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.codeCheck.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.android.codeCheck.R
import jp.co.yumemi.android.codeCheck.databinding.RepositoryDetailFragmentBinding
import jp.co.yumemi.android.codeCheck.domain.Item
import timber.log.Timber

@AndroidEntryPoint
class RepositoryDetailFragment : Fragment(R.layout.repository_detail_fragment) {

    private val args: RepositoryDetailFragmentArgs by navArgs()
    private val viewModel: SearchRepositoryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = args.item
        val context = view.context

        val binding = RepositoryDetailFragmentBinding.bind(view)

        Timber.tag("検索した日時").d(viewModel.lastSearchDate.value.toString())

        binding.ownerIconView.load(item.ownerIconUrl) {
            R.drawable.jetbrains
        }
        binding.nameView.text = item.fullName
        binding.languageView.text =
            context.getString(R.string.written_language, item.rawLanguage)

        binding.starsButton.apply {
            text = context.getString(R.string.star_count, item.stargazersCount)
            setOnClickListener {
                gotoStargazersFragment(item)
            }
        }
        binding.watchersButton.apply {
            text = context.getString(R.string.watcher_count, item.watchersCount)
        }
        binding.forksButton.apply {
            text = context.getString(R.string.forks_count, item.forksCount)
        }
        binding.openIssueButton.apply {
            text = context.getString(R.string.open_issue_count, item.openIssuesCount)
        }
    }

    private fun gotoStargazersFragment(item: Item) {
        val action = RepositoryDetailFragmentDirections.actionDetailFragmentToStargazersFragment(item.owner, item.name)
        findNavController().navigate(action)
    }
}
