package com.tamerofficial.place.query

import com.tamerofficial.common.Location

abstract class PlaceSearchConditions(
    open val distanceFrom : DistanceFrom? = null,
    open val sortBy : String,
    open val from : Long = 0,
    open val to : Long = 50
)

data class AreaBaseSearchCondition(
    val areaCode : String? = null,
    val subAreas : List<String> = emptyList(),
    override val distanceFrom: DistanceFrom? = null,
    override val sortBy: String = ""
) : PlaceSearchConditions(distanceFrom,sortBy)

data class LocationBaseSearchCondition(
    override val distanceFrom: DistanceFrom? = null,
    override val sortBy: String = ""
) : PlaceSearchConditions(distanceFrom,sortBy)

data class DistanceFrom(
    val currentLocation: Location,
    val distance : Long // km 단위 고정
)
