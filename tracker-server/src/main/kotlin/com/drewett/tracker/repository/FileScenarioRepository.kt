package com.drewett.tracker.repository

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.core.io.ClassPathResource
import java.io.*
import java.nio.charset.StandardCharsets
import java.util.stream.Collectors

class FileScenarioRepository(private val scenarioFolder: String) : ScenarioRepository {

    private val log: Logger = LoggerFactory.getLogger(javaClass)

    override fun retrieveScenarioById(scenarioId: String): String {
        log.info("retrieveScenarioById $scenarioId")

        val fileName = concatFilePathAndName(scenarioId)

        val scenario = readScenario(fileName)

        log.info("Found scenario: $scenario")

        return scenario
    }

    private fun readScenario(fileName: String):String {
        val resource = ClassPathResource(fileName)

        try {
            resource.inputStream.use { inputStream ->
                val reader: Reader = InputStreamReader(inputStream, StandardCharsets.UTF_8)
                val br = BufferedReader(reader)
                return br.lines()
                    .collect(Collectors.toList()).first()
            }
        } catch (exception: IOException) {
            log.error("Exception reading $fileName", exception)
        }
        return "ScenarioNotFound"
    }

    private fun concatFilePathAndName(scenarioId:String): String {
        val stringBuilder = StringBuilder()

        if (scenarioFolder.trim().isNotBlank()) {
            stringBuilder.append(scenarioFolder)
            stringBuilder.append(File.separator)
        }
        stringBuilder.append(scenarioId)
        return stringBuilder.toString()
    }
}