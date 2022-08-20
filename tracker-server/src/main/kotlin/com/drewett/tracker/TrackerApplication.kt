package com.drewett.tracker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Main Spring Boot Tracker Application Entry Point
 */
@SpringBootApplication
class TrackerApplication
fun main(args: Array<String>) {
        runApplication<TrackerApplication>(*args)
    }
