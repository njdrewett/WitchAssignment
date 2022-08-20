package com.drewett.tracker.service

import com.drewett.tracker.repository.ScenarioRepository
import com.drewett.tracker.repository.ScenarioRepositoryFactory
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.willAnswer
import org.mockito.Mockito
import org.mockito.invocation.InvocationOnMock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.stubbing.Answer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.FileNotFoundException
import kotlin.test.assertEquals
import kotlin.test.assertNotNull


@ExtendWith(MockitoExtension::class)
class TrackerServiceTest {

    val log : Logger = LoggerFactory.getLogger(javaClass)

    var mockScenarioRepositoryFactory = Mockito.mock(ScenarioRepositoryFactory::class.java)
    var mockScenarioRepository = Mockito.mock(ScenarioRepository::class.java)
    var trackerService = TrackerServiceImpl(mockScenarioRepositoryFactory)

    @BeforeEach
    fun beforeEachTest() {
         mockScenarioRepositoryFactory = Mockito.mock(ScenarioRepositoryFactory::class.java)
         mockScenarioRepository = Mockito.mock(ScenarioRepository::class.java)
         trackerService = TrackerServiceImpl(mockScenarioRepositoryFactory)
    }

    @Test
    fun testDirectionsExisting() {

        val expectedResult = "{\"directions\":[\"forward\",\"right\",\"forward\"]}"

        Mockito.`when`(mockScenarioRepositoryFactory.getScenarioRepository()).thenReturn(mockScenarioRepository)

        Mockito.`when`(mockScenarioRepository.retrieveScenarioById("email1@test.com")).thenReturn("1,1#{\"directions\":[\"forward\",\"right\",\"forward\"]}")

        val result = trackerService.retrieveDirections("email1@test.com")

        log.info("Returned Result: $result")

        assertNotNull(result)
        assertEquals(expectedResult,result)
    }

    @Test
    fun testDirectionsNotExisting() {

        val expectedResult = "DirectionsNotFound"

        Mockito.`when`(mockScenarioRepositoryFactory.getScenarioRepository()).thenReturn(mockScenarioRepository)

        Mockito.`when`(mockScenarioRepository.retrieveScenarioById("neverexisting@test.com")).thenReturn("ScenarioNotFound")

        val result = trackerService.retrieveDirections("neverexisting@test.com")

        log.info("Returned Result: $result")

        assertNotNull(result)
        assertEquals(expectedResult,result)
    }

    @Test
    fun testLocationExisting() {

        val expectedResult = "correct"

        Mockito.`when`(mockScenarioRepositoryFactory.getScenarioRepository()).thenReturn(mockScenarioRepository)

        Mockito.`when`(mockScenarioRepository.retrieveScenarioById("email1@test.com")).thenReturn("1,1#{\"directions\":[\"forward\",\"right\",\"forward\"]}")

        val result = trackerService.locationValidation("email1@test.com",1,1)

        log.info("Returned Result: $result")

        assertNotNull(result)
        assertEquals(expectedResult,result)
    }

    @Test
    fun testLocationNotExisting() {

        val expectedResult = "ScenarioNotFound"
        Mockito.`when`(mockScenarioRepositoryFactory.getScenarioRepository()).thenReturn(mockScenarioRepository)

        Mockito.`when`(mockScenarioRepository.retrieveScenarioById("neverexisting@test.com")).thenReturn("ScenarioNotFound")

        val result = trackerService.locationValidation("neverexisting@test.com",1,1)
        log.info("Returned Result: $result")

        assertNotNull(result)
        assertEquals(expectedResult,result)
    }
}