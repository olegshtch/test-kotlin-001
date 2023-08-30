package ru.example.web

import dev.fritz2.core.*
import dev.fritz2.remote.http
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.*
import ru.example.proto.Hello

fun main() {
    val store: Store<String> = storeOf("Hello")

    val httpApi = http().acceptJson().contentType("application/json")

    render() {
        h1 { +"Test" }
        p {
            store.data.render { value -> +value }
        }
        Window.loads.map { _ ->
            val resp = httpApi.get("/hello")
            if (resp.ok) {
                val hello = Json.decodeFromString(Hello.serializer(), resp.body())
                "Hello, ${hello.name}"
            } else {
                throw IllegalArgumentException()
            }
        } handledBy store.update
    }
}
