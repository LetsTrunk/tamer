package com.tamerofficial.app.trunking.dto

import com.tamerofficial.domain.trunking.dto.PostCategory

data class TrunkingPostForm(
    val postCategory: PostCategory,
    val title : String,
    val photos : List<String>,
    val contents : String
)