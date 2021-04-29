package com.tamerofficial.place.query

data class PlaceListViewDto(
    val placeId : Long,
    val placeName: String,
    val area: Area,
    val subArea: SubArea,
    val score: Score,
    val viewCount : Long,
    val scrapCount : Long,
    val isTrunk: Boolean
)