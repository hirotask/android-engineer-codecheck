/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.codeCheck.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import jp.co.yumemi.android.codeCheck.R
import jp.co.yumemi.android.codeCheck.ui.TopActivity.Companion.lastSearchDate
import jp.co.yumemi.android.codeCheck.databinding.RepositoryDetailFragmentBinding

class RepositoryDetailFragment : Fragment(R.layout.repository_detail_fragment) {

    private val args: RepositoryDetailFragmentArgs by navArgs()

    lateinit var binding: RepositoryDetailFragmentBinding
    private val viewBinding get() = binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("検索した日時", lastSearchDate.toString())

        binding = RepositoryDetailFragmentBinding.bind(view)

        var item = args.item

        viewBinding.ownerIconView.load(item.ownerIconUrl)
        viewBinding.nameView.text = item.name
        viewBinding.languageView.text = item.language
        viewBinding.starsView.text = "${item.stargazersCount} stars"
        viewBinding.watchersView.text = "${item.watchersCount} watchers"
        viewBinding.forksView.text = "${item.forksCount} forks"
        viewBinding.openIssuesView.text = "${item.openIssuesCount} open issues"
    }
}
