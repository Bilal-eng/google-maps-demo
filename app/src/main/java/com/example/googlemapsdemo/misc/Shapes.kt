package com.example.googlemapsdemo.misc

import android.graphics.Color
import com.example.googlemapsdemo.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolygonOptions
import com.google.android.gms.maps.model.PolylineOptions
import kotlinx.coroutines.delay

class Shapes {
    private val losAngeles = LatLng(34.04692127928215, -118.24748421830992)
    private val newYork = LatLng(40.712776, -74.005974)
    private val madrid = LatLng(40.42532590430832, -3.69053406427674)
    private val panama = LatLng(8.193200659375682, -9.482956329437389)

    private val p0 = LatLng(34.31585607530885, -118.68535400583764)
    private val p1 = LatLng(34.32719790029342, -117.91768430262161)
    private val p2 = LatLng(33.955527130370804, -117.74190304678682)
    private val p3 = LatLng(33.85978848674406, -118.98335816612007)

    private val p00 = LatLng(34.14072896660155, -118.54224319386391)
    private val p01 = LatLng(34.1179935048758, -118.01764600848195)
    private val p02 = LatLng(33.80704397172693, -118.2140266302349)
    private val p03 = LatLng(33.95183953811274, -118.4213935804775)


    private suspend fun addPolyline(map: GoogleMap) {
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
        polyline.points = listOf(losAngeles, panama, madrid)
    }

    fun addPolygon(map: GoogleMap) {
        val polygon = map.addPolygon(
            PolygonOptions().apply {
                add(p0, p1, p2, p3)
                fillColor(R.color.black)
                strokeColor(R.color.black)
            }
        )

        val polygon2 = map.addPolygon(
            PolygonOptions().apply {
                add(p00, p01, p02, p03)
                fillColor(R.color.black)
                strokeColor(R.color.black)
            }
        )
    }

    suspend fun addCircle(map: GoogleMap) {
        val circle = map.addCircle(
            CircleOptions().apply {
                center(losAngeles)
                radius(50000.0)
                fillColor(R.color.purple_500)
                strokeColor(R.color.purple_500)
            }
        )

        delay(4000L)

        circle.fillColor = R.color.black
    }

}