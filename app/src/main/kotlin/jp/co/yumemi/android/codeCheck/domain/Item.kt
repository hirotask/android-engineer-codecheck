package jp.co.yumemi.android.codeCheck.domain

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    @Json(name = "full_name") val name: String,
    @Json(name = "owner") val owner: Owner,
    @Json(name = "language") val language: String,
    @Json(name = "stargazers_count") val stargazersCount: Long,
    @Json(name = "watchers_count") val watchersCount: Long,
    @Json(name = "forks_count") val forksCount: Long,
    @Json(name = "open_issues_count") val openIssuesCount: Long,
) : Parcelable
