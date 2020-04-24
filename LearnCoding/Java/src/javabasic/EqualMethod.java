package javabasic;

public class EqualMethod {


    public static void main(String[] args) {
        MyBoolean x = new MyBoolean();
        System.out.println(x.equals(x));
        String str ="A"+"B";
        System.out.println(str == "AB");
    }
}

class MyBoolean {
    boolean value;

    public boolean equals(Object object) {
        boolean equals;
        if (object != null && this.getClass() == object.getClass()) {
            MyBoolean other = (MyBoolean) object;
            equals = this.value && other.value;
        } else {
            equals = false;
        }
        return equals;
    }

}