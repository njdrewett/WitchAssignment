package com.whichassignment.locator.controller

import com.whichassignment.locator.service.LocatorService
import com.whichassignment.locator.util.Orientation
import com.whichassignment.locator.util.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@ExtendWith(MockitoExtension::class)
class LocatorControllerTest {

    val log: Logger = LoggerFactory.getLogger(javaClass)

    var mockLocatorService: LocatorService = Mockito.mock(LocatorService::class.java)
    var locatorController = LocatorControllerImpl(mockLocatorService)

    @BeforeEach
    fun beforeEachTest() {
        mockLocatorService = Mockito.mock(LocatorService::class.java)
        locatorController = LocatorControllerImpl(mockLocatorService)
    }

    @Test
    fun testLocateExisting() {

        val expectedResult = "1,1"

        val initialPosition = Position(0, 0)
        val initialOrientation = Orientation.NORTH

        Mockito.`when`(mockLocatorService.locateFinalDestination(initialPosition, initialOrientation,"email1@test.com")).thenReturn("1,1")

        val result = locatorController.locateFinalDestination("email1@test.com", 0, 0, "NORTH")

        log.info("Returned Result: $result")

        assertNotNull(result)
        assertNotNull(result.body)
        assertEquals(expectedResult, result.body)
    }

    @Test
    fun testLocateInvalidDirections() {

        val expectedResult = "DirectionsInvalid"

        val initialPosition = Position(0, 0)
        val initialOrientation = Orientation.NORTH

        Mockito.`when`(mockLocatorService.locateFinalDestination(initialPosition, initialOrientation,"email1@test.com")).thenReturn("DirectionsInvalid")

        val result = locatorController.locateFinalDestination("email1@test.com", 0, 0, "NORTH")

        log.info("Returned Result: $result")
        assertNotNull(result)
        assertNotNull(result.body)
        assertEquals(expectedResult, result.body)
    }
}