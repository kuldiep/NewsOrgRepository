package com.android_poc.newsorgarticles.viewmodel

import androidx.lifecycle.ViewModel
import com.android_poc.newsorgarticles.repository.NewsOrgRepository

open class BaseViewModel : ViewModel() {
    fun getRepositoryInstance():NewsOrgRepository{
        return NewsOrgRepository.getNewsOrgRepositoryInstance()
    }
}