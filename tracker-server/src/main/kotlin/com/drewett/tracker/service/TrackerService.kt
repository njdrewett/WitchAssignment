package com.drewett.tracker.service

/**
 * Tracker Service interface
 */
interface TrackerService {

        fun retrieveDirections(scenarioId: String):String
        fun locationValidation(scenarioId: String, xPosition:Int, yPosition:Int): String
}