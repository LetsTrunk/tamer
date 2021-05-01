package com.tamerofficial.place.query

import com.tamerofficial.common.utils.safeValueOf
import org.apache.logging.log4j.util.Strings

enum class FilterType{
    CAMPING_TYPE,PLACE_TYPE,SCALE,COST,FACILITY
}

data class FilterAttributeDto(
    val filterAttrId: Long?,
    val name: String,
    val type: String
){
}