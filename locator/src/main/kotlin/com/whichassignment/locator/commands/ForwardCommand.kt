package com.whichassignment.locator.commands

import com.whichassignment.locator.util.TrackedEntity

/**
 * Perform a forward command (Move tracked entity forward in the direction it is facing
 */
class ForwardCommand : TrackedEntityCommand {
    override fun execute(trackedEntity: TrackedEntity) {

        // Get orientation
        val orientation = trackedEntity.orientation

        // move Forward and get new position
        val newPosition = orientation.moveForward(trackedEntity.position)

        trackedEntity.position = newPosition
    }

    override fun toString(): String {
        return "ForwardCommand()"
    }

}