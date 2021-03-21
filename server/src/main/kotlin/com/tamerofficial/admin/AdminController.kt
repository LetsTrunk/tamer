package com.tamerofficial.admin

import com.tamerofficial.entity.User
import com.tamerofficial.entity.UserRepository
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AdminController {
    //As Sample of usage of R2DBC with Coroutine and Webflux
    // Mono -> awaitSingle
    // Flux -> asFlow
    @Autowired
    lateinit var userRepository: UserRepository

    @FlowPreview
    @GetMapping("/hello")
    suspend fun hello() : Flow<User>? {
        var result = userRepository.findAll()
        return result.asFlow()
    }
}