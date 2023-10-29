package com.example.newssuper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.newssuper.Listeners.OnFetchDataListener;
import com.example.newssuper.Models.NewsApiResponse;
import com.example.newssuper.Models.NewsHeadline;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestManager manager = new RequestManager(MainActivity.this);
        manager.getNewsHeadlines(listener, "general",null);
    }
    private final OnFetchDataListener<NewsApiResponse> listener =new OnFetchDataListener<NewsApiResponse>() {

        @Override
        public void onFetchData(List<NewsHeadline> data, String message) {
            showNews(data);
        }

        @Override
        public void onError(String message) {

        }
    };
    private void showNews(List<NewsHeadline> headlines) {
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        customAdapter = new CustomAdapter(this, headlines, this);
        recyclerView.setAdapter(customAdapter);

    }
}