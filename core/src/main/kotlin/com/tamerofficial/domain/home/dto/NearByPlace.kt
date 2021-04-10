package com.tamerofficial.domain.home.dto

import com.tamerofficial.domain.common.Location
import com.tamerofficial.domain.common.Comment
import com.tamerofficial.domain.common.Review

data class NearByPlace(
    val placeId : Long,
    val name : String,
    val desc : String,
    val mainPicUrl : String,
    val location: Location,
    val reviews : List<Review>,
    val comments : List<Comment>
)