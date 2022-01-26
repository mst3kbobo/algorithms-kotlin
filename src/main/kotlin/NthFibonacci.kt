fun main(args: Array<String>) {

    // Get the Nth number from the Fibonacci Sequence
    // 0,1,1,2,3,5,8,13,21,34
    val target = 9
    val expectedResult = 21

    println("Expected Result: $expectedResult, Actual Result: ${getNthFibIterative(target)}")
}

// Time O(n^2) Space O(n)
/*fun getNthFib(number: Int): Int {

    if (number == 2) {
        return 1
    } else if (number == 1) {
        return 0
    } else {
        return getNthFib(number - 1) + getNthFib(number - 2)
    }
}*/

// Time: O(n) - Space O(n)
fun getNthFibWithCache(number: Int,
                       cache: MutableMap<Int,Int> = mutableMapOf(1 to 0, 2 to 1)): Int {

    if (cache.containsKey(number)) {
        return cache[number]!!
    } else {
        cache[number] = getNthFibWithCache(number - 1, cache) +
                getNthFibWithCache(number - 2, cache)
        return cache[number]!!
    }
}

// Time: O(n) - Space O(1)
fun getNthFibIterative(number: Int): Int {

    val lastTwo = mutableListOf(0,1) // Tracking List
    var counter = 3 // The next fib we want to calculate

    while (counter <= number) {
        val nextFib = lastTwo[0] + lastTwo[1]
        lastTwo[0] = lastTwo[1]
        lastTwo[1] = nextFib
        counter += 1
    }
    
    // Edge case if we're requesting 1st number in the sequence
    return if (number > 1) lastTwo[1] else lastTwo[0]
}