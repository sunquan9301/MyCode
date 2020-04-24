package basic

import kotlin.reflect.KProperty

class Delegate {
    operator fun getValue(lazyDemo: LazyDemo, property: KProperty<*>): Int {
        println("getValue")
        return 1;
    }

    operator fun setValue(lazyDemo: LazyDemo, property: KProperty<*>, i: Int) {
        println("setValue, i = ${i}")
    }

}

