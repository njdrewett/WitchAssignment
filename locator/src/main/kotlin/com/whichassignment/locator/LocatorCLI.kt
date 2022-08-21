package com.whichassignment.locator

import com.whichassignment.locator.util.Orientation
import com.whichassignment.locator.util.Position

/**
 * Main class for running via a Command line
 */
class LocatorCLI
    fun main(args: Array<String>) {
        println("Locator Command Line Interface")

        if(args.size < 3) {
            println("Locator CLI needs 3 arguments in the form of ")
            println("Initial Position: 0,0 ")
            println("Initial Orientation: NORTH ")
            println("Comma separated directions")
            println("e.g 0,0 NORTH forward,forward,left,forward")
        }

        val initialPosition = retrieveInitialPosition(args)
        val initialOrientation = retrieveInitialOrientation(args)
        val directions = retrieveDirections(args)

        val locator  = Locator()

        val result = locator.locateTrackedEntity(initialPosition, initialOrientation, directions)

        println("result $result")

    }

    private fun retrieveDirections(args: Array<String>): List<String> {
        val csvDirections = args[2]
        return csvDirections.split(",")
    }

    private fun retrieveInitialOrientation(args: Array<String>): Orientation {
        val orientationString = args[1]
        return Orientation.valueOf(orientationString)
    }

    private fun retrieveInitialPosition(args: Array<String>): Position {
        val positionArg = args[0].split(",")

        val xPosition = Integer.parseInt(positionArg[0])
        val yPosition = Integer.parseInt(positionArg[0])
        return Position(xPosition,yPosition)
    }


