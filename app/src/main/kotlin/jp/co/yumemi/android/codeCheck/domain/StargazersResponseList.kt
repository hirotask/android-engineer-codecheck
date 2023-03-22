package jp.co.yumemi.android.codeCheck.domain

import com.squareup.moshi.Json

data class StargazersResponseList(val list: List<StargazersResponse>)

data class StargazersResponse(
    @Json(name = "avatar_url") val avatarUrl: String,
    @Json(name = "html_url") val htmlUrl: String,
    @Json(name = "login") val userName: String
)

fun List<StargazersResponse>.toStargazers(): List<Stargazer> {
    val mutableList = mutableListOf<Stargazer>()

    this.forEach {
        mutableList.add(
            Stargazer(
                avatarUrl = it.avatarUrl,
                url = it.htmlUrl,
                userName = it.userName
            )
        )
    }

    return mutableList.toList()
}
