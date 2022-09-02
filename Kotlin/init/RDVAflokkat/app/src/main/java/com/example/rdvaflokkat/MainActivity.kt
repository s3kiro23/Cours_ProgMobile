package com.example.rdvaflokkat

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val list: MutableList<String> = mutableListOf()
    private lateinit var spinner: Spinner
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cal = Calendar.getInstance()
        val editTextDate: TextView = findViewById(R.id.editTextDate)
        val btnCalendar: ImageButton = findViewById(R.id.calendar)
        spinner = findViewById(R.id.spinner)
        lifecycleScope.launch {
            val conseillers = AfflokatAPI.retrofitService.getConseillers()
            adapter = ArrayAdapter(baseContext, android.R.layout.simple_list_item_1, conseillers)
            spinner.adapter = adapter
        }

        fun updateDateInView() {
            val myFormat = "dd/MM/yyyy"
            val sdf = SimpleDateFormat(myFormat, Locale.FRENCH)
            editTextDate.text = sdf.format(cal.time)
        }

        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }

        btnCalendar.setOnClickListener {
            DatePickerDialog(
                this@MainActivity,
                dateSetListener,
                // set DatePickerDialog to point to today's date when it loads up
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        supportActionBar?.title = "RDV Aflokkat"
    }

}