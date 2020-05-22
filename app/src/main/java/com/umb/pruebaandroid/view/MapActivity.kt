package com.umb.pruebaandroid.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
import com.umb.pruebaandroid.R

class MapActivity:AppCompatActivity() {

    var markersArray:Array<Any> = arrayOf();


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.map_activity)
        val map:SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        map.getMapAsync{map ->
            map.setOnMapClickListener {
                map.clear()
               map.addMarker(MarkerOptions().position(it).title("Marker $it"))
            }
        }
    }

}