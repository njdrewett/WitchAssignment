package com.whichassignment.locator.controller

import org.springframework.http.ResponseEntity

/**
 * Interface for LocatorController
 */
interface LocatorController {

    /**
     * Locate the final Destination of the tracked object with given Identifier (email) , x , y and orientation
     */
    fun locateFinalDestination(identifier:String, xPosition:Int, yPosition:Int, orientation:String): ResponseEntity<String>

    /**
     * Locate the final Destination of the tracked object with given  x , y,  orientation and comma separated directions
     */
    fun locateFinalDestination(xPosition:Int, yPosition:Int,orientation:String, directions:String): ResponseEntity<String>

}