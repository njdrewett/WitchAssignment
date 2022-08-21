package com.whichassignment.locator.repository

import com.google.gson.Gson
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

/**
 * Call out to retreive Directions from an external Repository
 */
class DirectionsRESTRepository(val callingUrl :String) : DirectionsRepository {

    val log: Logger = LoggerFactory.getLogger(javaClass)

    override fun retrieveDirections(identifier:String?): List<String> {
        log.info("Entering retrieve Directions from URL: $callingUrl")

        var callingURLUpdated = callingUrl
        if(identifier != null) {
            callingURLUpdated = callingUrl.replace("<identifier>", identifier)
        }

        val contents = StringBuffer()
        val url = URL(callingURLUpdated)
        val connection = url.openConnection()
        BufferedReader(InputStreamReader(connection.getInputStream())).use { inp ->
            var line: String?
            while (inp.readLine().also { line = it } != null) {
                contents.append(line)
            }
        }

        val directionsString = contents.toString()
        log.info("Entering retrieve Directions from URL: $directionsString")

        val gsonParser = Gson()
        return gsonParser.fromJson<DirectionsResponse?>(directionsString, DirectionsResponse::class.java).directions
    }

    override fun toString(): String {
        return "DirectionsRESTRepository(callingUrl='$callingUrl')"
    }
}