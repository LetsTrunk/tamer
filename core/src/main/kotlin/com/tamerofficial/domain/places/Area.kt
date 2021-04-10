package com.tamerofficial.domain.places

data class Area(
    val name: String,
    val areaCode: String,
    val areaId: Long,
    val subAreas: List<SubArea>
)

data class SubArea(
    val name: String,
    val subAreaId: Long,
    val subAreaCode: String,
    val areaId: Long,
)