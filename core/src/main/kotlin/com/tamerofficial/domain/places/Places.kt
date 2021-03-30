package com.tamerofficial.domain.places

import com.tamerofficial.domain.common.Location
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import org.springframework.stereotype.Component

interface Places {
    suspend fun listAreas() : Flow<Area>
    suspend fun listPlaces(area:Area) : Flow<Place>
}

@Component
class PlacesApp : Places{
    /**
     * Return : Flow<Area>
     */
    override suspend fun listAreas(): Flow<Area> {
        return listOf(
            Area(name="서울특별시",areaCode="SEOUL",areaId=1L),
            Area(name="경기도",areaCode="KYUNGKI",areaId=2L),
            Area(name="강원도",areaCode="KANGYON",areaId=3L)
        ).asFlow()
    }

    /**
     * Param : Area
     * Return : Flow<Place>
     */
    override suspend fun listPlaces(area:Area): Flow<Place> {
        return listOf(
            Place(name="김동원집앞",1L,1L, Location(1,2),"서울특별시 강남구 대치동","xxx-xx", true),
            Place(name="난지캠핑장",2L,2L,Location(1,2),"서울특별시 강남구 대치동","xxx-xx", true),
            Place(name="동해바다",3L,3L,Location(1,2),"서울특별시 강남구 대치동","xxx-xx", true),
        ).asFlow()
    }
}