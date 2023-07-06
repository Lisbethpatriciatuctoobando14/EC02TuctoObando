package com.lisbethtucto.calificada02_tuctoobando

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import androidx.activity.result.ActivityResultLauncher
import com.lisbethtucto.calificada02_tuctoobando.databinding.ActivityAgregarBinding
import com.lisbethtucto.calificada02_tuctoobando.databinding.ActivityUbicarBinding

class Ubicar : AppCompatActivity() {
    private lateinit var binding: ActivityUbicarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUbicarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment=Mapa()
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout,fragment).commit()

    }



}


