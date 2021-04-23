package com.tamerofficial.place.query

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
    val score: Score? = null, // 평점 (트렁트, 사용자)
    val imageUrls : List<String> = mutableListOf(), //max 5개
    val reviewAttribute: List<ReviewAttribute> = mutableListOf(), // 리뷰 속성
    val filterAttributes: FilterAttribute? = null, // 필터 속성
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

data class ReviewAttribute(
    val isTrunk : Boolean = false,
    val levelScore: Long,
    val facilitiesScore : Long,
    val viewScore : Long,
    val accessibilityScore: Long,
    val roughnessScore : Long,
    val crowdingScore : Long
)
data class FilterAttribute(
    val campingType: String, // car, carpicnic, camping
    val placeType: String, //mountain, sea, valley, reservoir ,river, lake
    val scale: String,
    val prices: Long, //1회 기준으로 산정하자 시간당으로 매기는곳 없음
    val facilities : List<Facility>
)

data class Facility(val name: String)