package com.example.myspace.ui.mks_online


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.myspace.MainViewModel
import com.example.myspace.R
import com.example.myspace.extensions.activityViewModelProvider
import com.example.myspace.extensions.viewModelProvider
import com.example.myspace.fragment.BaseFragment


@Suppress("DEPRECATION")
class MksOnline : BaseFragment() {

    companion object {
        val WEB = "https://ustream.tv/embed/17074538"
        val MAP = "https://www.lizard-tail.com/isana/tracking/?catalog_number=25544&target=iss"
    }

    lateinit var mksOnlineViewModel: MksOnlineViewModel
    lateinit var mksOnlineMainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mksOnlineViewModel = viewModelProvider()

        val root = inflater.inflate(R.layout.fragment_mks_online, container, false)

        val web = root.findViewById<WebView>(R.id.videoView)
        val map = root.findViewById<WebView>(R.id.map)
        web?.let { showUstream(it, WEB) }
        map?.let { showUstream(it, MAP) }

        return root
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun showUstream(webView: WebView, url: String) {
        webView.setInitialScale(1)
        webView.webChromeClient = WebChromeClient()
        webView.settings.allowFileAccess = true
        webView.settings.pluginState = WebSettings.PluginState.ON
        webView.settings.pluginState = WebSettings.PluginState.ON_DEMAND
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true

        val displayMetrics = DisplayMetrics()
        activity?.windowManager?.defaultDisplay?.getMetrics(displayMetrics)

        val dataHtmlMap =
            "<!DOCTYPE html><html> <head> <meta charset=\"UTF-8\"><meta name=\"viewport\"content=\"target-densitydpi=high-dpi\"/><meta name=\"viewport\"content=\"width=device-width, initial-scale=1\"><link rel=\"stylesheet\"media=\"screen and (-webkit-device-pixel-ratio:1.5)\"href=\"hdpi.css\"/></head> <body style=\"background:black;margin:0 0 0 0; padding:0 0 0 0;\"><iframe width=\"480\"height=\"270\"src=\"${url}\"scrolling=\"no\"allowfullscreen webkitallowfullscreen frameborder=\"0\"style=\"border: 0 none transparent;\"></iframe></body></html>"
        webView.loadDataWithBaseURL("http://vimeo.com", dataHtmlMap, "text/html", "UTF-8", null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mksOnlineMainViewModel = activityViewModelProvider()
    }
}