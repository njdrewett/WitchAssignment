package com.whichassignment.locator.commands

import com.whichassignment.locator.util.TrackedEntity

/**
 * Perform a Right command (Turn tracked entity to new orientation right)
 */
class RightCommand : TrackedEntityCommand {
    override fun execute(trackedEntity: TrackedEntity) {

        // Get orientation
        val orientation = trackedEntity.orientation

        // get new orientation
        val newOrientation = orientation.turnRight(orientation)

        trackedEntity.orientation = newOrientation
    }

    override fun toString(): String {
        return "RightCommand()"
    }
}