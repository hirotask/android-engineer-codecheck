package jp.co.yumemi.android.codeCheck.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    val name: String = "",
    val ownerIconUrl: String,
    val rawLanguage: String = "",
    val stargazersCount: Long = 0,
    val watchersCount: Long = 0,
    val forksCount: Long = 0,
    val openIssuesCount: Long = 0,
    val stargazersUrl: String,
    val forksUrl: String,
    val issueUrl: String
) : Parcelable
