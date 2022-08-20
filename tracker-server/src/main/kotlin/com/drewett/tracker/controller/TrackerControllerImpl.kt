package com.drewett.tracker.controller

import com.drewett.tracker.service.TrackerService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path=["api"])
class TrackerControllerImpl(@Autowired val trackerService : TrackerService) : TrackerController {

    val log : Logger = LoggerFactory.getLogger(javaClass)

    @GetMapping(path=["/{emailAddress}/directions"])
    override fun directions(@PathVariable("emailAddress") emailAddress:String): ResponseEntity<String> {
        log.info("Entering Directions: $emailAddress")

        val response = trackerService.retrieveDirections(emailAddress)

        log.info("Exiting Directions: $emailAddress")

        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping(path=["/{emailAddress}/location/{x}/{y}"])
    override fun location(@PathVariable("emailAddress") emailAddress:String,
                          @PathVariable("x") xPosition:Int,
                          @PathVariable("y") yPosition:Int): ResponseEntity<String> {
        log.info("Entering Location: $emailAddress x= $xPosition y=$yPosition")

        val response = trackerService.locationValidation(emailAddress,xPosition,yPosition)

        log.info("Exiting Location: $response")

        return ResponseEntity(response, HttpStatus.OK)
    }
}