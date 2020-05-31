package com.example.lab4_1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var buttonCall: Button
    private lateinit var buttonMap: Button
    private lateinit var buttonWeb: Button
    private lateinit var buttonMail: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCall = findViewById(R.id.button_call)
        buttonMap = findViewById(R.id.button_map)
        buttonWeb = findViewById(R.id.button_web)
        buttonMail = findViewById(R.id.button_mail)
        buttonCall.setOnClickListener {
            val myIntent = Intent(Intent.ACTION_DIAL,Uri.parse("tel:89118208737"))
            myIntent.resolveActivity(packageManager)?.let {
                startActivity(myIntent)
            } ?:
                Toast.makeText(this,R.string.MsgCall,Toast.LENGTH_LONG).show()
        }
        buttonMap.setOnClickListener{
            val myIntent = Intent(Intent.ACTION_VIEW,Uri.parse("geo:47.6,-122.3"))
            myIntent.resolveActivity(packageManager)?.let {
                startActivity(myIntent)
            } ?:
                Toast.makeText(this,R.string.MsgMap,Toast.LENGTH_LONG).show()
        }
        buttonWeb.setOnClickListener {
            val myIntent = Intent(Intent.ACTION_VIEW,Uri.parse("http://google.com"))
            myIntent.resolveActivity(packageManager)?.let {
                startActivity(myIntent)
            } ?:
                Toast.makeText(this,R.string.MsgWeb,Toast.LENGTH_LONG).show()
        }
        buttonMail.setOnClickListener {
            val myIntent = Intent(Intent.ACTION_SENDTO)
            myIntent.data = Uri.parse("mailto:")
            myIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("dmitrybaev1@gmail.com"))
            myIntent.putExtra(Intent.EXTRA_SUBJECT,"Email subject")
            myIntent.putExtra(Intent.EXTRA_TEXT,"Email text")
            myIntent.resolveActivity(packageManager)?.let {
                startActivity(myIntent)
            } ?:
                Toast.makeText(this,R.string.MsgMail,Toast.LENGTH_LONG).show()
        }
    }
}
