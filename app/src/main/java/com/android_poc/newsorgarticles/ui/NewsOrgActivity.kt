package com.android_poc.newsorgarticles.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android_poc.newsorgarticles.R

class NewsOrgActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_org)
        /**
         * single activity design suggested by android
         * using navigation graph library of new architecture jetpack library
         */
    }
}