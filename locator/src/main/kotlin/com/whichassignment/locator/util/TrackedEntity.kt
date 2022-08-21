package com.whichassignment.locator.util

class TrackedEntity(var position: Position, var orientation: Orientation) {

    override fun toString(): String {
        return "TrackedEntity(position=$position, orientation=$orientation)"
    }
}