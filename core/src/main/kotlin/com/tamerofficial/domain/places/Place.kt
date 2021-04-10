package com.tamerofficial.domain.places

import com.tamerofficial.domain.common.Location
import com.tamerofficial.domain.common.Review

data class Place(
    val name: String,
    val placeId: Long,
    val areaId: Long,
    val location: Location,
    val address1: String,
    val address2: String,

    val score: Score,

    val imageUrls : List<String>,

    val isPicked: Boolean,// 인증장소 여부
    val reviewOverViews : List<OverviewAttribute>, // 리뷰 속성

    val filterAttributes: FilterAttribute, // 필터 속성

    val reviews : List<Review>
)
data class Score(
    val trunkScore : Long, //트렁크 평점
    val userScore : Long, //사용자 평점
)
data class OverviewAttribute(
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