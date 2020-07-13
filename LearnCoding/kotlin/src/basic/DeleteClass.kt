package basic

interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() {
        print("haha" + x)
    }
}

class Derived(val b: Base) : Base by b {
    override fun print() {
        print("derived")
        b.print()
    }
}

fun main() {
    val b = BaseImpl(10)
    Derived(b).print()
}