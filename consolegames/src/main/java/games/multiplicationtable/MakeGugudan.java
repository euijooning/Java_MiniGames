package games.multiplicationtable;

import java.util.Scanner;

public class MakeGugudan {
    static int input1(Scanner sc) {
        System.out.println("[원하시는 메뉴를 선택하세요]");
        System.out.println("1. 구구단 출력");
        System.out.println("2. 종료");
        System.out.print("번호 선택 > ");
        int num = sc.nextInt();
        return num;
    }

    static int input2(Scanner sc) {
        System.out.println("[다음 중에서 고르시오]");
        System.out.println("1.원하는 구구단 출력");
        System.out.println("2.전체 구구단 출력");
        System.out.print("선택 > ");
        int select = sc.nextInt();
        return select;
    }

    static int inputWantGugu(Scanner sc) {
        System.out.print("원하는 단 숫자 입력 : ");
        int dan = sc.nextInt();
        return dan;
    }

    static void wantDan(int dan) { // 출력만 하면 되므로 void 써도 됨.
        System.out.println();
        System.out.println("[" + dan + "단]");
        for (int j = 1; j < 10; j++) {
            System.out.println(dan + " X " + j + " = " + (dan * j));
        }
    }

    static void allGugu() {
        for (int i = 2; i < 10; i++) { // 단
            System.out.println();
            System.out.println("["  + i + "단]");
            for (int j = 1; j < 10; j++) { // 곱해지는 수
                System.out.println(i + " X " + j + " = " + (i * j));
            }
        }
    } // 입력했을 때 따로 뭐 에러났던 게 없으니까 이것도 파라미터는 필요가 없다.

    static void wrongPrint() {
        System.out.println("잘못된 번호 선택입니다.");
    }

    static void run() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int num = input1(sc);
            if(num == 1) {
                int gugu = input2(sc);// 이것도 위의 num 상황과 마찬가지.

                if (gugu == 1) {
                    wantDan(inputWantGugu(sc));

                } else if (gugu == 2) {
                    allGugu();
                }
                else {
                    wrongPrint();
                }
            }

            else if (num == 2) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else {
                wrongPrint();
            }
        }
    }
}
