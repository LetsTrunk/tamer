package com.tamerofficial.domain.banner

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import org.springframework.stereotype.Component

interface Banner {
    suspend fun listBannerByType(type: String) : Flow<String>
}

@Component
class BannerApp : Banner{
    override suspend fun listBannerByType(type: String) : Flow<String> {
        return listOf("test").asFlow()
    }
}