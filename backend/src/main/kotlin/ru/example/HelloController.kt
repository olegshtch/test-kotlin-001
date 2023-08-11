package ru.example

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import reactor.core.publisher.Mono
import ru.example.proto.Hello

@Controller
class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    fun hello(): Mono<Hello> {
        return Mono.just(Hello("Test"))
    }
}
