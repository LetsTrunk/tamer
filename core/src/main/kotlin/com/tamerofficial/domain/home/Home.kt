package com.tamerofficial.domain.home

import com.tamerofficial.domain.home.dto.Location
import com.tamerofficial.domain.home.dto.NearByPlace
import com.tamerofficial.domain.home.dto.RecommendKnowHow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import org.springframework.stereotype.Component


interface Home {
    suspend fun listNearByPlace(currentLocation : Location) : Flow<NearByPlace>
    suspend fun listRecommendKnowHow(loginId : String) : Flow<RecommendKnowHow>
}

@Component
class HomeApp : Home{
    override suspend fun listNearByPlace(currentLocation : Location) : Flow<NearByPlace>{
        return listOf(
            NearByPlace(
                1,
                "test",
                "descTest",
                "https://www.naver.com",
                Location(1,1),
                emptyList(),
                emptyList()
            )
        ).asFlow()
    }

    override suspend fun listRecommendKnowHow(loginId: String) : Flow<RecommendKnowHow> {
        return emptyList<RecommendKnowHow>().asFlow()
    }
}