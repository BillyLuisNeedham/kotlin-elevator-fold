import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ElevatorTest {

    @Test
    fun `elevator works as expected`() {
        val values = listOf(Up, Up, Down, Up, Down, Down, Up, Up, Up, Down)

        val tot =
            values.fold(Elevator(0)) { total, item ->
                Elevator(
                    when (item) {
                        Direction.Down -> total.floor - 1
                        Direction.Up -> total.floor + 1
                    }
                )
            }

        assertEquals(tot, Elevator(2))
    }

}