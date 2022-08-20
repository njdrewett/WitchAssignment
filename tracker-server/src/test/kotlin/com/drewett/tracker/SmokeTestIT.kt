package com.drewett.tracker

import com.drewett.tracker.controller.TrackerController
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SmokeTestIT(@Autowired val trackerController:TrackerController) {

    @Test
    fun contextLoads() {
        Assertions.assertNotNull(trackerController)
    }
}