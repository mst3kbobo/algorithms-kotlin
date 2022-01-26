fun main(args: Array<String>) {

    // Take a sorted array of integers and a target integer.
    // Return the index of the target if it's contained in the array. Return -1 if not.

    val target = 800
    val array = listOf(6, 21, 22, 39, 40, 52, 67, 87, 99, 101, 132, 186, 227)
    val expectedResult = -1

    println("Expected Result: $expectedResult\n" +
            "  Actual Result: ${binarySearchB(array, target)}")
}

// Space: O(1) Time: O(log(n))
private fun binarySearch(array: List<Int>, target: Int): Int {

    // Variables for indexes to keep track of left and right pointers on the array as we divide and conquer it.
    var leftIndex = 0
    var rightIndex = array.size - 1

    while (leftIndex <= rightIndex) {

        // Find middle of array to see if it's == to, <, or > the target
        // Explicit Int for division.
        val middleIndex: Int = (leftIndex + rightIndex) / 2
        val potentialMatch = array[middleIndex]

        if (target == potentialMatch) {
            return middleIndex
        } else if (target < potentialMatch) {
            rightIndex = middleIndex - 1
        } else if (target > potentialMatch) {
            leftIndex = middleIndex + 1
        }
    }

    return -1
}

// Validation
// [0,1,2, 3, 4, 5, 6, 7, 8]
// [3,6,8,10,12,33,39,40,67]
// 8
// 1 => l 0 r 8 m 4
// 2 => l 0 r 3 m 1
// 3 => l 2 r 3 m 2 == Found

// 2020-12-12 Space: 0(1) - Time: O(log(n)) for ~division of array at each pass
private fun binarySearchA(array: List<Int>, target: Int): Int {

    var left = 0
    var right = array.size - 1

    while (left <= right) {

        val middle: Int = (left + right) / 2 // Int division
        val potentialMatch = array[middle]

        if (target == potentialMatch) {
            return middle
        } else if (target < potentialMatch) {
            right = middle - 1
        } else {
            left = middle + 1
        }
    }

    return -1
}

// 2020-12-25 Space 0(1) Time O(log(n))
// Validation
// [0, 1, 2,  3,  4,  5,  6,  7,  8]
// [3, 6, 8, 10, 12, 33, 39, 40, 67]
// 40
// 1 => s 0 e 8 m 4
// 2 => s 4 e 8 m 6
// 3 => s 7 e 8 m 7 == Found
private fun binarySearchB(array: List<Int>, target: Int): Int {

    var start = 0
    var end = array.size - 1

    while (start <= end) {
        var middle = (start + end) / 2 // Int Division
        val potentialMatch = array[middle]

        if (target == potentialMatch) {
            return middle
        } else if (target < potentialMatch) {
            end = middle - 1
        } else {
            start = middle + 1
        }
    }
    return -1
}