/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.codeCheck.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.android.codeCheck.R
import jp.co.yumemi.android.codeCheck.databinding.RepositoryDetailFragmentBinding
import jp.co.yumemi.android.codeCheck.ui.TopActivity.Companion.lastSearchDate
import timber.log.Timber

@AndroidEntryPoint
class RepositoryDetailFragment : Fragment(R.layout.repository_detail_fragment) {

    private val args: RepositoryDetailFragmentArgs by navArgs()

    lateinit var binding: RepositoryDetailFragmentBinding
    private val viewBinding get() = binding

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.tag("検索した日時").d(lastSearchDate.toString())

        binding = RepositoryDetailFragmentBinding.bind(view)

        val item = args.item

        Timber.d(item.owner.avatarUrl)
        viewBinding.ownerIconView.load(item.owner.avatarUrl)
        viewBinding.nameView.text = item.name
        viewBinding.languageView.text = item.rawLanguage
        viewBinding.starsView.text = "${item.stargazersCount} stars"
        viewBinding.watchersView.text = "${item.watchersCount} watchers"
        viewBinding.forksView.text = "${item.forksCount} forks"
        viewBinding.openIssuesView.text = "${item.openIssuesCount} open issues"
    }

}
