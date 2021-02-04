package com.odhiambopaul.mongod

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MongodApplication

fun main(args: Array<String>) {
    runApplication<MongodApplication>(*args)
}
