package Prog5;

import java.util.HashMap;

public class MyStudent {
    private String ID;
    private String firstName;
    private String lastName;
    int credits;
    double gradePoints;
    HashMap<String, Double> map = new HashMap();

    public MyStudent(String ID, String firstName, String lastName, int credits, double gradePoints) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credits = credits;
        this.gradePoints = gradePoints;
        map.put("A", 4.00);
        map.put("A-", 3.67);
        map.put("B+", 3.33);
        map.put("B", 3.00);
        map.put("B-", 2.67);
        map.put("C+", 2.33);
        map.put("C", 2.00);
        map.put("C-", 1.67);
        map.put("D+", 1.33);
        map.put("D", 1.00);
        map.put("D-", 0.67);
        map.put("F", 0.00);
    }

    public String getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getGPA() {
        return gradePoints / credits;
    }

    public void takeClass(int credit, String letter) {
        credits += credit;
        gradePoints += credit * map.get(letter);
    }
}
