package com.tamerofficial.domain.trunking.dto

import com.tamerofficial.domain.common.Comment

data class TrunkingPost(
    val category: PostCategory,
    val createdBy : Writer,
    val title : String,
    val photos : List<Photo>,
    val content : String,
    val comments : List<Comment> // 별도로 로딩하도록 수정 할 수도 있음
)

data class Writer(
    val loginId : String,
    val nickName : String,
    val level: String,
    val profilePhotoUrl : String
    //... add more fields
)

data class Photo(
    val url : String,
    val isMain : Boolean
)