package com.whichassignment.locator.service

import com.whichassignment.locator.Locator
import com.whichassignment.locator.repository.DirectionsRepositoryFactory
import com.whichassignment.locator.util.Orientation
import com.whichassignment.locator.util.Position
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Locator Service
 *
 * Given an Initial Position, orientation (and options directions identifier)
 * return the final location of a Tracked Object
 */
@Service
class LocatorServiceImpl(@Autowired val directionsRepositoryFactory: DirectionsRepositoryFactory) : LocatorService {

    val log: Logger = LoggerFactory.getLogger(javaClass)

    override fun locateFinalDestination(initialPosition:Position, initialOrientation:Orientation, identifier:String?) : String {
        log.info("Entering: locateFinalDestination: $initialPosition $initialOrientation")

        // Get Directions repository
        val directionsRepository = directionsRepositoryFactory.retrieveRepository()

        val directions = directionsRepository.retrieveDirections(identifier)

        val finalLocation = locateFinalDestination(initialPosition, initialOrientation, directions)

        log.info("Exiting: locateFinalDestination: $finalLocation")

        return finalLocation
    }

    override fun locateFinalDestination(
        initialPosition: Position,
        initialOrientation: Orientation,
        directions: List<String> ): String {
        log.info("Entering: locateFinalDestination: $initialPosition $initialOrientation $directions")

        val locator = Locator()

        val finalLocation = locator.locateTrackedEntity(initialPosition, initialOrientation, directions)

        log.info("Exiting: locateFinalDestination: $finalLocation")

        return finalLocation
    }

    override fun locateFinalDestination(initialPosition: Position, initialOrientation: Orientation): String {
        return locateFinalDestination(initialPosition, initialOrientation, null)
    }

}