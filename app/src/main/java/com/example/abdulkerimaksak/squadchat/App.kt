package com.example.abdulkerimaksak.squadchat

import android.app.Application
import com.github.nkzawa.socketio.client.IO
import com.github.nkzawa.socketio.client.Socket


/*
    Birden fazla ekranlar için her seferde socket çağırmak yerine
    Application dan bir sınıf oluşturuluyor. Ve tek bir socket üzerinden
    bağlantıyı sağlamış olacağız.
 */
class App : Application() {
    companion object {
        lateinit var socket: Socket//static değişken
    }
    private var url = "http://192.168.1.36:3000"

    override fun onCreate() {
        super.onCreate()
        socket = IO.socket(url)
        socket.connect()
    }
}