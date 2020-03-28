package com.example.abdulkerimaksak.squadchat

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "LocalDB"
val TABLE_NAME = "Users"
val COL_ID = "id"
val COL_EMAIL = "eposta"

class DB(var context: Context):SQLiteOpenHelper(context, DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE" + TABLE_NAME +" ("+
                COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_EMAIL + " VARCHAR(256) )";

        db?.execSQL(createTable)//=??
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData(user : User){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_EMAIL, user.email)
        var result = db.insert(TABLE_NAME,null,cv)
        if (result == -1.toLong())
            Toast.makeText(context, "HATA",Toast.LENGTH_LONG).show()
        else
            Toast.makeText(context, "BAŞARILI",Toast.LENGTH_LONG).show()

    }

    fun readData() : MutableList<User>{
        var list : MutableList<User> = ArrayList()

        val db = this.readableDatabase //val PI
        val query = "Select * from " + TABLE_NAME
        val result = db.rawQuery(query,null)

        if(result.moveToFirst()){
            do {
                var user = User()
                user.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                user.email = result.getString(result.getColumnIndex(COL_EMAIL))
                list.add(user)
            }while (result.moveToNext())
        }

        result.close()
        db.close()
        return  list
    }

}