package com.tamerofficial.app.places.dto

import com.tamerofficial.common.Location


abstract class PlaceSearchRequest(
    open val currentLocation: Location,
    open val distance : Long,// km 단위 고정
    open val sortBy : String
)

data class AreaBaseSearchRequest(
    val areaCode : String? = null,
    val subAreas : List<String> = emptyList(),
    override val currentLocation: Location,
    override val distance : Long,// km 단위 고정
    override val sortBy: String = ""
) : PlaceSearchRequest(currentLocation, distance, sortBy)

data class LocationBaseSearchRequest(
    override val currentLocation: Location,
    override val distance : Long,// km 단위 고정
    override val sortBy: String = ""
) : PlaceSearchRequest(currentLocation, distance, sortBy)
