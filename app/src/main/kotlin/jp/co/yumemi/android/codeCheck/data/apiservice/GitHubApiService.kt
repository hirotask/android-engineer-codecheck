package jp.co.yumemi.android.codeCheck.data.apiservice

import jp.co.yumemi.android.codeCheck.domain.Item
import jp.co.yumemi.android.codeCheck.domain.Stargazer

/**
 * GitHubAPIにおけるResponseをドメインオブジェクトに変換して提供する
 */
interface GitHubApiService {
    /**
     * GitHubApiを用いて検索語句を検索してList<Item>に変換する
     *
     * @param searchText 検索する語句
     * @return 検索結果
     */
    suspend fun getItems(searchText: String): List<Item>

    /**
     * GitHubApiを用いてStarしたユーザー一覧を検索して、List<Stargazer>に変換する
     */
    suspend fun getStargazers(userName: String, repoName: String): List<Stargazer>
}
