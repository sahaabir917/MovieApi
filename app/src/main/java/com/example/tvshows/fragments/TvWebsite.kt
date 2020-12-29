package com.example.tvshows.fragments

import android.os.Bundle
import android.view.*
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.tvshows.R
import com.example.tvshows.databinding.FragmentTvWebsiteBinding


class TvWebsite : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val binding = FragmentTvWebsiteBinding.inflate(inflater,container,false)
        var args = getArguments()
        var website = args!!.getString("website","Not passed any data ")
        binding.webviews.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url!!)
                return true
            }
        }

        binding.webviews.loadUrl(website.toString())
        binding.webviews.settings.javaScriptEnabled = true

        binding.webviews.webViewClient = WebViewClient()
        binding.webviews.canGoBack()
        binding.webviews.setOnKeyListener(View.OnKeyListener{ v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK && event.action == MotionEvent.ACTION_UP && binding.webviews.canGoBack()){
                binding.webviews.goBack()
                return@OnKeyListener true
            }
            false
        })

        return binding.root
    }


}