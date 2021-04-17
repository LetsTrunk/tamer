package com.tamerofficial.config

import com.tamerofficial.common.Log
import io.netty.channel.ChannelOption
import io.netty.handler.ssl.SslContextBuilder
import io.netty.handler.ssl.util.InsecureTrustManagerFactory
import io.netty.handler.timeout.ReadTimeoutHandler
import io.netty.handler.timeout.WriteTimeoutHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.http.codec.LoggingCodecSupport
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientManager
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientProvider
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientProviderBuilder
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository
import org.springframework.security.oauth2.client.web.DefaultReactiveOAuth2AuthorizedClientManager
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository
import org.springframework.web.reactive.function.client.ExchangeFilterFunction
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import reactor.netty.http.client.HttpClient

@Configuration
class WebClientConfig {
    companion object : Log

    @Bean
    fun webClient(authorizedClientManager: ReactiveOAuth2AuthorizedClientManager): WebClient {
        val oauth: ServerOAuth2AuthorizedClientExchangeFilterFunction =
            ServerOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientManager)

        val exchangeStrategies: ExchangeStrategies = ExchangeStrategies.builder()
            .codecs { configurer -> configurer.defaultCodecs().maxInMemorySize(1024 * 1024 * 50) }
        .build()

        exchangeStrategies
            .messageWriters().stream()
            .filter { LoggingCodecSupport::class.java.isInstance(it) }
            .forEach { writer -> (writer as LoggingCodecSupport).isEnableLoggingRequestDetails = true }

        return WebClient.builder()
            .clientConnector(
                ReactorClientHttpConnector(
                    HttpClient
                        .create()
                        .secure { sslContextSpec ->   //Stream 처리에서 Exception 처리를 위한 ThrowingConsumer Util 있다
                            sslContextSpec.sslContext(
                                SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE)
                                    .build()
                            )
                        }
                        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 120000)
                                .doOnConnected { conn ->
                                    conn.addHandlerLast(ReadTimeoutHandler(180))
                                        .addHandlerLast(WriteTimeoutHandler(180))
                                }
                )
            )
            .exchangeStrategies(exchangeStrategies)
            .filter(ExchangeFilterFunction.ofRequestProcessor { clientRequest ->
                    logger.debug("Request: {} {}", clientRequest.method(), clientRequest.url())
                    clientRequest.headers()
                        .forEach { name, values -> values.forEach { value -> logger.debug("{} : {}", name, value) } }
                    Mono.just(clientRequest)
                })
            .filter(ExchangeFilterFunction.ofResponseProcessor { clientResponse ->
                clientResponse.headers().asHttpHeaders()
                    .forEach { name, values -> values.forEach { value -> logger.debug("{} : {}", name, value) } }
                Mono.just(clientResponse)
            })
            .filter(oauth)
//            .defaultHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.87 Safari/537.3")
            .build()

    }

    @Bean
    fun authorizedClientManager(clientRegistrationRepository: ReactiveClientRegistrationRepository,
    authorizedClientRepository: ServerOAuth2AuthorizedClientRepository): ReactiveOAuth2AuthorizedClientManager {

        val authorizedClientProvider: ReactiveOAuth2AuthorizedClientProvider =
            ReactiveOAuth2AuthorizedClientProviderBuilder.builder()
                .authorizationCode()
                .build()

        val authorizedClientManager: DefaultReactiveOAuth2AuthorizedClientManager =
            DefaultReactiveOAuth2AuthorizedClientManager(clientRegistrationRepository, authorizedClientRepository)

        authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider)

        return authorizedClientManager
    }
}