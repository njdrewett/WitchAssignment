package com.whichassignment.locator

import com.whichassignment.locator.util.Orientation
import com.whichassignment.locator.util.Position
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class LocatorTest {

    @Test
    fun testFinalLocation1DiagonalSquareRight() {
        val directions = listOf("forward","right","forward")

        val initialOrientation = Orientation.NORTH
        val initialPosition = Position(0,0)

        val locator = Locator()

        val result = locator.locateTrackedEntity(initialPosition, initialOrientation, directions)

        assertNotNull(result)
        assertEquals(3, result.length)

        val positions = result.split(",")

        assertEquals("1", positions[0])
        assertEquals("1", positions[1])
    }

    @Test
    fun testFinalLocation1DiagonalSquare() {
        val directions = listOf("forward","left","forward")

        val initialOrientation = Orientation.NORTH
        val initialPosition = Position(0,0)
        val locator = Locator()

        val result = locator.locateTrackedEntity(initialPosition, initialOrientation, directions)

        assertEquals(4, result.length)

        val positions = result.split(",")
        assertEquals("-1", positions[0])
        assertEquals("1", positions[1])
    }

    @Test
    fun testFinalLocationForwardSquares() {
        val directions = listOf("forward","forward")

        val initialOrientation = Orientation.NORTH
        val initialPosition = Position(0,0)
        val locator = Locator()

        val result = locator.locateTrackedEntity(initialPosition, initialOrientation, directions)
        assertEquals(3, result.length)

        val positions = result.split(",")

        assertNotNull(result)
        assertEquals("0", positions[0])
        assertEquals("2", positions[1])
    }

    @Test
    fun testFinalLocationInvalidDirections() {
        val directions = listOf("abc","let","fourward")

        val initialOrientation = Orientation.NORTH
        val initialPosition = Position(0,0)

        val locator = Locator()

        val result = locator.locateTrackedEntity(initialPosition, initialOrientation, directions)

        assertEquals("DirectionsInvalid", result)
    }

    @Test
    fun testFinalLocationGivenExample() {
        val directions = listOf("forward","right","forward","forward","forward","left","forward","forward","left","right","forward","right","forward","forward","right","forward","forward","left")

        val initialOrientation = Orientation.NORTH
        val initialPosition = Position(0,0)

        val locator = Locator()

        val result = locator.locateTrackedEntity(initialPosition, initialOrientation, directions)

        assertNotNull(result)
        assertEquals(3, result.length)

        val positions = result.split(",")

        assertEquals("5", positions[0])
        assertEquals("2", positions[1])
    }

}