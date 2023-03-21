package com.example.googlemapsdemo.misc

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds

class CameraAndViewport {

    val losAngeles: CameraPosition = CameraPosition.Builder()
        .target(LatLng(34.04692127928215, -118.24748421830992))
        .zoom(17f)
        .bearing(100f)
        .tilt(45f)
        .build()

    val melbourneBounds = LatLngBounds(
        LatLng(-38.448867095718064, 144.24439867221955), //SW
        LatLng(-37.50276422979916, 145.5407854161322) //NE
    )
}