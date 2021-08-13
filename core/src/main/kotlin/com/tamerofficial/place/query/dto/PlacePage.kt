package com.tamerofficial.place.query.dto

import java.math.BigDecimal

data class PlacePage(
    val areaList : List<Area> = listOf(
        Area(0,"서울특별시"),
        Area(1,"경기도"),
        Area(2,"충청도"),
        Area(3,"강원도")
    ),
    val bannerList : List<Banner> = listOf(),
    val orderList : List<Order> = listOf(),
    val filterList : List<FilterAttributeDto> = listOf(),
    val placeList : List<Place> = listOf(),
    val distanceList : List<Distance> = listOf(
        Distance("10Km",10),
        Distance("30Km",30),
        Distance("100Km",100)
    ),
    val pageInfo : PageInfo = PageInfo(0, 20)
)

data class Distance(
    val title : String,
    val distance : Int
)
data class Order(
    val orderName: String,
    val displayName : String
)

data class PageInfo(
    val current : Long,
    val pageSize : Long
)

data class Banner(
    val id: Long,
    val name: String,
    val imageUrl : String
)

data class Place(
    val id : Long,
    val score: Double,
    val isTrunk: Boolean,
    val title : String,
    val areaName : String,
    val scrapCount : Long,
    val viewCount : Long,
    val reviewCount : Long,
    var location : LatLon
)
data class LatLon(
    val lat : BigDecimal,
    val lon : BigDecimal
)
data class FilterAttribute(
    val campingType: String, // car, carpicnic, camping
    val placeType: String, //mountain, sea, valley, reservoir ,river, lake
    val scale: String,
    val prices: Long, //1회 기준으로 산정하자 시간당으로 매기는곳 없음
    val facilities : List<Facility>
)