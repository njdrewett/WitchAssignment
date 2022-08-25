package com.whichassignment.locator.util

/**
 * Validate the directions string
 */
class DirectionsValidator {

    fun directionsAreValid(directions: List<String>): Boolean {

        var allValid = true
        for (direction in directions) {
            if (!Direction.values().map{it.direction}.contains(direction)) {
                allValid = false
                break
            }
        }

        return allValid
    }
}