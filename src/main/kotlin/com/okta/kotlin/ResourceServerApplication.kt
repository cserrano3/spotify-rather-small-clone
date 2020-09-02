package com.okta.kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ResourceServerApplication

fun main(args: Array<String>) {
	runApplication<ResourceServerApplication>(*args)
}
