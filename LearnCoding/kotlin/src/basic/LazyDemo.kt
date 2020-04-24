package basic

class LazyDemo {
    var p: Int by Delegate()
}


fun main() {
    var l = LazyDemo()
    println("LazyDemo p = ${l.p}")
    l.p = 6
    println("LazyDemo p = ${l.p}")
}