package jp.co.yumemi.android.codeCheck.ui

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import jp.co.yumemi.android.codeCheck.R

class WebViewFragment: Fragment(R.layout.webview_fragment) {

    private val args : WebViewFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val webView = view.findViewById<WebView>(R.id.webview)
        webView.loadUrl(args.url)
    }
}