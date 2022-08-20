package com.drewett.tracker.controller

import org.springframework.http.ResponseEntity


interface TrackerController {

    fun directions(emailAddress:String) : ResponseEntity<String>

    fun location(emailAddress:String, xPosition: Int, yPosition: Int) : ResponseEntity<String>

}