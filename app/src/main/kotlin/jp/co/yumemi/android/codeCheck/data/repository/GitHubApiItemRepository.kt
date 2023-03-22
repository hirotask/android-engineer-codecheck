package jp.co.yumemi.android.codeCheck.data.repository

import jp.co.yumemi.android.codeCheck.domain.Item
import kotlinx.coroutines.flow.StateFlow

/**
 * GitHubAPIで得られたItemを永続化する
 */
interface GitHubApiItemRepository {

    /**
     * 状態を監視する
     */
    fun observe(): StateFlow<List<Item>>

    /**
     * 状態を引数のリストで更新する
     */
    suspend fun update(list: List<Item>)
}
