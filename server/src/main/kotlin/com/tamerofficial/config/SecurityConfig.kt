package com.tamerofficial.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig {
//    @Bean
//    fun springSecurityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain? {
//        http
//            .csrf().disable()
//            .httpBasic().disable()
//            .formLogin().disable()
//            .authorizeExchange()
////            .pathMatchers("/**") // 임시로 다 풀어둠
////            .permitAll()
//            .pathMatchers("/api/**").authenticated()    // /api 하위 경로는 인증 필요, 인증안되었다면 로그인 이동
//            .pathMatchers(HttpMethod.POST, "/employees/update").hasRole("ADMIN")
//            .pathMatchers("/actuator/**").permitAll()
//            .anyExchange().permitAll()
//            .and()
//            .oauth2Login(Customizer.withDefaults())
//            .oauth2Client(Customizer.withDefaults())
//            .logout()
//
//        return http.build()
//    }
}