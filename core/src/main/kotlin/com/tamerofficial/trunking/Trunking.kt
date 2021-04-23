package com.tamerofficial.trunking

import com.tamerofficial.trunking.dto.TrunkingPost
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Component

/**
 * As Aggregate
 */
interface Trunking{
    suspend fun hotPostsOfWeek() : Flow<TrunkingPost>
    suspend fun listRecentlyPosted() : Flow<TrunkingPost>
    suspend fun listTrunking() : Flow<TrunkingPost>
}

@Component
class TrunkingApp : Trunking {
    override suspend fun hotPostsOfWeek(): Flow<TrunkingPost> {
        TODO("Not yet implemented")
    }
    override suspend fun listRecentlyPosted() : Flow<TrunkingPost>{
        TODO("Not yet implemented")
    }
    override suspend fun listTrunking(): Flow<TrunkingPost> {
        TODO("Not yet implemented")
    }
}