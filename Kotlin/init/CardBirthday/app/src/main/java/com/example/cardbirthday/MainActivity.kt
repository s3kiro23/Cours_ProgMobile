package com.example.cardbirthday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_layout)

        val btnLinear: Button = findViewById(R.id.linear)
        val btnRelative: Button = findViewById(R.id.relative)
        val btnConstraint: Button = findViewById(R.id.constraint)

        btnLinear.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("layout", R.layout.linear_layout)
            intent.putExtra("nameLayout", "en Linear")
            startActivity(intent)
        }
        btnRelative.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("layout", R.layout.relative_layout)
            intent.putExtra("nameLayout", "en Relative")
            startActivity(intent)
        }
        btnConstraint.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("layout", R.layout.constraint_layout)
            intent.putExtra("nameLayout", "en Constraint")
            startActivity(intent)
        }
    }
}