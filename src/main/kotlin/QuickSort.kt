fun main(args: Array<String>) {

    val expectedResult = listOf(
            0, 1, 3, 5, 6, 9,
            10, 10, 11, 13, 21, 28, 32, 35, 43, 44, 51, 67, 77, 89,
            100, 106, 109, 110, 225, 322, 356, 365, 854
    )
    val array = expectedResult.shuffled().toMutableList()

    println("          Input: $array")
    println("Expected Result: $expectedResult")

    quickSort(array, 0, array.size - 1)

    println("  Actual Result: $array")
}

// Do not return a new array, Sort and Swap in place

fun quickSort(array: MutableList<Int>, startIndex: Int, endIndex: Int) {

    if (startIndex >= endIndex) {
        return
    }

    //[0,1,2,3,4,5,6]
    //[7,6,1,3,8,3,5]
    //[R L   P      ]

    var pivotIndex = startIndex
    var leftIndex = pivotIndex + 1
    var rightIndex = endIndex

    while (leftIndex <= rightIndex) {
        if (array[leftIndex] > array[pivotIndex] && array[rightIndex] < array[pivotIndex]) {
            swap(leftIndex, rightIndex, array)
        }
        if (array[leftIndex] <= array[pivotIndex]) {
            leftIndex += 1
        }
        if (array[rightIndex] >= array[pivotIndex]) {
            rightIndex -= 1
        }
    }

    swap(rightIndex, pivotIndex, array)

    // determine subArray sizes and recursive call starting with the smaller one
    val leftSize = rightIndex - startIndex
    val rightSize = endIndex - rightIndex

    if (leftSize < rightSize) {
        quickSort(array, startIndex, rightIndex - 1)
        quickSort(array, rightIndex + 1, endIndex)
    } else {
        quickSort(array, rightIndex + 1, endIndex)
        quickSort(array, startIndex, rightIndex - 1)
    }

}

private fun swap(a: Int, b: Int, array: MutableList<Int>) {
    val prevA = array[a]
    array[a] = array[b]
    array[b] = prevA
}