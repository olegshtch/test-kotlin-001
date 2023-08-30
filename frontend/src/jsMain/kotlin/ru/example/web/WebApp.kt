package ru.example.web

import dev.fritz2.core.*
import kotlinx.coroutines.flow.map

fun main() {
    val store: Store<String> = storeOf("Hello")

    render() {
        h1 { +"Test" }
        p {
            store.data.render { value -> +value }
        }
        Window.loads.map { _ -> "Hello2" } handledBy store.update
    }
}
