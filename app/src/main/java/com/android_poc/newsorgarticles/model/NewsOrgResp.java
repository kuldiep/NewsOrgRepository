package com.android_poc.newsorgarticles.model;

import android.provider.MediaStore;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsOrgResp {
    @SerializedName("status")
    private String status;
    @SerializedName("totalResults")
    private Integer totalResult;
    @SerializedName("articles")
    private List<Articles> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(Integer totalResult) {
        this.totalResult = totalResult;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NewsOrgResp{");
        sb.append("status='").append(status).append('\'');
        sb.append(", totalResult=").append(totalResult);
        sb.append(", articles=").append(articles);
        sb.append('}');
        return sb.toString();
    }
}
