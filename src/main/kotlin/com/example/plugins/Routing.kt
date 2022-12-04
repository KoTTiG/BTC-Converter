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
                try {
                    val value = call.parameters[VALUE]
                    if(value == null){
                        call.respondText("ERROR: No input value")
                    }else{
                        call.respondText((value.toString().toDouble() * usdPriceCall()).toString())
                    }
                } catch (e: NumberFormatException) {
                    call.respondText("ERROR: input value is not a number")
                }

                catch (e: NullPointerException) {
                    call.respondText("ERROR: Can't get the exchange rate")
                }

            }
            get("/convert/btc") {
                try {
                    val value = call.parameters[VALUE]
                    if(value == null){
                        call.respondText("ERROR: No input value")
                    }else{
                        call.respondText((value.toString().toDouble() * btcPriceCall()).toString())
                    }
                } catch (e: NumberFormatException) {
                    call.respondText("ERROR: input value is not a number")
                }

                catch (e: NullPointerException) {
                    call.respondText("ERROR: Can't get the exchange rate")
                }
            }

    }
}
