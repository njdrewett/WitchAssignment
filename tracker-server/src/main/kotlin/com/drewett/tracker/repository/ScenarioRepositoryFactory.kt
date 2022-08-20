package com.drewett.tracker.repository

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class ScenarioRepositoryFactory( @Value("\${wordFileRepository.rootFolder:scenarios}")
                                 private val scenarioFolder: String) {

   fun getScenarioRepository(): ScenarioRepository {
        return FileScenarioRepository( scenarioFolder)
   }

}