/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.codeCheck.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Date
import javax.inject.Inject
import jp.co.yumemi.android.codeCheck.R
import jp.co.yumemi.android.codeCheck.data.apiservice.GitHubApiService
import jp.co.yumemi.android.codeCheck.data.repository.GitHubApiRepository
import jp.co.yumemi.android.codeCheck.domain.Item
import jp.co.yumemi.android.codeCheck.ui.TopActivity.Companion.lastSearchDate
import jp.co.yumemi.android.codeCheck.util.StringResource
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * TwoFragment で使う
 */
@HiltViewModel
class SearchRepositoryViewModel @Inject constructor(
    private val gitHubApiRepository: GitHubApiRepository,
    private val gitHubApiService: GitHubApiService
) : ViewModel() {

    val itemState: StateFlow<List<Item>> get() = gitHubApiRepository.observe()

    /**
     * githubのapiに問い合わせ、検索対象語句に一致したリポジトリをListで返す
     *
     * @param inputText 検索対象語句
     * @return 検索結果
     */
    fun searchResults(inputText: String) {
        viewModelScope.launch {
            val list: List<Item> = gitHubApiService.getItems(inputText).map {
                it.language = StringResource.create(R.string.written_language, it.rawLanguage)
                it
            }

            gitHubApiRepository.update(list)
        }

        lastSearchDate = Date()
    }
}
