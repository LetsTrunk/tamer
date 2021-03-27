package com.tamerofficial.domain.home

import com.tamerofficial.domain.home.dto.Location
import com.tamerofficial.domain.home.dto.NearByPlace
import com.tamerofficial.domain.home.dto.RecommendKnowHow
import org.springframework.stereotype.Component


interface Home {
    suspend fun listNearByPlace(currentLocation : Location) : List<NearByPlace>
    suspend fun listRecommendKnowHow(loginId : String) : List<RecommendKnowHow>
}

@Component
class HomeApp : Home{
    override suspend fun listNearByPlace(currentLocation : Location) : List<NearByPlace>{
        return emptyList()
    }

    override suspend fun listRecommendKnowHow(loginId: String) : List<RecommendKnowHow> {
        return emptyList()
    }
}