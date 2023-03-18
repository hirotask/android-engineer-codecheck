package jp.co.yumemi.android.codeCheck.domain

import com.squareup.moshi.Json

data class ItemJsonResponse(val items: List<ItemJson>)

data class ItemJson(
    @Json(name = "full_name")
    val name: String,
    @Json(name = "owner")
    val owner: Owner,
    @Json(name = "language")
    val rawLanguage: String?,
    @Json(name = "stargazers_count")
    val stargazersCount: Long ,
    @Json(name = "watchers_count")
    val watchersCount: Long,
    @Json(name = "forks_count")
    val forksCount: Long,
    @Json(name = "open_issues_count")
    val openIssuesCount: Long,
)

data class Owner(
    @Json(name = "avatar_url")
    val avatarUrl: String
)

fun List<ItemJson>.toItemList(): List<Item> {
    val mutableList = mutableListOf<Item>()

    this.forEach {
        mutableList.add(
            Item(
                name = it.name,
                ownerIconUrl = it.owner.avatarUrl,
                rawLanguage = it.rawLanguage ?: "",
                stargazersCount = it.stargazersCount,
                watchersCount = it.watchersCount,
                forksCount = it.forksCount,
                openIssuesCount = it.openIssuesCount
            )
        )
    }

    return mutableList.toList()
}