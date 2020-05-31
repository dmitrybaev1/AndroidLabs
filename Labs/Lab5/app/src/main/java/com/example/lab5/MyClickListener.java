package com.example.lab5;

import android.media.MediaPlayer;
import android.view.View;

import com.example.lab5.MainActivity;

public class MyClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        MainActivity.mediaPlayer.start();
    }
}
