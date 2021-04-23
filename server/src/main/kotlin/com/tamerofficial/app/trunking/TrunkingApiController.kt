package com.tamerofficial.app.trunking

import com.tamerofficial.common.Log
import com.tamerofficial.common.ResponseEntity
import com.tamerofficial.trunking.dto.PostCategory
import com.tamerofficial.trunking.dto.TrunkingPost
import com.tamerofficial.trunking.dto.Writer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/trunking")
@RestController
class TrunkingApiController {

    companion object : Log

    /**
     * 이번주 인기 게시물
     */
    @GetMapping("/hot-posts-of-week")
    suspend fun hotPostsOfWeek() : ResponseEntity<List<TrunkingPost>> {
        return ResponseEntity("","",emptyList())
    }

    /**
     * 최근 업로드 API
     */
    @GetMapping("/recently-posted")
    suspend fun recentlyPosted() : ResponseEntity<List<TrunkingPost>> {
        return ResponseEntity("","", emptyList())
    }

    /**
     * 더 살펴보기 (트렁킹)
     */
    @GetMapping("/list/trunking-posts")
    suspend fun listTrunkingPosts() : ResponseEntity<List<TrunkingPost>> {
        return ResponseEntity("","", emptyList())
    }
}