package com.example.googlemapsdemo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.googlemapsdemo.misc.CameraAndViewport
import com.example.googlemapsdemo.misc.TypeAndStyle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map: GoogleMap
    private val typeAndStyle by lazy { TypeAndStyle() }
    private val cameraAndViewport by lazy { CameraAndViewport() }
    private val losAngeles = LatLng(34.04692127928215, -118.24748421830992)
    private val newYork = LatLng(40.712776, -74.005974)


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

        //Add a marker in Sydney and move the camera

//        val losAngeles2 = LatLng(34.1179935048758, -118.42551345366113)
//        val newYork = LatLng(40.712776, -74.005974)
        val losAngelesMarker =
            map.addMarker(
                MarkerOptions()
                    .position(losAngeles)
                    .title("Marker in Los Angeles")
                    .snippet("Some random text")
//                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.custom_marker))
//                    .icon(fromVectorToBitmap(R.drawable.ic_android, Color.parseColor("#0000FF")))
            )
//        val losAngelesMarker2 =
//            map.addMarker(
//                MarkerOptions()
//                    .position(losAngeles2)
//                    .title("Marker in Los Angeles2")
//                    .snippet("Some random text2")
//                    .zIndex(1f)
////                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.custom_marker))
////                    .icon(fromVectorToBitmap(R.drawable.ic_android, Color.parseColor("#0000FF")))
//            )

//        losAngelesMarker?.tag = "Restaurant"
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(losAngeles, 10f))
//        map.moveCamera(CameraUpdateFactory.newCameraPosition(cameraAndViewport.losAngeles))
        map.uiSettings.apply {
            isZoomControlsEnabled = true
        }
        typeAndStyle.setMapStyle(map, this)

//        map.setInfoWindowAdapter(CustomInfoAdapter(this))

//        map.setOnMarkerClickListener(this)
//        map.setOnMarkerDragListener(this)

//        map.setOnMarkerClickListener(this)

//        lifecycleScope.launch {
//            delay(4000L)
//            losAngelesMarker?.remove()
//        }

//        lifecycleScope.launch {
//            delay(4000L)
//            map.moveCamera(CameraUpdateFactory.newLatLng(newYork))
//        }

//        lifecycleScope.launch {
//            delay(4000L)
//            map.animateCamera(
//                CameraUpdateFactory.newCameraPosition(cameraAndViewport.losAngeles),
//                2000,
//                object : CancelableCallback {
//                    override fun onCancel() {
//                        Toast.makeText(this@MapsActivity, "Canceled", Toast.LENGTH_SHORT).show()
//                    }
//
//                    override fun onFinish() {
//                        Toast.makeText(this@MapsActivity, "Finished", Toast.LENGTH_SHORT).show()
//                    }
//
//                }
//            )
//            map.animateCamera(CameraUpdateFactory.scrollBy(200f, 0f), 2000, null)
//            map.moveCamera(CameraUpdateFactory.newLatLngZoom(cameraAndViewport.melbourneBounds.center, 10f))
//            map.animateCamera(
//                CameraUpdateFactory.newLatLngBounds(cameraAndViewport.melbourneBounds, 100), 2000,
//                null
//            )
//            map.setLatLngBoundsForCameraTarget(cameraAndViewport.melbourneBounds)
//        }

//        onMapClicked()
//        onMapLongClicked()
    }

//    override fun onMarkerClick(marker: Marker): Boolean {
//        map.animateCamera(CameraUpdateFactory.zoomTo(17f), 2000, null)
//        marker.showInfoWindow()
//        return true
//    }


//    override fun onMarkerDrag(p0: Marker) {
//        Log.d("Drag", "Drag")
//    }
//
//    override fun onMarkerDragEnd(p0: Marker) {
//        Log.d("Drag", "End")
//    }
//
//    override fun onMarkerDragStart(p0: Marker) {
//        Log.d("Drag", "Start")
//    }

//    override fun onMarkerClick(marker: Marker): Boolean {
//        marker.let {
//            Log.d("Marker", it.tag as String)
//        }
//        return false
//    }

//    private fun onMapClicked() {
//        map.setOnMapClickListener {
//            Toast.makeText(this, "Single Click", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    private fun onMapLongClicked() {
//        map.setOnMapLongClickListener {
//            map.addMarker(MarkerOptions().position(it).title("New Marker"))
//        }
//    }
}