/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.codeCheck.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.co.yumemi.android.codeCheck.data.apiservice.GitHubApiService
import jp.co.yumemi.android.codeCheck.data.repository.GitHubApiItemRepository
import jp.co.yumemi.android.codeCheck.domain.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class SearchRepositoryViewModel @Inject constructor(
    private val gitHubApiItemRepository: GitHubApiItemRepository,
    private val gitHubApiService: GitHubApiService
) : ViewModel() {

    // 最終検索日時
    private val lastSearchDateMutable = MutableStateFlow(Date())
    val lastSearchDate = lastSearchDateMutable.asStateFlow()

    // GitRepositoryのリスト
    val itemState: StateFlow<List<Item>> = gitHubApiItemRepository.observe()

    /**
     * githubのapiに問い合わせ、検索対象語句に一致したリポジトリをListで返す
     *
     * @param inputText 検索対象語句
     * @return 検索結果
     */
    fun searchResults(inputText: String) {
        viewModelScope.launch {
            lastSearchDateMutable.emit(Date())
            val list: List<Item> = gitHubApiService.getItems(inputText)
            gitHubApiItemRepository.update(list)
        }
    }
}
