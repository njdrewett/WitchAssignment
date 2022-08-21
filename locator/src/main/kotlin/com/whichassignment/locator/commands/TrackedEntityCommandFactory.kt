package com.whichassignment.locator.commands

/**
 * TrackedEntityCommandFactory
 * Return a command based on the given direction command
 */
class TrackedEntityCommandFactory {

    fun buildCommand(direction: String):TrackedEntityCommand {
        if("forward".equals(direction)) {

            return ForwardCommand()
        }

        if("left".equals(direction)) {
            return LeftCommand()
        }

        return RightCommand()
    }
}