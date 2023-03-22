package jp.co.yumemi.android.codeCheck.domain

import com.squareup.moshi.Json

data class IssueResponseList(val issueList: List<IssueResponse>)

data class IssueResponse(
    @Json(name = "avatar_url") val avatarUrl: String,
    @Json(name = "html_url") val htmlUrl: String,
    @Json(name = "login") val userName: String
)

