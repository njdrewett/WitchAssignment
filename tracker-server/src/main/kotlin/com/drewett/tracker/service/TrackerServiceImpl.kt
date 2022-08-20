package com.drewett.tracker.service

import com.drewett.tracker.repository.ScenarioRepositoryFactory
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.FileNotFoundException

@Service
class TrackerServiceImpl(@Autowired private val scenarioRepositoryFactory: ScenarioRepositoryFactory) : TrackerService {

    val log: Logger = LoggerFactory.getLogger(javaClass)

    override fun retrieveDirections(scenarioId: String): String {
        log.info("Directions $scenarioId")

        var response = "DirectionsNotFound"
            val scenarioSplit = retrieveScenario(scenarioId)
            if (scenarioSplit.size == 1) {
                log.error("Scenario not Found: $scenarioId")
            } else {
                response = scenarioSplit[1];
            }

        log.info("Directions Response for $scenarioId : $response")
        return response
    }

    override fun locationValidation(scenarioId: String, xPosition: Int, yPosition: Int): String {
        log.info("locationValidation $scenarioId")

        val scenarioSplit = retrieveScenario(scenarioId)

        var response = "ScenarioNotFound"
        if (scenarioSplit.size == 1) {
            log.error("Scenario not Found: $scenarioId")
        } else {
            val position = scenarioSplit[0].split(",");

            val x = position[0]
            val y = position[1]

            response = "wrong"
            if (x.toInt() == xPosition && y.toInt() == yPosition) {
                response = "correct"
            }
        }
        log.info("LocationValidation $response")

        return response
    }

    private fun retrieveScenario(scenarioId: String): List<String> {
        val repository = scenarioRepositoryFactory.getScenarioRepository()
        val scenario = repository.retrieveScenarioById(scenarioId)

        return scenario.split("#")
    }
}