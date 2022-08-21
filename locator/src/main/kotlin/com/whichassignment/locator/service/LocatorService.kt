package com.whichassignment.locator.service

import com.whichassignment.locator.util.Orientation
import com.whichassignment.locator.util.Position

interface LocatorService {
    fun locateFinalDestination(initialPosition: Position, initialOrientation: Orientation,identifier:String?):String

    fun locateFinalDestination(initialPosition: Position, initialOrientation: Orientation):String

}