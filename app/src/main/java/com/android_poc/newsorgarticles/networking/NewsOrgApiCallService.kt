package com.android_poc.newsorgarticles.networking

import com.android_poc.newsorgarticles.model.NewsOrgResp
import com.android_poc.newsorgarticles.util.AppConstants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsOrgApiCallService {

    @GET(AppConstants.END_POINT)
    fun getTopHeadlines(@Query("country") country:String = AppConstants.COUNTRY_CODE,
                        @Query("apiKey")apiKey:String = AppConstants.API_KEY):Call<NewsOrgResp>
}