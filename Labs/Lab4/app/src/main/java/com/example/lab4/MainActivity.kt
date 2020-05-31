package com.example.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private val h: Handler = Handler()
    private lateinit var runnable: Runnable
    private var running: Boolean = false
    private var seconds: Long = 0
    private lateinit var timerText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timerText = findViewById(R.id.timerText)
        running = savedInstanceState?.getBoolean("running") ?: false
        seconds = savedInstanceState?.getLong("seconds") ?: 0
        Log.e("e","$running:$seconds")
        runnable = Runnable {
            runTimer()
            h.postDelayed(runnable,1000)
        }
        runnable.run()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong("seconds",seconds)
        outState.putBoolean("running",running)
    }

    private fun runTimer(){
        if(running)
            seconds+=1
        when(seconds){
            in 1L..60L -> {
                timerText.text = "00:00:${"%02d".format(seconds)}"
            }
            in 60L..3599L -> {
                val minutes = seconds/60
                val secs = seconds%60
                timerText.text = "00:${"%02d".format(minutes)}:${"%02d".format(secs)}"
            }
            else -> {
                val hours = seconds/3600
                val tmp = seconds%3600
                val minutes = tmp/60
                val secs = tmp%60
                timerText.text = "${"%02d".format(hours)}:${"%02d".format(minutes)}:${"%02d".format(secs)}"
            }
        }
    }

    fun onStartClick(view: View) {
        running=true
    }
    fun onStopClick(view: View) {
        running=false
    }
    fun onResetClick(view: View) {
        running=false
        seconds=0
    }
}
