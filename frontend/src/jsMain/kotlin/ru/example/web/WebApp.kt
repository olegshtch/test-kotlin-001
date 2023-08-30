package ru.example.web

import dev.fritz2.core.Store
import dev.fritz2.core.render
import dev.fritz2.core.storeOf

fun main() {
    val store: Store<String> = storeOf("Hello")

    render() {
        h1 { +"Test" }
        p {
            store.data.render { value -> +value }
        }
    }
}
