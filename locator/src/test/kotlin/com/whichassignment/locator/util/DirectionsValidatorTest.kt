package com.whichassignment.locator.util

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Test for the Directions String Validator
 */
class DirectionsValidatorTest {

    @Test
    fun testValidDirectionLeft() {
        val directions = listOf("left")

        val directionsValidator = DirectionsValidator()

        val valid = directionsValidator.directionsAreValid(directions)
        assertTrue { valid }
    }

    @Test
    fun testInvalidDirectionLeft() {

        val directions = listOf("lift")

        val directionsValidator = DirectionsValidator()

        val valid = directionsValidator.directionsAreValid(directions)
        assertFalse { valid }
    }

    @Test
    fun testValidDirectionLeftForwardForward() {
        val directions = listOf("left", "forward", "forward")

        val directionsValidator = DirectionsValidator()

        val valid = directionsValidator.directionsAreValid(directions)
        assertTrue { valid }
    }

    @Test
    fun testValidEmptyLength() {
        val directions = listOf<String>()

        val directionsValidator = DirectionsValidator()

        val valid = directionsValidator.directionsAreValid(directions)
        assertTrue { valid }
    }

}