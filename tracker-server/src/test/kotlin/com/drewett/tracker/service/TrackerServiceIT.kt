package com.drewett.tracker.service

import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@SpringBootTest
class TrackerServiceIT(@Autowired val trackerService: TrackerService) {

    val log : Logger = LoggerFactory.getLogger(javaClass)

    @Test
    fun testDirectionsExisting() {

        val expectedResult = "{\"directions\":[\"forward\",\"right\",\"forward\"]}"
        val result = trackerService.retrieveDirections("email1@test.com")

        log.info("Returned Result: $result")

        assertNotNull(result)
        assertEquals(expectedResult,result)
    }

    @Test
    fun testDirectionsNotExisting() {

        val expectedResult = "DirectionsNotFound"
        val result = trackerService.retrieveDirections("neverexisting@test.com")
        log.info("Returned Result: $result")
        assertNotNull(result)
        assertEquals(expectedResult,result)
    }

    @Test
    fun testLocationExisting() {

        val expectedResult = "correct"
        val result = trackerService.locationValidation("email1@test.com",1,1)

        log.info("Returned Result: $result")
        assertNotNull(result)
        assertEquals(expectedResult,result)
    }

    @Test
    fun testLocationNotExisting() {

        val expectedResult = "ScenarioNotFound"
        val result = trackerService.locationValidation("neverexisting@test.com",1,1)

        log.info("Returned Result: $result")
        assertNotNull(result)
        assertEquals(expectedResult,result)
    }
}