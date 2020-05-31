package com.example.lab3;

import android.media.MediaPlayer;
import android.view.View;

public class MyClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        MainActivity.mediaPlayer.start();
    }
}
