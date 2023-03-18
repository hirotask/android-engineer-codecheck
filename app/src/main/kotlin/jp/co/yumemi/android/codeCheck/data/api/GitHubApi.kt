package jp.co.yumemi.android.codeCheck.data.api

import jp.co.yumemi.android.codeCheck.domain.ItemJsonResponse

/**
 * GitHubAPIと通信をする
 */
interface GitHubApi {
    /**
     * GitHubAPIと通信し、JSONのレスポンスを取得する
     *
     * @param
     * @return
     */
    suspend fun getGitHubItems(searchText: String): ItemJsonResponse?
}
