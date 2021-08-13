package com.tamerofficial.place.query.dto

import com.tamerofficial.common.Location
import com.tamerofficial.place.command.domain.Review

data class PlaceViewDto(
    val placeId: Long, // PK
    val name: String,
    val area: Area, //도, 특별시
    val subArea: SubArea, //시 군 구
    val location: Location,
    val distanceFrom : Long = 0, // 현재 위치 부터 거리
    val address: Address, // 주소 정보
    val imageUrls : List<String> = mutableListOf(), //max 5개
    val scoreAttribute: ScoreAttribute? = null, // 리뷰 속성
    val filterAttributes: List<FilterAttribute> = mutableListOf(), // 필터 속성
    val reviews : List<Review> = mutableListOf()
)

data class Address(
    val address1: String,
    val address2: String
)

data class Score(
    val trunkScore : Long, //트렁크 평점
    val userScore : Long, //사용자 평점
)

data class ScoreAttribute(
    val isTrunk : Boolean = false,
    val levelScore: Long,
    val facilitiesScore : Long,
    val viewScore : Long,
    val accessibilityScore: Long,
    val roughnessScore : Long,
    val crowdingScore : Long
)

data class Facility(val name: String)