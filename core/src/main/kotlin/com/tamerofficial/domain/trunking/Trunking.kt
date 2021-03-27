package com.tamerofficial.domain.trunking

import com.tamerofficial.domain.trunking.dto.TrunkingPost
import org.springframework.stereotype.Component

/**
 * As Aggregate
 */
interface Trunking{
    suspend fun hotPostOfWeek() : List<TrunkingPost>
    suspend fun listRecentlyPosted() : List<TrunkingPost>
    suspend fun listTrunking() : List<TrunkingPost>
}

@Component
class TrunkingApp : Trunking{
    override suspend fun hotPostOfWeek(): List<TrunkingPost> {
        TODO("Not yet implemented")
    }
    override suspend fun listRecentlyPosted() : List<TrunkingPost>{
        TODO("Not yet implemented")
    }
    override suspend fun listTrunking(): List<TrunkingPost> {
        TODO("Not yet implemented")
    }
}