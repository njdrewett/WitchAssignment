package com.whichassignment.locator.repository

/**
 * Interface for the DirectionsRepository Factory
 */
interface DirectionsRepositoryFactory {

    fun retrieveRepository():DirectionsRepository
}