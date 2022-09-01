package com.example.dice_thrower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn6 : Button =  findViewById(R.id.btn6faces)
        val btn20 : Button =  findViewById(R.id.btn20faces)

        btn6.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("val_de", 6)
            startActivity(intent)
        }
        btn20.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("val_de", 20)
            startActivity(intent)
        }

    }
}