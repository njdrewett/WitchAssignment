package com.drewett.tracker.controller

import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@SpringBootTest
class TrackerControllerIT(@Autowired val trackerController: TrackerController) {

    val log : Logger = LoggerFactory.getLogger(javaClass)

    @Test
    fun testDirectionsExisting() {

        val expectedResult = "{\"directions\":[\"forward\",\"right\",\"forward\"]}"
        val result = trackerController.directions("email1@test.com")
        assertNotNull(result)
        log.info("Returned Result: $result")

        assertNotNull(result.body);
        assertEquals( expectedResult, result.body)
    }

    @Test
    fun testDirectionsNotExisting() {

        val expectedResult = "DirectionsNotFound"
        val result = trackerController.directions("neverexisting@test.com")

        log.info("Returned Result: $result")

        assertNotNull(result)
        assertNotNull(result.body)
        assertEquals( expectedResult, result.body)
    }

    @Test
    fun testLocationExisting() {

        val expectedResult = "correct"
        val result = trackerController.location("email1@test.com",1,1)
        log.info("Returned Result: $result")

        assertNotNull(result)
        assertNotNull(result.body);
        assertEquals( expectedResult,result.body,)
    }

    @Test
    fun testLocationNotExisting() {

        val expectedResult = "ScenarioNotFound"
        val result = trackerController.location("neverexisting@test.com",1,1)

        log.info("Returned Result: $result")
        assertNotNull(result)
        assertNotNull(result.body)
        assertEquals( expectedResult, result.body)
    }
}