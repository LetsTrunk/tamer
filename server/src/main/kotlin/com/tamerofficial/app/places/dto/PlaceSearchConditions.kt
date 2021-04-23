package com.tamerofficial.app.places.dto

import com.tamerofficial.common.Location


abstract class PlaceSearchConditions(
    open val sortBy : String
)

data class AreaBaseSearchCondition(
    val areaCode : String? = null,
    val subAreas : List<String> = emptyList(),
    override val sortBy: String = ""
) : PlaceSearchConditions(sortBy)

data class LocationBaseSearchCondition(
    val distanceFrom: DistanceFrom? = null,
    override val sortBy: String = ""
) : PlaceSearchConditions(sortBy)

data class DistanceFrom(
    val currentLocation: Location,
    val distance : Long // km 단위 고정
)
