package com.example.newssuper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newssuper.Models.NewsHeadline;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder>{

    private Context context;
    private List<NewsHeadline> headlineList;

    public CustomAdapter(Context context, List<NewsHeadline> headlineList, MainActivity mainActivity) {
        this.context = context;
        this.headlineList = headlineList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headlines_list_container, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.text_title.setText(headlineList.get(position).getTitle());
        holder.text_author.setText(headlineList.get(position).getSource().getName());
        if (headlineList.get(position).getUrlToImage()!=null){
            Picasso.get().load(headlineList.get(position).getUrlToImage()).into(holder.img_headline);
        }

    }

    @Override
    public int getItemCount() {
        return headlineList.size();
    }
}
