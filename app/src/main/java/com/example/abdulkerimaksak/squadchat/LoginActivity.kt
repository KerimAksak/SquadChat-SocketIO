package com.example.abdulkerimaksak.squadchat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*



class LoginActivity : AppCompatActivity() {
    val context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            if(et_email.text.toString().isNotEmpty()){
                var user = User(et_email.text.toString())
                var db = DB(context)
                db.insertData(user)
                val intent = Intent(context, MessageActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(context,"Lütfen uygun bir e-mail yazın!",Toast.LENGTH_LONG)
            }
        }

    }

}
