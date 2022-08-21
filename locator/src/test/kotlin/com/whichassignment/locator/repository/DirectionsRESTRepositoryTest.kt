package com.whichassignment.locator.repository

import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

class DirectionsRESTRepositoryTest {

    @Test
    fun testRestRepositoryCall() {
        val repository = DirectionsRESTRepository("http://localhost:8090/api/email1@test.com/directions")

        val directions = repository.retrieveDirections(null)

        assertNotNull(directions)
    }
}