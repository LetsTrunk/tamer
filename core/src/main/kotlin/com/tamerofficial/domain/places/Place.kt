package com.tamerofficial.domain.places

import com.tamerofficial.domain.common.Location

data class Place(
    val name: String,
    val placeId: Long,
    val areaId: Long,
    val location: Location,
    val address1: String,
    val address2: String,
    val isPicked: Boolean
)