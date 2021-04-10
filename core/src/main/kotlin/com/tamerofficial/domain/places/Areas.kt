package com.tamerofficial.domain.places

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import org.springframework.stereotype.Component

interface Areas {
    suspend fun listAreas(): Flow<Area>
}

@Component
class AreasApp : Areas{
    /**
     * Return : Flow<Area>
     */
    override suspend fun listAreas(): Flow<Area> {
        return listOf(
            Area(name="서울특별시",areaCode="SEOUL",areaId=1L
                , subAreas = emptyList()
            ),
            Area(name="경기도",areaCode="KYUNGKI",areaId=2L, subAreas = emptyList()),
            Area(name="강원도",areaCode="KANGYON",areaId=3L, subAreas = emptyList())
        ).asFlow()
    }
}