package com.drewett.tracker.repository

interface ScenarioRepository {

    fun retrieveScenarioById(scenarioId : String) :String
}