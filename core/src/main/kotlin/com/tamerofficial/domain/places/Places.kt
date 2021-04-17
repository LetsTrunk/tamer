package com.tamerofficial.domain.places

import com.tamerofficial.domain.common.Location
import com.tamerofficial.domain.places.infra.ScoreAttributeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.onEmpty
import org.springframework.stereotype.Component

interface Places {
    suspend fun listPlaces(area:Area) : Flow<Place>
}

@Component
class PlacesApp(scoreRepo : ScoreAttributeRepository) : Places{

    /**
     * Param : Area
     * Return : Flow<Place>
     */
    override suspend fun listPlaces(area:Area): Flow<Place> {
        return emptyFlow()
    }
}