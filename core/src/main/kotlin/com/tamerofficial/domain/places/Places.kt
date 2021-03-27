package com.tamerofficial.domain.places

import org.springframework.stereotype.Component

interface Places {
    suspend fun listPlaces() : List<Any>
}

@Component
class PlacesApp : Places{
    override suspend fun listPlaces(): List<Any> {
        TODO("Not yet implemented")
    }
}