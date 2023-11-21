package games.calculator;

import java.util.Scanner;

import static games.calculator.Operation.*;

public class Calculator {

    public static void main(String[] args) {
        Operation op = new Operation();
        Scanner sc = new Scanner(System.in);

        // 1. 입력
        System.out.print("사용할 연산자를 입력하세요 : ");
        String operator = sc.next();
        double[] array = getInts(sc);

        if (operator.equals("+")) {
            double sum = add(array[0], array[1]);
            System.out.println("덧셈 결과값 : " + sum + "입니다.");
        } else if (operator.equals("-")) {
            double subtractResult = substract(array[0], array[1]);
            System.out.println("뺄셈 결과값 : " + subtractResult + "입니다.");
        } else if (operator.equals("*")) {
            double multiplyResult = multiply(array[0], array[1]);
            System.out.println("곱셈 결과값 : " + multiplyResult + "입니다.");
        } else if (operator.equals("/")) {
            double devideResult = divide(array[0], array[1]);
            System.out.println("나눗셈 결과값 : " + devideResult + "입니다.");
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }
}
