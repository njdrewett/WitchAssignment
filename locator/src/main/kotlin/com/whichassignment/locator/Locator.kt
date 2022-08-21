package com.whichassignment.locator

import com.whichassignment.locator.commands.TrackedEntityCommandFactory
import com.whichassignment.locator.util.DirectionsValidator
import com.whichassignment.locator.util.Orientation
import com.whichassignment.locator.util.Position
import com.whichassignment.locator.util.TrackedEntity
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Locator class. Given a starting position and set of directions,
 * return the target location x and y position
 */
class Locator {
    val log: Logger = LoggerFactory.getLogger(javaClass)

    fun locateTrackedEntity(
        initialPosition: Position,
        initialOrientation: Orientation,
        directions: List<String>
    ): String {

        var response = "DirectionsInvalid"

        // Validate the directions
        val validator = DirectionsValidator()
        if (!validator.directionsAreValid(directions)) {
            log.info("Directions Invalid: $directions")
        } else {

            // Create a Tracked Entity with initial position and orientation
            val trackedEntity = TrackedEntity(initialPosition, initialOrientation)

            log.info("Tracked Entity: $trackedEntity")

            // build Command Factory
            val trackedEntityCommandFactory = TrackedEntityCommandFactory()

            for (direction in directions) {
                val command = trackedEntityCommandFactory.buildCommand(direction)
                log.info("Executing $command")
                command.execute(trackedEntity)
                log.info("Tracked Entity: $trackedEntity")
            }

            // return location
            response = trackedEntity.position.toShortString()
        }

        return response
    }

}