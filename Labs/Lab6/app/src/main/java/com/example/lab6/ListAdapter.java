package com.example.lab6;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    private ArrayList<String> playlistsNames;
    private ArrayList<String> playlistsThumbnails;
    private ArrayList<String> playlistsIds;
    private MainActivity activity;
    public ListAdapter(ArrayList<String> playlistsNames,ArrayList<String> playlistsThumbnails,ArrayList<String> playlistsIds,MainActivity activity)
    {
        this.playlistsNames = playlistsNames;
        this.playlistsThumbnails = playlistsThumbnails;
        this.playlistsIds = playlistsIds;
        this.activity = activity;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Picasso.get().load(playlistsThumbnails.get(position)).into(holder.imageView);
        holder.textView.setText(playlistsNames.get(position));
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,PlayerActivity.class);
                intent.putExtra("playlistId",playlistsIds.get(position));
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return playlistsNames.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView imageView;
        public TextView textView;
        public MyViewHolder(View v){
            super(v);
            view = v;
            imageView = view.findViewById(R.id.imageView);
            textView = view.findViewById(R.id.textView);
        }
    }
}
