package jp.co.yumemi.android.codeCheck.domain

import com.squareup.moshi.Json
import jp.co.yumemi.android.codeCheck.util.StringResource

data class Item(
    @Json(name = "full_name") val name: String,
    @Json(name = "owner") val owner: Owner,
    @Json(name = "language") val rawLanguage: String,
    @Json(name = "stargazers_count") val stargazersCount: Long,
    @Json(name = "watchers_count") val watchersCount: Long,
    @Json(name = "forks_count") val forksCount: Long,
    @Json(name = "open_issues_count") val openIssuesCount: Long,
    var language: StringResource,
)
