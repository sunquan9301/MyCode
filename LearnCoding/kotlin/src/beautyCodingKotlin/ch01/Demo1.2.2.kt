package beautyCodingKotlin.ch01

fun main() {
    println(listOf<Int>(1, 2, 3, 4,5,6).groupBy { it % 2 == 0 }.values.map {
        println("map $it")
        it.reduce { a, b -> a + b }
    }.forEach { println("after map and reduce: " + it) })
    var p1 = Person("hahah");
    var p2 = Person("hahah");
    println(p1 == p2)
}


class Person(val name:String)