package com.android_poc.newsorgarticles.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.android_poc.newsorgarticles.BR
import com.android_poc.newsorgarticles.R
import com.android_poc.newsorgarticles.databinding.NewsItemBinding
import com.android_poc.newsorgarticles.model.Articles
import com.bumptech.glide.Glide

class NewsArticleListRecyclerAdapter(var newsArticleList : List<Articles>,val context: Context) : RecyclerView.Adapter<NewsArticleListRecyclerAdapter.NewsArticleListViewHolder>() {

    class NewsArticleListViewHolder(val newsItemBinding: NewsItemBinding,val context: Context, view:View):
            RecyclerView.ViewHolder(view) {

        fun bind(newsArticle: Articles) {
            newsItemBinding.setVariable(BR.NewsOrgObj, newsArticle)
            newsItemBinding.executePendingBindings()
            if(newsArticle.urlToImage!=null) {
                Glide.with(context).load(newsArticle.urlToImage).into(newsItemBinding.ivArticleBgImg)
            }
            newsItemBinding.root.setOnClickListener(object:View.OnClickListener{
                override fun onClick(p0: View?) {
                    p0?.findNavController()?.navigate(R.id.navigateNewsDetailFragment)
                }
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsArticleListViewHolder {
        val newsItemBinding = DataBindingUtil.inflate<NewsItemBinding>(LayoutInflater.from(parent.getContext()),
                R.layout.news_item, parent, false)
        return NewsArticleListViewHolder(newsItemBinding, context,newsItemBinding.root)
    }

    override fun onBindViewHolder(holder: NewsArticleListViewHolder, position: Int) {
        holder.bind(newsArticleList.get(position))
    }

    override fun getItemCount(): Int {
        return newsArticleList.size
    }

    fun setNewsArticlesFromResp(newsArticleList: List<Articles>){
        this.newsArticleList = newsArticleList
        notifyDataSetChanged()
    }
}