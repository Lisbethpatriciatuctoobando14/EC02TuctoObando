package com.lisbethtucto.calificada02_tuctoobando

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class Mapa : Fragment() {
    private lateinit var googleMap:GoogleMap
    private val ubicacion  = LatLng(-12.5770129, -80.1020314)
    private val ubicacion2  = LatLng(-12.6770129, -83.1020314)
    private val ubicacion3  = LatLng(-12.7770129, -86.1020314)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root:View = inflater.inflate(R.layout.fragment_mapa,container,false)
        val supportMapFragment = childFragmentManager.findFragmentById(R.id.myMap) as SupportMapFragment
        supportMapFragment.getMapAsync { map -> googleMap = map
            googleMap.addMarker(MarkerOptions().position(ubicacion).title("Marcador 1 Profesor"))
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, 15f))
            googleMap.addMarker(MarkerOptions().position(ubicacion2).title("Marcador 2 Alumno"))
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, 15f))
            googleMap.addMarker(MarkerOptions().position(ubicacion3).title("Marcador 3  Director"))
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, 15f))
        }
        return root
    }


    }
