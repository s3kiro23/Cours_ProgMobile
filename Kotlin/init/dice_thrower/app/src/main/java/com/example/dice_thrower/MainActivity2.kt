package com.example.dice_thrower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var value: Int = intent.getIntExtra("val_de", 0)

        val launcher: Button = findViewById(R.id.button2)
        val view: TextView = findViewById(R.id.tvValue)

        launcher.setOnClickListener {
            view.text = Random.nextInt(1, value+1).toString()
        }
    }
}