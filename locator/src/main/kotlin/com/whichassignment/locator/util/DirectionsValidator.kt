package com.whichassignment.locator.util

import com.whichassignment.locator.repository.DirectionsResponse

/**
 * Validate the directions string
 */
class DirectionsValidator {

    val VALID_DIRECTIONS = listOf("forward", "left", "right")

    fun directionsAreValid(directions: List<String>): Boolean {

        var allValid = true
        for (direction in directions) {
            if (!VALID_DIRECTIONS.contains(direction)) {
                allValid = false
                break
            }
        }

        return allValid
    }
}