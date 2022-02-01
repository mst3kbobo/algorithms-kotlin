import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

internal class BubbleSortKtTest {

    @Test
    fun bubbleSort() {

        val unsortedListA = mutableListOf(8, 5, 2, 9, 5, 6, 3)
        val sortedListA = listOf(2, 3, 5, 5, 6, 8, 9)

        assertEquals(sortedListA, bubbleSort(unsortedListA))

        val unsortedListB = mutableListOf(16, 0, -1, 8, 22, 5, 10, 66, 3, 9)
        val sortedListB = listOf(-1, 0, 3, 5, 8, 9, 10, 16, 22, 66)

        assertEquals(sortedListB, bubbleSort(unsortedListB))

        val unsortedListC = mutableListOf(8, 1, 6, 3, 15)

        assertNotEquals(unsortedListB, bubbleSort(unsortedListC))
    }
}