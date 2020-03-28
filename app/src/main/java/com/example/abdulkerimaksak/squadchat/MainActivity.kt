package com.example.abdulkerimaksak.squadchat

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this
        var db = DB(context)
        var user = User()

        var email:String = ""

        var data =db.readData()
        for(i in 0..(data.size-1)){
            email = data.get(i).email
        }

        val timerThread = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(1500)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    if(email == ""){
                        val intent = Intent(this@MainActivity, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else {
                        val intent = Intent(this@MainActivity, MessageActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
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
