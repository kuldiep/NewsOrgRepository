package com.android_poc.newsorgarticles.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android_poc.newsorgarticles.model.Articles
import com.android_poc.newsorgarticles.model.NewsOrgResp
import com.android_poc.newsorgarticles.networking.NewsOrgApiCallService
import com.android_poc.newsorgarticles.networking.NewsOrgApiClient
import com.android_poc.newsorgarticles.util.ApiCallStatusListener
import com.android_poc.newsorgarticles.util.AppConstants.Companion.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsOrgRepository private constructor(){
    private var mutableNewsArticleLiveDataList = MutableLiveData<List<Articles>>()

    private object HOLDER {
        val INSTANCE = NewsOrgRepository()
    }

    companion object {
        fun getNewsOrgRepositoryInstance(): NewsOrgRepository {
            val instance: NewsOrgRepository by lazy { HOLDER.INSTANCE }
            return instance
        }
    }

    fun makeApiCall(apiCallStatusListener: ApiCallStatusListener){
        val newsOrgApiCallService = NewsOrgApiClient.buildService(NewsOrgApiCallService::class.java)
        newsOrgApiCallService.getTopHeadlines().enqueue(object : Callback<NewsOrgResp> {
            override fun onResponse(call: Call<NewsOrgResp>, response: Response<NewsOrgResp>) {
                if (response.isSuccessful) {
                    apiCallStatusListener.isApiCallSuccessfull(true)
                    mutableNewsArticleLiveDataList.value = response.body()?.articles
                }
            }

            override fun onFailure(call: Call<NewsOrgResp>, t: Throwable) {
                apiCallStatusListener.isApiCallSuccessfull(false)
                Log.d(TAG, "onFailure: exception .. ",t.cause)
            }
        })
    }

    fun getMutableNewsArticleList(): LiveData<List<Articles>> {
        return mutableNewsArticleLiveDataList
    }

}