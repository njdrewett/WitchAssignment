package com.whichassignment.locator.util

enum class Orientation {
    NORTH {
        override fun moveForward(position: Position): Position {
            // if facing north increment the y position
            return Position(position.xPosition, position.yPosition + 1)
        }

        override fun turnLeft(orientation: Orientation): Orientation {
            return WEST
        }

        override fun turnRight(orientation: Orientation): Orientation {
            return EAST
        }

    },
    SOUTH {
        override fun moveForward(position: Position): Position {
            // if facing south decrement the y position
            return Position(position.xPosition, position.yPosition - 1)
        }

        override fun turnLeft(orientation: Orientation): Orientation {
            return EAST
        }

        override fun turnRight(orientation: Orientation): Orientation {
            return WEST
        }
    },
    EAST {
        override fun moveForward(position: Position): Position {
            // if facing east increment the x position
            return Position(position.xPosition+1, position.yPosition)
        }

        override fun turnLeft(orientation: Orientation): Orientation {
            return NORTH
        }

        override fun turnRight(orientation: Orientation): Orientation {
            return SOUTH
        }
    },
    WEST {
        override fun moveForward(position: Position): Position {
            // if facing west decrement the x position
            return Position(position.xPosition -1, position.yPosition)
        }

        override fun turnLeft(orientation: Orientation): Orientation {
            return SOUTH
        }

        override fun turnRight(orientation: Orientation): Orientation {
            return NORTH
        }
    };

    abstract fun moveForward(position: Position): Position

    abstract fun turnLeft(orientation:Orientation): Orientation

    abstract fun turnRight(orientation:Orientation): Orientation

}