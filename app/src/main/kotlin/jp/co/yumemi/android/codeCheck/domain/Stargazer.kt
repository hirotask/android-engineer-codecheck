package jp.co.yumemi.android.codeCheck.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stargazer(
    val avatarUrl: String,
    val url: String,
    val userName: String
) : Parcelable
