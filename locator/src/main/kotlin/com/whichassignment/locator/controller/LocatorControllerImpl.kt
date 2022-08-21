package com.whichassignment.locator.controller

import com.whichassignment.locator.service.LocatorService
import com.whichassignment.locator.util.Orientation
import com.whichassignment.locator.util.Position
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * URL Controller Implmentation
 */
@RestController
@RequestMapping(path = ["api"])
class LocatorControllerImpl(@Autowired val locatorService: LocatorService) : LocatorController {

    val log: Logger = LoggerFactory.getLogger(javaClass)

    @GetMapping(path = ["/{identifier}/locate/{xPosition}/{yPosition}/{orientation}"])
    override fun locateFinalDestination(
        @PathVariable("identifier") identifier: String,
        @PathVariable("xPosition") xPosition: Int,
        @PathVariable("yPosition") yPosition: Int,
        @PathVariable("orientation") orientation: String) : ResponseEntity<String>{

        log.info("Entering locateFinalDestination: $identifier $xPosition $yPosition $orientation")

        val initialPosition = Position(xPosition,yPosition)
        val orientationObject = Orientation.valueOf(orientation)
        val response = locatorService.locateFinalDestination(initialPosition, orientationObject, identifier)

        log.info("Exiting locateFinalDestination: $response")

        return ResponseEntity(response, HttpStatus.OK)
    }

}