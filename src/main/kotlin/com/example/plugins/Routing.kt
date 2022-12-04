package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
val BTC = "BTC"
fun Application.configureRouting() {

    // Starting point for a Ktor app:
    routing {
        get("/convert") {
            val btc = call.parameters[BTC]
            call.respondText("Hello World!")
        }
    }
    routing {
    }
}
