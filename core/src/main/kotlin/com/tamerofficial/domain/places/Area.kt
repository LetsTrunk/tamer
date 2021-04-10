package com.tamerofficial.domain.places

data class Area(
    val areaId: Long,
    val name: String,
    val areaCode: String,
    val subAreas: List<SubArea>
)

data class SubArea(
    val name: String,
    val subAreaId: Long,
    val subAreaCode: String,
    val areaId: Long,
)