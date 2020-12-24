package com.android_poc.newsorgarticles.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android_poc.newsorgarticles.model.Articles
import com.android_poc.newsorgarticles.util.ApiCallStatusListener

class NewsListViewModel : BaseViewModel() {
    private var mutableLiveDataApiFlag = MutableLiveData<Boolean>()

    fun getTopHeadlinesFromNewsOrg(){
        val apiCallStatusListener = object : ApiCallStatusListener {
            override fun isApiCallSuccessfull(apiFlag: Boolean) {
                mutableLiveDataApiFlag.value = apiFlag
            }
        }
        getRepositoryInstance().makeApiCall(apiCallStatusListener)
    }

    fun getApiCallFlag(): LiveData<Boolean> {
        return mutableLiveDataApiFlag
    }

    fun getTopHeadLinesFromRepo():LiveData<List<Articles>>{
        return getRepositoryInstance().getMutableNewsArticleList()
    }
}