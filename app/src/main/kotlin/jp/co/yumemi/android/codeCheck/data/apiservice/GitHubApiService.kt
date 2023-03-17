package jp.co.yumemi.android.codeCheck.data.apiservice

import jp.co.yumemi.android.codeCheck.domain.Item

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
}