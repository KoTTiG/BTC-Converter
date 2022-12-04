package com.example.plugins

import com.example.btcPriceCall
import com.example.usdPriceCall
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

const val VALUE = "value"
fun Application.configureRouting() {

    // Starting point for a Ktor app:
    routing {
        get("/convert/usd") {
            val value = call.parameters[VALUE]
            call.respondText((value.toString().toDouble() * usdPriceCall()).toString())
        }
        get("/convert/btc") {
            val value = call.parameters[VALUE]
            call.respondText((value.toString().toDouble() * btcPriceCall()).toString())
        }
    }
}
