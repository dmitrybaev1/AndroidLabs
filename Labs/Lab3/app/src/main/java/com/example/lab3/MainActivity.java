package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import lombok.Getter;
import android.media.MediaPlayer;
import android.os.Bundle;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListAdapter listAdapter;
    private final ArrayList<String> arrayList=new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;
    public static MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        recyclerView = findViewById(R.id.rv);
        addImages();
        listAdapter = new ListAdapter(arrayList);
        layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(listAdapter);
        mediaPlayer = MediaPlayer.create(this,R.raw.sound);
    }
    private void addImages(){
        arrayList.add("https://i.imgur.com/2KxoIsa.jpg");
        arrayList.add("https://i.imgur.com/EZHXbA0.jpg");
        arrayList.add("https://i.imgur.com/qb7Ev7A.jpg");
        arrayList.add("https://i.imgur.com/ZtXXAwX.jpg");
        arrayList.add("https://i.imgur.com/lrE9vha.jpg");
        arrayList.add("https://i.imgur.com/S66rx9n.jpg");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }
}
