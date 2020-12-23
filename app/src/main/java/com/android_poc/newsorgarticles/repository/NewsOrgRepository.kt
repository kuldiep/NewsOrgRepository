package com.android_poc.newsorgarticles.repository

class NewsOrgRepository private constructor(){
    private object HOLDER {
        val INSTANCE = NewsOrgRepository()
    }

    companion object {
        fun getNewsOrgRepositoryInstance(): NewsOrgRepository {
            val instance: NewsOrgRepository by lazy { HOLDER.INSTANCE }
            return instance
        }
    }

}