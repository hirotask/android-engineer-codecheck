/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.codeCheck.ui

import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import java.util.Date
import jp.co.yumemi.android.codeCheck.R

@AndroidEntryPoint
class TopActivity : AppCompatActivity(R.layout.activity_top) {

    companion object {
        lateinit var lastSearchDate: Date
    }
}
