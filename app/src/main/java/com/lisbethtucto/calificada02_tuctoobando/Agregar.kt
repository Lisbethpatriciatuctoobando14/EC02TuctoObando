package com.lisbethtucto.calificada02_tuctoobando

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.*
import com.lisbethtucto.calificada02_tuctoobando.databinding.ActivityAgregarBinding

class Agregar : AppCompatActivity() {
    private lateinit var binding: ActivityAgregarBinding
    private lateinit var openCameraLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgregarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.foto.setOnClickListener {
            if (permissionValidated()) {
                openCamera()
            }
        }
        openCameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val photo: Bitmap = result.data?.extras?.get("data") as Bitmap
                binding.agregada.setImageBitmap(photo)
            }

        }

        binding.ubicacion.setOnClickListener {
            val intent= Intent(this, Ubicar::class.java)
            startActivity(intent)

        }

    }
    private fun permissionValidated(): Boolean {
        val cameraPermission = checkSelfPermission(this, Manifest.permission.CAMERA)
        val permissionList: MutableList<String> = mutableListOf()
        if (cameraPermission != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.CAMERA)
        }
        if (permissionList.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permissionList.toTypedArray(), 1000)
            return false
        }

        return true
    }

    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
    )   {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            when (requestCode) {
                1000 -> {
                    if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                        openCamera()
                    } else {
                        Toast.makeText(this, "Acceso Denegado", Toast.LENGTH_SHORT).show()
                    }

                }
            }

    }

    private fun openCamera(){
        val intent = Intent()
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE)
        openCameraLauncher.launch(intent)
    }

    }






