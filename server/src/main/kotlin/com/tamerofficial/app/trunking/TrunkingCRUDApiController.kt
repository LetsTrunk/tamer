package com.tamerofficial.app.trunking

import com.tamerofficial.app.trunking.dto.TrunkingPostForm
import com.tamerofficial.common.Log
import com.tamerofficial.common.ResponseEntity
import com.tamerofficial.domain.trunking.dto.PostCategory
import com.tamerofficial.domain.trunking.dto.TrunkingPost
import com.tamerofficial.domain.trunking.dto.Writer
import org.springframework.web.bind.annotation.*

@RequestMapping("/trunking/detail")
@RestController
class TrunkingCRUDApiController {

    companion object : Log

    /**
     * 상세보기
     * pathVariable : postId
     * everyone can query
     */
    @GetMapping("/trunking-post/{postId}")
    suspend fun detailTrunkingPost(@PathVariable("postId") postId : Long) : ResponseEntity<TrunkingPost> {
        return ResponseEntity("","",
            TrunkingPost(
                PostCategory(1,"",""),
                Writer("","","",""),
                "",
                emptyList(),"",
                emptyList()
            )
        )
    }

    /**
     * 새 게시글 작성
     */
    @PostMapping
    suspend fun createTrunkingPost(@RequestBody trunkingPostForm : TrunkingPostForm) : ResponseEntity<TrunkingPost> {
        //should get login user info

        return ResponseEntity("","",
            TrunkingPost(
                PostCategory(1,"",""),
                Writer("","","",""),
                "",
                emptyList(),"",
                emptyList()
            )
        )
    }

    /**
     * 게시글 수정 ( 작성자,관리자 )
     */
    @PutMapping("/trunking-post/{postId}")
    suspend fun modifyTrunkingPost(
        @PathVariable("postId") postId : Long,
        @RequestBody trunkingPostForm : TrunkingPostForm
    ) : ResponseEntity<TrunkingPost> {
        //should check requestBy post Owner

        return ResponseEntity("","",
            TrunkingPost(
                PostCategory(1,"",""),
                Writer("","","",""),
                "",
                emptyList(),"",
                emptyList()
            )
        )

    }

    /**
     * 게시글 삭제 ( 작성자,관리자 )
     */
    @DeleteMapping("/trunking-post/{postId}")
    suspend fun deleteTrunkingPost(
        @PathVariable("postId") postId : Long
    ) : ResponseEntity<TrunkingPost> {
        //should check requestBy post Owner

        return ResponseEntity("","",
            TrunkingPost(
                PostCategory(1,"",""),
                Writer("","","",""),
                "",
                emptyList(),"",
                emptyList()
            )
        )

    }

}