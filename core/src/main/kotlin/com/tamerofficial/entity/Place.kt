package com.tamerofficial.entity

data class Place(
    val placeId : Long,
    val name : String,
    val desc : String,
    val mainPicUrl : String,
    val mapData: MapData,
    val reviews : List<Review>,
    val comments : List<Comment>
)