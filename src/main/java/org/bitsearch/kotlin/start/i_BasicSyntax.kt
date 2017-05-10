/**
 * Defining packages
 */
package org.bitsearch.kotlin.start

/**
 *
 * @author Asion.
 * @since 2017/4/11.
 */
fun main(array: Array<String>) {
    // functions
    print("sum of 3 and 5 is ")
    println(sum(3, 5))
    println("19 sub 23 is ${sub(19, 23)}")

    // no meaningful value
    printSum(-1, 8)
    printSub(-1, 8)

    // val
    testVariable()
    // var
    testMutableVariable()

    // comments
    testComments()

    // string templates
    testStringTemplates()

    // conditional expressions
    println("max of 0 and 42 is ${maxOf(0, 42)}")
    println("min of 0 and 42 is ${minOf(0, 42)}")

    // nullable
    printProduct("", "")
    printProduct("6", "7")
    printProduct("a", "7")
    printProduct("a", "b")

    //
    testTypeChecksAndAutomaticCasts()

    // for loop
    testForLoop()

    // while loop
    testWhileLoop()

    // when expression
    testWhen()

    testRange1()
    testRange2()
    testRange3()

    testCollections1()
    testCollections2()
}

/**
 * defining functions
 */
// Function having two Int parameters with Int return type:
fun sum(a: Int, b: Int): Int {
    return a + b
}

// Function with an expression body and inferred return type:
fun sub(a: Int, b: Int) = a - b

// Function returning no meaningful value:
fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

// Unit return type can be omitted:
fun printSub(a: Int, b: Int) {
    println("$a sub $b is ${a - b}")
}

/**
 * Defining local variables
 */
// Assign-once (read-only) local variable:
fun testVariable() {
    val a: Int = 1
    val b = 2
    val c: Int

    c = a + b

    println("a = $a, b = $b, c = $c")
}

// Mutable variable
fun testMutableVariable() {
    var x = 5
    x += 1
    println("x = $x")
}

/**
 * Comments
 */
fun testComments() {
    // This is an end-of-line comment
    /*
     This is a block comment
     on multiple lines.
     */
    println("test comments!")
}


/**
 * Using string templates
 */
fun testStringTemplates() {
    var a = 1
    // simple name in template:
    val s = "a is $a"

    a = 2
    // arbitrary expression in template:
    val s2 = "${s.replace("is", "war")}, but now is $a"
    println(s2)
}

/**
 * Using conditional expressions
 */
fun maxOf(a: Int, b: Int): Int {
    if (a > b)
        return a
    else
        return b
}

fun minOf(a: Int, b: Int) = if (a < b) a else b

/**
 * Using nullable values and checking for null
 */
fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // Using `x * y` yields error because they may hold nulls.
    if (x != null && y != null) {
        // x and y are automatically cast to non-nullable after null check
        println(x * y)
    } else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}

/**
 * Using type checks and automatic casts
 */
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // `obj` is automatically cast to `String` in this branch
        return obj.length
    }
    // `obj` is still of type `Any` outside of th type-checked branch
    return null
}

fun getStringLength1(obj: Any): Int? {
    if (obj !is String) return null

    // `obj` is automatically cast to `String` in this branch
    return obj.length
}

//fun getStringLength(obj: Any): Int? {
//    // `obj` is automatically cast to `String` on the right-hand side of `&&`
//    if (obj is String && obj.length > 0) {
//        return obj.length
//    }
//
//    return null
//}

fun testTypeChecksAndAutomaticCasts() {
    fun printLength(obj: Any) {
        println("'$obj' string length is ${getStringLength(obj) ?: "... err, not a string"}")
    }

    printLength("Incomprehensibilities")
    printLength(1000)
    printLength(listOf(Any()))

    fun printLength1(obj: Any) {
        println("'$obj' string length is ${getStringLength1(obj) ?: "... err, not a string"}")
    }

    printLength1("Incomprehensibilities")
    printLength1(1000)
    printLength1(listOf(Any()))
}

/**
 * Using a for loop
 */
fun testForLoop() {
    val items = listOf("中文", "English", "fffff")
    for (i in items)
        println(i)

    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

/**
 * Using a while loop
 */
fun testWhileLoop() {
    val items = listOf("中", "English", "kiwi")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

/**
 * Using when expression
 */
fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

fun testWhen() {

    println(describe(1))
    println(describe("Hello"))
    println(describe(1000L))
    println(describe(2))
    println(describe("other"))

}

// Using ranges
/**
 * Check if a number is within a range using in operator:
 */
fun testRange1() {
    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("fits in range")
    }
}

/**
 * Check if a number is out of range:
 */
fun testRange2() {
    val list = listOf("a", "b", "c")

    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range too")
    }
}

/**
 * Iterating over a range:
 */
fun testRange3() {
    for (x in 1..5) {
        print(x)
    }
    for (x in 1..10 step 2)
        print(x)

    for (x in 1..9 step 3)
        print(x)
}

/**
 * Using collections
 */
fun testCollections1() {
    val items = setOf("apple", "banana", "kiwi")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
}

fun testCollections2() {
    val fruits = listOf("banana", "avocado", "apple", "kiwi")

    fruits.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}