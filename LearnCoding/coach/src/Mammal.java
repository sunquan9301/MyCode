import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Mammal {

    boolean hasFur = true;

    public Mammal() {

        System.out.println("default Mammal constructor!");

    }

    public void makeSound() {
    }

    public static void main(String[] args) {

        double[] a = {3.5, 2.0, -11.5, 12};

        a[a.length-1] = 25.5;

        double sum = 0.0;

        for(int i = 0; i < a.length; i++) {

            sum += a[i];

        }

        System.out.println(sum/a.length);


    }

}

class Cat extends Mammal {

    boolean hasClaws;

    String furColor;

    public Cat() {
        super();
//        this("Let's try the other arg Cat constructor!!!");

        System.out.println("default Cat constructor!");

    }

    public Cat(String st) {

        System.out.println("Arg Cat constructor!" + st);

    }

    public void makeSound() {

        System.out.println("Meow!");

    }

}

class Persian extends Cat {

    String furColor = "White";

    public Persian() {

        super();

        System.out.println("default Persian constructor!");

    }

    public void makeSound() {

        System.out.println("Hisss!");

    }

}