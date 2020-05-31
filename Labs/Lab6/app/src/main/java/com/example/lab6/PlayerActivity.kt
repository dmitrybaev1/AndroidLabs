package com.example.lab6

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerFragment

class PlayerActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {
    var youtubePlayer: YouTubePlayer? = null
    var id: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        var intent = intent
        id = intent.getStringExtra("playlistId")
        val youtubePlayerFragment: YouTubePlayerFragment = fragmentManager.findFragmentById(R.id.player) as YouTubePlayerFragment
        youtubePlayerFragment.initialize(getString(R.string.key),this)
    }

    override fun onInitializationSuccess(
        p0: YouTubePlayer.Provider?,
        player: YouTubePlayer?,
        wasRestored: Boolean
    ) {
        youtubePlayer = player
        if (!wasRestored) {
            id?.let {
                youtubePlayer!!.cuePlaylist(id)
            }?:run{
                Toast.makeText(this,"Не найден id плэйлиста",Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {
        Toast.makeText(this,p1.toString(),Toast.LENGTH_LONG).show()
    }
}