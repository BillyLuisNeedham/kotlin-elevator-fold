typealias Up = Direction.Up
typealias Down = Direction.Down

fun main(args: Array<String>) {
    val values = listOf(Up, Up, Down, Up, Down, Down, Up, Up, Up, Down)

    println("elevator directions: $values")

    val startPoint = Elevator(0)

    println("elevator starting at ${startPoint.floor}")

    val finalElevatorPosition =
        values.fold(startPoint) { total, item ->
            Elevator(
                when (item) {
                    Direction.Down -> total.floor - 1
                    Direction.Up -> total.floor + 1
                }
            )
        }

    println("elevator ends on $finalElevatorPosition")
}

data class Elevator(val floor: Int)

sealed interface Direction {
    object Up : Direction
    object Down : Direction
}