package exam;

/**
 * Second midterm exam - Spring 2020
 * <p>
 * This exam is open book, open note, but must be completed
 * <p>
 * as a SOLO effort - no partners or others are to be consulted
 * <p>
 * on this exam.  Outside sources should be restricted to just
 * <p>
 * the material used in class and the Java API - you should
 * <p>
 * not need to consult or use any other documentation.
 * <p>
 * <p>
 * <p>
 * My name below indicates that in accordance with the Ohio
 * <p>
 * State University Code of Student Conduct I understand that this exam is
 * <p>
 * to be completed without consulting others or using outside
 * <p>
 * sources other than the ones listed in the instructions above. And
 * <p>
 * that I will not discuss this exam with anyone who has not taken it
 * <p>
 * until after it has been graded and returned.
 *
 * @author YOUR NAME HERE
 * @version DATE HERE
 */

import java.util.Arrays;
import java.util.Scanner;


public class VariousMethods {


    /**
     * Returns true if the parameter c is a "vowelish" character, which
     * is defined to be a lowercase 'a', 'e', 'i', 'o', or 'u'.  Otherwise
     * returns false.
     *
     * @param c character to check for "vowelish"-ness
     * @return true if c is lowercase 'a','e','i','o','u', false otherwise
     */

    public static boolean isVowelish(char c) {

        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }


    /**
     * Returns a new String that is a copy of the parameter str with
     * the "vowelish" characters as defined above removed.  For example,
     * if str = "349 Nosuch Ave" this method would return "349 Nsch Av".
     * For full credit this methods MUST make use of the isVowelish
     * method above.
     *
     * @param str the String to remove vowelish characters from
     * @return a new copy of str with the vowelish characters removed
     */

    public static String disemvowel(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (!isVowelish(c)) sb.append(c);
            ;
        }
        return sb.toString();
    }


    /**
     * See the exam write-up for details on this method.
     *
     * @param input a Scanner to read input from.
     */

    public static void promptAndRemoveVowelish(Scanner input) {
        System.out.print("Enter a line:");
        String s = input.nextLine();
        if (s.trim().length() == 0) {
            System.out.println("Goodbye!");
            return;
        }
        System.out.println("Disemvoweled:" + disemvowel(s));
        promptAndRemoveVowelish(input);

    }


    /**
     * Returns a new array that has the same contents as the
     * parameter arr but in reverse order.  For example, if
     * arr = {"abc", "def", "ghi"}, then this method will
     * return a new array containing {"ghi", "def", "abc"}.
     * The original array arr should be unchanged.  YOU MAY
     * NOT USE ANY BUILT-IN REVERSE METHODS IN YOUR
     * IMPLEMENTATION.
     *
     * @param arr the array to reverse.
     * @return a new array that is the reverse of the array arr
     */

    public static String[] reverseArray(String[] arr) {
        String[] newArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) newArr[i] = arr[arr.length-i-1];
        return newArr;
    }


    /**
     * Modifies the parameter arr in place so that every String
     * in the array is of length len.  Strings that are too long
     * get truncated, Strings that are too short are padded with
     * '_' characters.  For example, if arr = {"Now", "have", "a",
     * "test" } and len = 3, then arr should be modified to be
     * {"Now", "hav", "a__", "tes"}.
     *
     * @param arr array holding original String values
     * @param len length to set Strings in arr to
     */

    public static void setLengths(String[] arr, int len) {
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            String newStr = "";
            if (s.length() >= len) newStr = s.substring(0, len);
            else {
                int gap = len - s.length();
                StringBuilder sb = new StringBuilder();
                sb.append(s);
                for (int j = 0; j < gap; j++) {
                    sb.append("_");
                }
                newStr = sb.toString();
            }
            arr[i] = newStr;
        }
    }


    /**
     * See the exam write-up for details on this method
     *
     * @param input a Scanner to read input from
     * @return an array of Strings.
     */

    public static String[] promptForNames(Scanner input) {
        String[] strArr;
        System.out.print("Names to store:");

        try {
            int count = Integer.valueOf(input.nextLine());
            strArr = new String[count];
            for (int i = 0; i < strArr.length; i++) {
                System.out.print("Name:");
                strArr[i] = input.nextLine();
            }
            return strArr;
        } catch (Exception e) {
            System.out.println("Please input correct count of names");
            e.printStackTrace();
        }
        return new String[0];
    }


    // NOTE: DO NOT CHANGE ANYTHING IN THIS METHOD!

    // This method will produce the output that

    // zyBooks is looking for for some of its automated

    // tests.

    public static void runTests(Scanner input) {

        System.out.println("Is 'a' vowelish? " + isVowelish('a'));

        System.out.println("Is 'A' vowlish? " + isVowelish('A'));

        System.out.println("Is 'x' vowelish? " + isVowelish('x'));

        System.out.println("Is 'Z' vowelish? " + isVowelish('Z'));

        System.out.println(disemvowel("349 Nosuch Ave"));

        System.out.println(disemvowel("123 Fake Street"));

        System.out.println(disemvowel("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG"));

        System.out.println(disemvowel("the quick brown fox jumps over the lazy dog"));

        String[] array = {"Bob", "Mary", "Carol", "Fred"};

        System.out.println(Arrays.toString(reverseArray(array)));

        setLengths(array, 5);

        System.out.println(Arrays.toString(array));

        promptAndRemoveVowelish(input);

        String[] names = promptForNames(input);

        System.out.println(Arrays.toString(names));

        System.out.println("Reversing array of names:");

        System.out.println(Arrays.toString(reverseArray(names)));

    }


    // NOTE: You may comment out the call to runTests

    //       and enter your own main code.  However before

    //       making your final submission make sure you

    //       have put this method back to how it started!

    public static void main(String[] args) {

        //Set up the Scanner

        Scanner keyboard = new Scanner(System.in);


        // Call runTests (comment this out to create your own small tests,

        // but uncomment it and remove your tests before submitting)

        runTests(keyboard);


        // Close the Scanner.

        keyboard.close();

    }

}
