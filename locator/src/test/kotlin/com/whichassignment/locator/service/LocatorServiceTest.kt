package com.whichassignment.locator.service

import com.whichassignment.locator.repository.DirectionsRepository
import com.whichassignment.locator.repository.DirectionsRepositoryFactory
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
class LocatorServiceTest {

    var mockDirectionsRepository = Mockito.mock<DirectionsRepository>(DirectionsRepository::class.java)
    var mockDirectionsRepositoryFactory =
        Mockito.mock<DirectionsRepositoryFactory>(DirectionsRepositoryFactory::class.java)

    @BeforeEach
    fun beforeEachTest() {
        mockDirectionsRepository = Mockito.mock<DirectionsRepository>(DirectionsRepository::class.java)
        mockDirectionsRepositoryFactory =
            Mockito.mock<DirectionsRepositoryFactory>(DirectionsRepositoryFactory::class.java)
    }

    @Test
    fun testFinalLocation1DiagnalSquareRight() {
        val directions = listOf("forward", "right", "forward")

        Mockito.`when`(mockDirectionsRepository.retrieveDirections(null)).thenReturn(directions)

        Mockito.`when`(mockDirectionsRepositoryFactory.retrieveRepository()).thenReturn(mockDirectionsRepository)

        val locatorService = LocatorServiceImpl(mockDirectionsRepositoryFactory)

        val initialOrientation = Orientation.NORTH
        val initialPosition = Position(0, 0)

        val result = locatorService.locateFinalDestination(initialPosition, initialOrientation)

        assertNotNull(result)
        assertEquals(3, result.length)

        val positions = result.split(",")

        assertEquals("1", positions[0])
        assertEquals("1", positions[1])
    }

    @Test
    fun testFinalLocation1DiagonalSquare() {

        val directions = listOf("forward", "left", "forward")

        Mockito.`when`(mockDirectionsRepository.retrieveDirections(null)).thenReturn(directions)

        Mockito.`when`(mockDirectionsRepositoryFactory.retrieveRepository()).thenReturn(mockDirectionsRepository)
        val locatorService = LocatorServiceImpl(mockDirectionsRepositoryFactory)

        val initialOrientation = Orientation.NORTH
        val initialPosition = Position(0, 0)

        val result = locatorService.locateFinalDestination(initialPosition, initialOrientation)

        assertEquals(4, result.length)

        val positions = result.split(",")
        assertEquals("-1", positions[0])
        assertEquals("1", positions[1])
    }

    @Test
    fun testFinalLocationForwardSquares() {

        val directions = listOf("forward", "forward")

        Mockito.`when`(mockDirectionsRepository.retrieveDirections(null)).thenReturn(directions)

        Mockito.`when`(mockDirectionsRepositoryFactory.retrieveRepository()).thenReturn(mockDirectionsRepository)
        val locatorService = LocatorServiceImpl(mockDirectionsRepositoryFactory)

        val initialOrientation = Orientation.NORTH
        val initialPosition = Position(0, 0)

        val result = locatorService.locateFinalDestination(initialPosition, initialOrientation)

        assertEquals(3, result.length)

        val positions = result.split(",")

        assertNotNull(result)
        assertEquals("0", positions[0])
        assertEquals("2", positions[1])
    }

    @Test
    fun testFinalLocationInvalidDirections() {

        val directions = listOf("abc", "let", "fourward")

        Mockito.`when`(mockDirectionsRepository.retrieveDirections(null)).thenReturn(directions)

        Mockito.`when`(mockDirectionsRepositoryFactory.retrieveRepository()).thenReturn(mockDirectionsRepository)
        val locatorService = LocatorServiceImpl(mockDirectionsRepositoryFactory)

        val initialOrientation = Orientation.NORTH
        val initialPosition = Position(0, 0)

        val result = locatorService.locateFinalDestination(initialPosition, initialOrientation)

        assertEquals("DirectionsInvalid", result)
    }

}