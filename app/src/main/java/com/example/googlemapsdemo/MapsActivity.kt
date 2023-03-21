package com.example.googlemapsdemo

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.googlemapsdemo.misc.CameraAndViewport
import com.example.googlemapsdemo.misc.TypeAndStyle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnPolylineClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, OnPolylineClickListener {
    private lateinit var map: GoogleMap
    private val typeAndStyle by lazy { TypeAndStyle() }
    private val cameraAndViewport by lazy { CameraAndViewport() }
    private val losAngeles = LatLng(34.04692127928215, -118.24748421830992)
    private val newYork = LatLng(40.712776, -74.005974)
    private val madrid = LatLng(40.42532590430832, -3.69053406427674)
    private val panama = LatLng(8.193200659375682, -9.482956329437389)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.map_types_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        typeAndStyle.setMapType(item, map)
        return true
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        val losAngelesMarker =
            map.addMarker(
                MarkerOptions()
                    .position(losAngeles)
                    .title("Marker in Los Angeles")
                    .snippet("Some random text")
            )

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(losAngeles, 10f))
        map.uiSettings.apply {
            isZoomControlsEnabled = true
        }
        typeAndStyle.setMapStyle(map, this)
        map.setOnPolylineClickListener(this)

        lifecycleScope.launch {
            addPolyline()
        }
    }

    private suspend fun addPolyline() {
        val polyline = map.addPolyline(
            PolylineOptions().apply {
                add(losAngeles, newYork, madrid)
                width(5f)
                color(Color.BLUE)
                geodesic(true)
                clickable(true)
            }
        )
        delay(5000L)
        val newList = listOf(
            losAngeles, panama, madrid
        )
        polyline.points = newList
    }

    override fun onPolylineClick(p0: Polyline) {
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
    }
}