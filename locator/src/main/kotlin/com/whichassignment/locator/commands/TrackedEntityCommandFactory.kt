package com.whichassignment.locator.commands

import com.whichassignment.locator.util.Direction

/**
 * TrackedEntityCommandFactory
 * Return a command based on the given direction command
 */
class TrackedEntityCommandFactory {

    fun buildCommand(direction: String):TrackedEntityCommand {

        if(Direction.FORWARD.direction.equals(direction)) {
            return ForwardCommand()
        }

        if(Direction.LEFT.direction.equals(direction)) {
            return LeftCommand()
        }

        return RightCommand()
    }
}