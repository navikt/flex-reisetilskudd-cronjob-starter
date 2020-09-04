package no.nav.helse.flex

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandlers

val log: Logger = LoggerFactory.getLogger("no.nav.helse.flex.flex-reisetilskudd-cronjob-starter")

fun main() {
    log.info("Starter flex-reisetilskudd-cronjob-starter")

    try {
        val request = HttpRequest.newBuilder()
            .uri(URI.create("http://flex-reisetilskudd-backend/isAlive"))
            .GET()
            .build()

        val client: HttpClient = HttpClient.newBuilder()

            .build()
        val response: HttpResponse<String> = client.send(request, BodyHandlers.ofString())
        log.info(" Response code " + response.statusCode())
        log.info(response.body())
    } catch (e: Exception) {
        log.error("opps,", e)
    }
}
