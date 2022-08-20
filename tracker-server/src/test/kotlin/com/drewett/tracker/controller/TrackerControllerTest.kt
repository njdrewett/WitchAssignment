package com.drewett.tracker.controller

import com.drewett.tracker.service.TrackerService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@ExtendWith(MockitoExtension::class)
class TrackerControllerTest {

    val log : Logger = LoggerFactory.getLogger(javaClass)

    var mockTrackerService = Mockito.mock(TrackerService::class.java)
    var trackerController = TrackerControllerImpl(mockTrackerService)

    @BeforeEach
    fun beforeEachTest() {
        mockTrackerService = Mockito.mock(TrackerService::class.java)
        trackerController = TrackerControllerImpl(mockTrackerService)
    }

    @Test
    fun testDirectionsExisting() {

        val expectedResult = "{\"directions\":[\"forward\",\"right\",\"forward\"]}"

        Mockito.`when`(mockTrackerService.retrieveDirections("email1@test.com")).thenReturn(expectedResult)

        val result = trackerController.directions("email1@test.com")

        log.info("Returned Result: $result")

        assertNotNull(result)
        assertNotNull(result.body);
        assertEquals( expectedResult, result.body)
    }

    @Test
    fun testDirectionsNotExisting() {

        val expectedResult = "directionsNotFound"

        Mockito.`when`(mockTrackerService.retrieveDirections("neverexisting@test.com")).thenReturn(expectedResult)

        val result = trackerController.directions("neverexisting@test.com")
        log.info("Returned Result: $result")
        assertNotNull(result)
        assertNotNull(result.body)
        assertEquals( expectedResult, result.body)
    }

    @Test
    fun testLocationExisting() {

        val expectedResult = "correct"

        Mockito.`when`(mockTrackerService.locationValidation("email1@test.com",1,1)).thenReturn(expectedResult)

        val result = trackerController.location("email1@test.com",1,1)

        log.info("Returned Result: $result")
        assertNotNull(result)
        assertNotNull(result.body);
        assertEquals( expectedResult, result.body)
    }

    @Test
    fun testLocationNotExisting() {

        val expectedResult = "scenarioNotFound"
        Mockito.`when`(mockTrackerService.locationValidation("neverexisting@test.com",1,1)).thenReturn(expectedResult)

        val result = trackerController.location("neverexisting@test.com",1,1)
        log.info("Returned Result: $result")
        assertNotNull(result)
        assertNotNull(result.body)
        assertEquals( expectedResult, result.body)
    }
}