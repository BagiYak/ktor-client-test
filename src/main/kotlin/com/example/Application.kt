
package com.example

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

suspend fun main() {

    val client = HttpClient(CIO)
    val response: HttpResponse = client.get("https://ktor.io/")
    println(response.status)
    println(response.responseTime)
    println(response.version)
    println("-------------")

    val responseServer: HttpResponse = client.get("http://0.0.0.0:8080")
    println(responseServer)
    println(responseServer.status)
    println(responseServer.responseTime)
    println(responseServer.version)
    println(responseServer.call)
    println(responseServer.readText())

    client.close()
}
