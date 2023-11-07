package games.FastFood;

import java.util.Scanner;

public class FastFoodOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("---햄버거집입니다. 안내에 따라주세요.---");
        while (true) {
            System.out.println("[[메뉴를 선택하세요]]");
            System.out.println("1. 갈릭버거");
            System.out.println("2. 새우버거");
            System.out.println("3. 치즈버거");
            System.out.println("4. 크리스피 치킨");
            System.out.println("5. 프로그램 종료");

            System.out.println();
            System.out.print("메뉴 번호를 입력하세요: ");

            int menuChoice = sc.nextInt();
            if (menuChoice == 5) {
                System.out.println("프로그램을 종료합니다.");
                break;

            } else if (menuChoice < 1 || menuChoice > 4) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }

            String[] menuItems = {"갈릭버거", "새우버거", "치즈버거", "크리스피 치킨"};
            String menu = menuItems[menuChoice - 1]; // 배열의 숫자 맞추기

            System.out.println("사이드 메뉴를 선택하세요:");
            System.out.println("1. 감자튀김");
            System.out.println("2. 콜라");
            System.out.println("3. 사이다");
            System.out.print("사이드 메뉴 번호를 입력하세요: ");
            int sideChoice = sc.nextInt();

            String[] sideItems = {"감자튀김", "콜라", "사이다"};
            if (sideChoice < 1 || sideChoice > 3) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }
            String sideMenu = sideItems[sideChoice - 1];

            System.out.print("결제 방법을 입력하세요 (카드/현금/상품권): ");
            String paymentMethod = sc.next();

            if (isValidPaymentMethod(paymentMethod)) {
                System.out.println("주메뉴: " + menu + ", 사이드 메뉴: " + sideMenu + ", 결제 수단: " + paymentMethod);
            } else {
                System.out.println("잘못된 결제 수단입니다.");
            }
        }
    }

    // 유효한 결제 수단인지 확인하는 메서드
    public static boolean isValidPaymentMethod(String payment) {
        return payment.equals("카드") || payment.equals("현금") || payment.equals("상품권");
    }
}
