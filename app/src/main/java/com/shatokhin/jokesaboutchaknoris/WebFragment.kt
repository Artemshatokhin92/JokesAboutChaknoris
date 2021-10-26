package com.shatokhin.jokesaboutchaknoris

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button

class WebFragment : Fragment(R.layout.fragment_web) {

    companion object {
        const val TAG = "WebFragment"
    }

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        webView = view.findViewById(R.id.webView)
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true


        if (savedInstanceState != null) webView.restoreState(savedInstanceState)
        else webView.loadUrl("https://www.icndb.com/api/")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        webView.saveState(outState)
        super.onSaveInstanceState(outState)
    }

    fun webViewCanGoBack(): Boolean {
        return webView.canGoBack()
    }
    fun webViewGoBack() {
        webView.goBack()
    }
}