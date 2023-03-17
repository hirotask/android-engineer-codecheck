package jp.co.yumemi.android.codeCheck.domain

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Owner(@Json(name = "avatar_url") val avatarUrl: String) : Parcelable
