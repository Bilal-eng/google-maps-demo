package com.example.googlemapsdemo.misc

import com.example.googlemapsdemo.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.GroundOverlay
import com.google.android.gms.maps.model.GroundOverlayOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds

class Overlays {

    private val losAngeles = LatLng(34.04692127928215, -118.24748421830992)
    private val losAngelesBounds = LatLngBounds(
        LatLng(33.94247408589402, -118.61360628599776),
        LatLng(34.16888863972872, -118.06840973469765)
    )

    fun addGroundOverlay(map: GoogleMap): GroundOverlay? {
        return map.addGroundOverlay(
            GroundOverlayOptions().apply {
//                position(losAngeles, 10000f, 10000f)
                positionFromBounds(losAngelesBounds)
                image(BitmapDescriptorFactory.fromResource(R.drawable.custom_marker))
            }
        )
    }

    fun addGroundOverlayWithTag(map: GoogleMap): GroundOverlay? {
        val groundOverlay = map.addGroundOverlay(
            GroundOverlayOptions().apply {
                positionFromBounds(losAngelesBounds)
                image(BitmapDescriptorFactory.fromResource(R.drawable.custom_marker))
            }
        )
        groundOverlay?.tag = "My Tag"
        return groundOverlay
    }

}