package com.lisbethtucto.calificada02_tuctoobando

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lisbethtucto.calificada02_tuctoobando.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.agregar.setOnClickListener {
            val intent = Intent(this, Agregar::class.java)
            startActivity(intent)

        }

    }

}
