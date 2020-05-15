package Prog3;

import java.util.Scanner;

public class Prog3 {
    public static final String LINE = "-----------------------------";

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter weights (quizzes, labs, programs, exams): ");
        int[] weightArr = new int[]{cin.nextInt(), cin.nextInt(), cin.nextInt(), cin.nextInt()};
        System.out.print("Enter maximum scores (quizzes, labs, programs, exams): ");
        int qMax = cin.nextInt();
        int lMax = cin.nextInt();
        int pMax = cin.nextInt();
        int eMax = cin.nextInt();
        System.out.println();
        int count = 0;
        double min = 100, max = 0, sum = 0;
        int rawAverage, adjustAverage;
        double deviation = 0;
        double[] scoreArr;
        double[] adjustAverageArr = new double[4];
        //quiz section
        System.out.print("How many QUIZ scores?");
        count = cin.nextInt();
        System.out.print("Enter QUIZ scores: ");
        scoreArr = new double[count];
        for (int i = 0; i < count; i++) {
            scoreArr[i] = cin.nextDouble();
            min = Math.min(min, scoreArr[i]);
            max = Math.max(max, scoreArr[i]);
            sum += scoreArr[i];
        }
        rawAverage = (int) (sum / (1.0f * count * qMax) * 100);
        adjustAverage = (int) ((sum - min) / (1.0f * (count - 1) * qMax) * 100);
        for (int i = 0; i < count; i++) {
            deviation = deviation + (scoreArr[i] - sum / count) * (scoreArr[i] - sum / count);
        }
        deviation = Math.sqrt(deviation / count);
        System.out.println();
        System.out.println("QUIZ summary");
        System.out.println(LINE);
        System.out.println(
                "              How many: " + count + "\n" +
                        "                   Min: " + min + "\n" +
                        "                   Max: " + max + "\n" +
                        "           Raw average: " + rawAverage * 1.0f / 100 + "\n" +
                        "      Adjusted average: " + adjustAverage * 1.0f / 100 + "\n" +
                        "Raw standard deviation: " + (int) (deviation * 100f) / 100f);
        adjustAverageArr[0] = (sum - min) / (1.0f * (count - 1) * qMax);

        //lab
        System.out.println();
        System.out.println();
        sum = 0;
        min = 100;
        max = 0;
        deviation = 0;
        System.out.print("How many LAB scores?");
        count = cin.nextInt();
        System.out.print("Enter LAB scores: ");
        scoreArr = new double[count];
        for (int i = 0; i < count; i++) {
            scoreArr[i] = cin.nextDouble();
            min = Math.min(min, scoreArr[i]);
            max = Math.max(max, scoreArr[i]);
            sum += scoreArr[i];
        }
        rawAverage = (int) (sum / (1.0f * count * lMax) * 100);
        adjustAverage = (int) ((sum - min) / (1.0f * (count - 1) * lMax) * 100);
        for (int i = 0; i < count; i++) {
            deviation = deviation + (scoreArr[i] - sum / count) * (scoreArr[i] - sum / count);
        }
        deviation = Math.sqrt(deviation / count);
        System.out.println();
        System.out.println("LAB summary");
        System.out.println(LINE);
        System.out.println(
                "              How many: " + count + "\n" +
                        "                   Min: " + min + "\n" +
                        "                   Max: " + max + "\n" +
                        "           Raw average: " + rawAverage * 1.0f / 100 + "\n" +
                        "      Adjusted average: " + adjustAverage * 1.0f / 100 + "\n" +
                        "Raw standard deviation: " + (int) (deviation * 100f) / 100f);
        adjustAverageArr[1] = (sum - min) / (1.0f * (count - 1) * lMax);

        //program
        System.out.println();
        sum = 0;
        min = 100;
        max = 0;
        deviation = 0;
        System.out.print("How many PROGRAM scores?");
        count = cin.nextInt();
        System.out.print("Enter PROGRAM scores: ");
        scoreArr = new double[count];
        for (int i = 0; i < count; i++) {
            scoreArr[i] = cin.nextDouble();
            min = Math.min(min, scoreArr[i]);
            max = Math.max(max, scoreArr[i]);
            sum += scoreArr[i];
        }
        rawAverage = (int) (sum / (1.0f * count * pMax) * 100);
        for (int i = 0; i < count; i++) {
            deviation = deviation + (scoreArr[i] - sum / count) * (scoreArr[i] - sum / count);
        }
        deviation = Math.sqrt(deviation / count);
        System.out.println();
        System.out.println("LAB summary");
        System.out.println(LINE);
        System.out.println(
                "              How many: " + count + "\n" +
                        "                   Min: " + min + "\n" +
                        "                   Max: " + max + "\n" +
                        "           Raw average: " + rawAverage * 1.0f / 100 + "\n" +
                        "Raw standard deviation: " + (int) (deviation * 100f) / 100f);
        adjustAverageArr[2] = sum / (1.0f * count * pMax);

        //EXAM
        System.out.println();
        sum = 0;
        min = 0;
        max = 0;
        deviation = 0;
        System.out.print("How many EXAM scores?");
        count = cin.nextInt();
        System.out.print("Enter EXAM scores: ");
        scoreArr = new double[count];
        for (int i = 0; i < count; i++) {
            scoreArr[i] = cin.nextDouble();
            min = Math.min(min, scoreArr[i]);
            max = Math.max(max, scoreArr[i]);
            sum += scoreArr[i];
        }
        rawAverage = (int) (sum / (1.0f * count * eMax) * 100);
        for (int i = 0; i < count; i++) {
            deviation = deviation + (scoreArr[i] - sum / count) * (scoreArr[i] - sum / count);
        }
        deviation = Math.sqrt(deviation / count);
        System.out.println();
        System.out.println("LAB summary");
        System.out.println(LINE);
        System.out.println(
                "              How many: " + count + "\n" +
                        "                   Min: " + min + "\n" +
                        "                   Max: " + max + "\n" +
                        "           Raw average: " + rawAverage * 1.0f / 100 + "\n" +
                        "Raw standard deviation: " + (int) (deviation * 100f) / 100f);
        adjustAverageArr[3] = sum / (1.0f * count * eMax);


        //FINAL
        double finalAverage = 0;
        for (int i = 0; i < adjustAverageArr.length; i++) {
            finalAverage += (adjustAverageArr[i] * (weightArr[i] / 100f));
        }
        System.out.println("FINAL summary");
        System.out.println("Final grade adjusted average: " + (int) (finalAverage * 100f) / 100f);
        String letter = "";
        if (finalAverage > 91) letter = "A";
        else if (finalAverage > 89) letter = "A-";
        else if (finalAverage > 87) letter = "B+";
        else if (finalAverage > 81) letter = "B";
        else if (finalAverage > 79) letter = "B-";
        else if (finalAverage > 77) letter = "C+";
        else if (finalAverage > 71) letter = "C";
        else if (finalAverage > 69) letter = "C-";
        else if (finalAverage > 67) letter = "D+";
        else if (finalAverage > 61) letter = "D";
        else if (finalAverage > 55) letter = "D-";
        else letter = "F";
        System.out.println("Final grade adjusted letter: " + letter);
        System.out.println("DONE. Normal termination.");


    }

}
