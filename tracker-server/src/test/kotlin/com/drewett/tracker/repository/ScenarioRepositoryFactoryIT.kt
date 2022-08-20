package com.drewett.tracker.repository

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@SpringBootTest
class ScenarioRepositoryFactoryIT(@Autowired val scenarioRepositoryFactory: ScenarioRepositoryFactory) {

    val log : Logger = LoggerFactory.getLogger(javaClass)

    @Test
    fun testGetScenarioRepository() {

        val result = scenarioRepositoryFactory.getScenarioRepository()
        log.info("Returned Result: $result")

        assertNotNull(result)
        MatcherAssert.assertThat(result, CoreMatchers.instanceOf(FileScenarioRepository::class.java))
    }

 }