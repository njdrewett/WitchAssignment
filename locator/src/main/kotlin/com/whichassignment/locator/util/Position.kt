package com.whichassignment.locator.util

data class Position(val xPosition:Int, val yPosition:Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Position

        if (xPosition != other.xPosition) return false
        if (yPosition != other.yPosition) return false

        return true
    }

    override fun hashCode(): Int {
        var result = xPosition
        result = 31 * result + yPosition
        return result
    }

    override fun toString(): String {
        return "Position(xPosition=$xPosition, yPosition=$yPosition)"
    }

    fun toShortString(): String {
        return "$xPosition,$yPosition"
    }

}