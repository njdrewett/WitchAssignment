package com.whichassignment.locator.repository

class DirectionsResponse(
    val directions: List<String>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DirectionsResponse

        if (directions != other.directions) return false

        return true
    }

    override fun hashCode(): Int {
        return directions.hashCode()
    }
}