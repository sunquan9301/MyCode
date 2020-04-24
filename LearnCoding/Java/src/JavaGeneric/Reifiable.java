package JavaGeneric;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Reifiable {
    public static void main(String[] args) {
        // a cast to a type that is not reifiable usually issues a warning
        List<? super Integer> list =new ArrayList();
        //Instance Tests and Casts
//        System.out.println(allZero(list));

    }
    /**
     *  Instance Tests and Casts
     */
    public static int allZero(List<Integer> ints) {
        return ints.size();
    }


    /**
     *  Nonreifiable Casts
     */
    //A cast to a type that is not reifiable usually issues a warning.
    //c is subtype of Collections<T>; and then c instanceOf List<?> so c must is subytpe of List<T>
    //so it is not need to issues a warning with not reifiable
    public static <T> List<T> asList(Collection<T> c)
            throws InvalidArgumentException
    {
        if (c instanceof List<?>) {
            return (List<T>)c;
        } else throw new InvalidArgumentException(new String[]{"aaa","bbb"});
    }
}
