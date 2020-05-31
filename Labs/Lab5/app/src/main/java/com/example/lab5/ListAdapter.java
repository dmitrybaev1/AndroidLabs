package com.example.lab5;

import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.StatsSnapshot;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    private ArrayList<String> arrayList;
    public ListAdapter(ArrayList<String> al){
        arrayList = al;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(arrayList.get(position)).into(holder.imageView);
        //holder.imageView.setBackgroundResource(R.drawable.ic_launcher_foreground);
        holder.view.setOnClickListener(new MyClickListener());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView imageView;
        public MyViewHolder(View v){
            super(v);
            view = v;
            imageView = view.findViewById(R.id.imageView);
        }
    }
}
