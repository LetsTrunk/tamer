package com.tamerofficial.app.places

import com.tamerofficial.domain.places.Area
import com.tamerofficial.domain.places.Place
import com.tamerofficial.domain.places.Places
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service

@Service
class PlaceService(private val placeApp: Places) {
    suspend fun placePage(): PlacePage = coroutineScope {
        val areas = async { placeApp.listAreas() }
        val places = async { placeApp.listPlaces(Area(name="서울특별시",areaCode="SEOUL",areaId=1L)) }
        PlacePage(areas.await().toList(), emptyList(), places.await().toList())
    }
}

data class PlacePage(
    val areas: List<Area>,
    val banners: List<Any>,
    val places: List<Place>
)