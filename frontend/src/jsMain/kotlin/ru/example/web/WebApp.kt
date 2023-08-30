package ru.example.web

import dev.fritz2.core.*
import dev.fritz2.remote.http
import kotlinx.coroutines.flow.map

fun main() {
    val store: Store<String> = storeOf("Hello")

    val httpApi = http().acceptJson().contentType("application/json")

    render() {
        h1 { +"Test" }
        p {
            store.data.render { value -> +value }
        }
        Window.loads.map { _ -> httpApi.get("/hello").body()} handledBy store.update
    }
}
