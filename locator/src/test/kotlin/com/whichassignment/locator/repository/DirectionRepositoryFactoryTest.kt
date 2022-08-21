package com.whichassignment.locator.repository

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory


class DirectionRepositoryFactoryTest {

    @Test
    fun getRepositoryTest() {

        val factory = DirectionsRepositoryFactoryImpl("",true)

        val repository = factory.retrieveRepository()

        // Should be stub for now
        MatcherAssert.assertThat(repository, CoreMatchers.instanceOf(DirectionsStubRepository::class.java))
    }

}