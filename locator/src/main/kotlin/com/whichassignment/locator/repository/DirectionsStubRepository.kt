package com.whichassignment.locator.repository

/**
 * Stub class with fixed data
 */
class DirectionsStubRepository : DirectionsRepository {

    override fun retrieveDirections(identifier: String?): List<String> {
        return listOf("forward", "right", "forward")
    }

    override fun toString(): String {
        return "DirectionsStubRepository()"
    }

}