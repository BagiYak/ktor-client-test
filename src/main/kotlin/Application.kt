
package com.example

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

suspend fun main() {

    val client = HttpClient(CIO) {
        install(Logging)
    }

    val response: HttpResponse = client.get("https://ktor.io/")
    println(response)
    println(response.status)
    println(response.responseTime)
    println(response.version)
    println("-------------")

    val responseServer: HttpResponse = client.get("http://127.0.0.1:8080/customer")
    println(responseServer)
    println(responseServer.status)
    println(responseServer.responseTime)
    println(responseServer.version)
    println(responseServer.call)
    println(responseServer.readText())

    client.close()
}
