package com.tamerofficial.place.query.dto

enum class FilterType{
    CAMPING_TYPE,PLACE_TYPE,SCALE,COST,FACILITY
}

data class FilterAttributeDto(
    val filterAttrId: Long,
    val displayName: String,
    val name: String,
    val type: String
)