package com.drewett.tracker.repository

import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.io.FileNotFoundException
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.fail

@SpringBootTest
class FileScenarioRepositoryIT() {

    val log : Logger = LoggerFactory.getLogger(javaClass)

    @Test
    fun testRetrieveScenarioExisting() {

        val expectedResult = "1,1#{\"directions\":[\"forward\",\"right\",\"forward\"]}"

        val fileScenarioRepository = FileScenarioRepository("scenarios")

        val result = fileScenarioRepository.retrieveScenarioById("email1@test.com")

        log.info("Returned Result: $result")

        assertNotNull(result)
        assertEquals( expectedResult, result)
    }

    @Test
    fun testRetrieveScenarioNotExisting() {

        val expectedResult = "ScenarioNotFound"

        val fileScenarioRepository = FileScenarioRepository("scenarios")

        val result = fileScenarioRepository.retrieveScenarioById("neverexisting@test.com")

        assertNotNull(result)
        assertEquals( expectedResult, result)

    }
}