package jp.co.yumemi.android.codeCheck.data.api

import jp.co.yumemi.android.codeCheck.data.ItemResponse

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
    suspend fun getGitHubItems(searchText: String): ItemResponse?
}