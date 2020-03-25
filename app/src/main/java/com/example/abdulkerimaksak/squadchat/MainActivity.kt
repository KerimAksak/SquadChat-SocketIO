package com.example.abdulkerimaksak.squadchat

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timerThread = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(1500)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    val intent = Intent(this@MainActivity, MessageActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        timerThread.start()
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}
