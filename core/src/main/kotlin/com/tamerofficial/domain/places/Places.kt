package com.tamerofficial.domain.places

import com.tamerofficial.domain.common.Location
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.onEmpty
import org.springframework.stereotype.Component

interface Places {
    suspend fun listPlaces(area:Area) : Flow<Place>
}

@Component
class PlacesApp : Places{

    /**
     * Param : Area
     * Return : Flow<Place>
     */
    override suspend fun listPlaces(area:Area): Flow<Place> {
        return emptyFlow()
    }
}