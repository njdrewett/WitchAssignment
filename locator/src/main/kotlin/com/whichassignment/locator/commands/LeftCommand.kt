package com.whichassignment.locator.commands

import com.whichassignment.locator.util.TrackedEntity

/**
 * Perform a left command (Turn tracked entity in the orientation left)
 */
class LeftCommand : TrackedEntityCommand {
    override fun execute(trackedEntity: TrackedEntity) {

        // Get orientation
        val orientation = trackedEntity.orientation

        // gTurn Left and Return new orientation
        val newOrientation = orientation.turnLeft(orientation)

        trackedEntity.orientation = newOrientation
    }

    override fun toString(): String {
        return "LeftCommand()"
    }

}