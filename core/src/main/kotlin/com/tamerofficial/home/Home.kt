package com.tamerofficial.home

import com.tamerofficial.common.Location
import com.tamerofficial.common.Log
import com.tamerofficial.home.query.dto.NearByPlace
import com.tamerofficial.home.query.dto.RecommendKnowHow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import org.springframework.stereotype.Component


interface Home {
    suspend fun listNearByPlace(currentLocation : Location) : Flow<NearByPlace>
    suspend fun listRecommendKnowHow(loginId : String) : Flow<RecommendKnowHow>
}

@Component
class HomeApp : Home{
    companion object : Log
    override suspend fun listNearByPlace(currentLocation : Location) : Flow<NearByPlace>{
        logger.info(currentLocation.toString())
        return listOf(
            NearByPlace(1L,"장소이름")
        ).asFlow()
    }

    override suspend fun listRecommendKnowHow(loginId: String) : Flow<RecommendKnowHow> {
        return emptyList<RecommendKnowHow>().asFlow()
    }
}