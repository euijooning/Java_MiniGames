package games.calculator;

import java.util.Scanner;

public class Operation {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double substract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    public static double[] getInts(Scanner sc) {
        double[] array = userInput(sc);
        return array;
    }

    public static double[] userInput(Scanner sc) {
        double[] input = new double[2];

        System.out.print("첫 번째 숫자 입력 : ");
        input[0] = sc.nextDouble();
        System.out.print("두 번째 숫자 입력 : ");
        input[1] = sc.nextDouble();

        return input;
    }
}
