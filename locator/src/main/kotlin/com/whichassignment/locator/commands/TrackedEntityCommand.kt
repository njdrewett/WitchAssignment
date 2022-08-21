package com.whichassignment.locator.commands

import com.whichassignment.locator.util.TrackedEntity

/**
 * Interface for Command executed against a Tracked Entity
 */
interface TrackedEntityCommand {

    fun execute(trackedEntity: TrackedEntity)
}