package com.tamerofficial.app.places.dto

import com.tamerofficial.domain.common.Location

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

class PlaceSearchCriteria(
    val areaCode: String? = null,
    val subAreas: List<String> = emptyList(),
    val sortBy: SortBy = SortBy.SCORE,
    val distance: Long = 0,
    val currentLocation: Location? = null
){
    fun isAreaBase(): Boolean {
        return !areaCode.isNullOrEmpty()
    }

    fun isLocationBase(): Boolean {
        return areaCode.isNullOrEmpty() && distance > 0 && currentLocation != null
    }
}

enum class SortBy{
    SCORE,
    DISTANCE,
    VIEW_CNT,
    SCRAP_CNT
}
