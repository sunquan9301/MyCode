package JavaGeneric;

public class TypeVariable {
    public static void main(String[] args){

    }
}

class C {
    public    void mCPublic()    {}
    private   void mCPrivate()   {}
}

interface I {
    void mI();
}

class CT extends C implements I {
    public void mI() {}
}

class Test {
    <T extends C & I> void test(T t) {
        t.mI();           // OK
        t.mCPublic();     // OK
//        t.mCPrivate();    // Compile-time error
    }
}
