package jp.co.yumemi.android.codeCheck.data.api

import jp.co.yumemi.android.codeCheck.domain.ItemJsonResponse

/**
 * GitHubAPIと通信をする
 */
interface GitHubApi {
    /**
     *
     *
     * @param
     * @return
     */
    suspend fun getGitHubItems(searchText: String): ItemJsonResponse?
}