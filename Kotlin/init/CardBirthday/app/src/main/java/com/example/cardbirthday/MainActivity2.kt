package com.example.cardbirthday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fetchLayout = intent.getIntExtra("layout",0)
        val fetchNameLayout = intent.getIntExtra("nameLayout", 0)
        Log.d("main", "layout=$fetchLayout")
        setContentView(fetchLayout)
        supportActionBar?.title = "$fetchNameLayout"
    }
}