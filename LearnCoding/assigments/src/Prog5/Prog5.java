package Prog5;

import java.util.Scanner;

public class Prog5 {
    public static final int UPDATE = 1;
    public static final int PRINT = 2;
    public static final int EXIT = 3;
    private static String line = "----------------------------------------";

    // Don’t have any other public/private data defined in this // section.
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Prog5.");
        System.out.println("Press ENTER to continue...");
        in.nextLine();
        MyStudent myStudent = createStudent(in);
        int choice;
        do {
            printMenu();
            choice = getChoice(in);
            if (choice == UPDATE)
                doUpdate(in, myStudent);
            else if (choice == PRINT)
                doPrint(myStudent);
        } while (choice != EXIT);
        System.out.println("Done. Normal termination.");
    }


    public static void printMenu() {
        System.out.println(line);
        // Print out the choices.
        System.out.println("Here are your options:\n" +
                "1. UPDATE student.\n" +
                "2. PRINT student.\n" +
                "3. EXIT.");
    }

    public static int getChoice(Scanner cin) {
        System.out.print("Enter your choice: ");
        int choice = 0;
        while (true) {
            choice = cin.nextInt();
            if (choice == UPDATE || choice == PRINT || choice == EXIT) break;
            System.out.println("ERROR -- invalid choice.");
            System.out.print("Enter your choice: ");
        }
        return choice;
    }


    public static MyStudent createStudent(Scanner in) {
        System.out.println(line);
        System.out.println("CREATE a new student...");
        String first, last, ID;
        double gradePoints;
        int credits;
        // Prompt for and input:
        // 1.ID
        // 2. Last name
        // 3. First name
        // 4. Total grade points (as a double)
        // 5. Total credits (as an int)
        // Create a new MyStudent with the given input
        // values and return it.
        System.out.print("Enter identification (ID) number: ");
        ID = in.nextLine();
        System.out.print("Enter LAST name: ");
        last = in.nextLine();
        System.out.print("Enter FIRST name: ");
        first = in.nextLine();
        System.out.print("Enter total grade points: ");
        gradePoints = in.nextDouble();
        System.out.print("Enter total credits: ");
        credits = in.nextInt();
        return new MyStudent(ID, first, last, credits, gradePoints);
    }

    public static void doUpdate(Scanner in, MyStudent stu) {
        System.out.println(line);
        System.out.println("Enter credits: ");
        int numCredits = in.nextInt();
        System.out.println("Enter letter grade: ");
        String letterGrade = in.next();
        stu.takeClass(numCredits, letterGrade);
    }

    public static void doPrint(MyStudent stu) {
        System.out.println(line);
        System.out.println("ID: " + stu.getID());
        System.out.println("Name: " + stu.getLastName() + ", " + stu.getFirstName());
        System.out.println("GPA: " + (int) ((stu.getGPA()) * 100f) / 100f);
    }

}
