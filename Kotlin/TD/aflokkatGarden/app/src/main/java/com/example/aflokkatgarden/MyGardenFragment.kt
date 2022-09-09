package com.example.aflokkatgarden

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.lang.reflect.Type

class MyGardenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val jsonText = context?.assets?.open("plantes.json")?.bufferedReader().use{it?.readText()}

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val listMyData : Type = Types.newParameterizedType(
            List::class.java,
            Plant::class.java
        )
        val type : Type = Types.newParameterizedType(List::class.java, Plant::class.java)
        val adapter = jsonText?.let { jsonAdapter.fromJson(it) }

        return inflater.inflate(
            R.layout.plant_row, container, false
        )
    }
}