package jp.co.yumemi.android.codeCheck.data.repository

import jp.co.yumemi.android.codeCheck.domain.Stargazer
import kotlinx.coroutines.flow.StateFlow

/**
 * GitHubAPIで得られたStargazersを永続化する
 */
interface GitHubApiStargazersRepository {
    /**
     * 状態を監視する
     */
    fun observe(): StateFlow<List<Stargazer>>

    /**
     * 状態を引数のリストで更新する
     */
    suspend fun update(list: List<Stargazer>)
}
