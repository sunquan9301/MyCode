package beautyCodingKotlin.ch03

class FunFunctions{
    var percent1 = 5
    private var percent2 = 9
    val percent3 = 13

    //是纯虚函数
    fun add(a:Int,b:Int) = a+b
    //是纯虚函数
    fun mult(a:Int,b:Int?):Int = 5
    //不是纯虚函数， b = 0会抛异常
    fun div(a:Int,b:Int) = a/b
    //是纯虚函数， b= 0.0 会返回Infinite
    fun div(a:Double,b:Double) = a/b
    //不是纯虚函数， 外部可改变percent1, 2次执行结果不一样
    fun applyTax1(a:Int) = a/100*(100+percent1)
    //不是纯虚函数， 外部可改变percent2, 2次执行结果不一样
    fun applyTax2(a:Int) = a/100*(100+percent2)
    //是纯虚函数
    fun applyTax3(a:Int) = a/100*(100+percent3)
    //不是纯虚函数， 结果改变了参数
    fun append(i:Int,list:MutableList<Int>):List<Int>{
        list.add(i)
        return list
    }


}