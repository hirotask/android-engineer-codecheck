package jp.co.yumemi.android.codeCheck.data.api

import jp.co.yumemi.android.codeCheck.domain.ItemJsonResponse
import jp.co.yumemi.android.codeCheck.domain.StargazersResponse
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject

class GitHubApiClient @Inject constructor(retrofit: Retrofit) : GitHubApi {

    interface Service {
        @Headers("Accept: application/vnd.github.v3+json")
        @GET("search/repositories")
        suspend fun getItems(
            @Query("q") q: String
        ): Response<ItemJsonResponse>

        @GET("repos/{user_name}/{repo_name}/stargazers")
        suspend fun getStargazers(
            @Path("user_name") userName: String,
            @Path("repo_name") repoName: String
        ): Response<Array<StargazersResponse>>
    }

    val service = retrofit.create(Service::class.java)

    override suspend fun getGitHubItems(searchText: String): ItemJsonResponse? {
        val response = service.getItems(searchText)

        if (response.isSuccessful) {
            return response.body()
        }

        throw HttpException(response)
    }

    override suspend fun getStargazers(userName: String, repoName: String): Array<StargazersResponse>? {
        val response = service.getStargazers(userName, repoName)

        if (response.isSuccessful) {
            return response.body()
        }

        throw HttpException(response)
    }
}
