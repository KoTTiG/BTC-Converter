package com.example

import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject


private val COINBASE_API_URL = "https://api.coindesk.com/v1/bpi/currentprice/BTC.json"

fun btcPriceCall(): Double {
    val client = OkHttpClient()
    val httpUrl = COINBASE_API_URL.toHttpUrl()
    val request = Request.Builder().url(httpUrl).build()
    val response = client.newCall(request).execute()
    val body = response.body?.string()
    val json = JSONObject(body)
    val price = json.getJSONObject("bpi")
        .getJSONObject("USD")
        .getString("rate").replace(",", "").toDouble()
    return price
}

fun usdPriceCall(): Double {
    val client = OkHttpClient()
    val httpUrl = COINBASE_API_URL.toHttpUrl()
    val request = Request.Builder().url(httpUrl).build()
    val response = client.newCall(request).execute()
    val body = response.body?.string()
    val json = JSONObject(body)
    val price = json.getJSONObject("bpi")
        .getJSONObject("USD")
        .getString("rate").replace(",", "").toDouble()

    return (1.0 / price)
}