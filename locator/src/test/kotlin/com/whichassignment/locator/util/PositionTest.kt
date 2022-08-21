package com.whichassignment.locator.util

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PositionTest {

    @Test
    fun testPositionConstructor() {
        var position = Position(0,0)

        assertEquals(0, position.xPosition)
        assertEquals(0, position.yPosition)
    }
}