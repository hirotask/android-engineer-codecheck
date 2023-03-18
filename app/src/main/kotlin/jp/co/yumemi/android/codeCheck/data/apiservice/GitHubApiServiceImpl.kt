package jp.co.yumemi.android.codeCheck.data.apiservice

import javax.inject.Inject
import jp.co.yumemi.android.codeCheck.data.api.GitHubApi
import jp.co.yumemi.android.codeCheck.domain.Item
import jp.co.yumemi.android.codeCheck.domain.toItemList
import retrofit2.HttpException
import timber.log.Timber

class GitHubApiServiceImpl @Inject constructor(
    private val gitHubApi: GitHubApi
) : GitHubApiService {

    override suspend fun getItems(searchText: String): List<Item> {
        try {
            val response = gitHubApi.getGitHubItems(searchText)

            if (response != null) {
                return response.items.toItemList()
            }
        } catch (e: HttpException) {
            Timber.tag("Http Error").d(e.message())
        }

        return emptyList()
    }

}