package com.example.newssuper.Listeners;

import com.example.newssuper.Models.NewsHeadline;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse> {
    void onFetchData(List<NewsHeadline> data, String message);
    void onError(String message);
}
