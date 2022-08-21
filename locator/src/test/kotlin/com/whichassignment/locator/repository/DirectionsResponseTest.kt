package com.whichassignment.locator.repository

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DirectionsResponseTest {

    @Test
    fun testCreateDirectionsConstructor() {
        val directions = DirectionsResponse(listOf("forward","left"))
        assertTrue(directions.directions.isNotEmpty())
    }
}