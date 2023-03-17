package jp.co.yumemi.android.codeCheck.data.api

import javax.inject.Inject
import jp.co.yumemi.android.codeCheck.data.ItemResponse
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

class GitHubApiClient @Inject constructor(retrofit: Retrofit) : GitHubApi {

    interface Service {
        @Headers("Accept: application/vnd.github.v3+json")
        @GET("search/repositories")
        suspend fun getItems(
            @Query("q") q: String
        ): Response<ItemResponse>
    }

    val service = retrofit.create(Service::class.java)

    override suspend fun getGitHubItems(searchText: String): ItemResponse? {
        val response = service.getItems(searchText)

        if(response.isSuccessful) {
            return service.getItems(searchText).body()
        }

        throw HttpException(response)
    }

}