package com.whichassignment.locator.repository

/**
 * Interface for Retrieving Direction details
 */
interface DirectionsRepository {
    fun retrieveDirections(identifier:String?):List<String>

    override fun toString():String
}