package games.fastfood;

import java.util.Scanner;

public class FastFoodChain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String menu;
        String sideMenu;
        String pay;

        boolean check = true; // true / false로 빠져나오게 하기 위해서 만들어줌.
        while (check) {
            // 큰 틀 : 전체 메뉴 선택 분기
            System.out.print("메뉴를 입력하세요. \n 1.갈릭버거 2.페페로니 3.페포로니치킨 4.콜로수워치킨 \n : ");
            int menuNum = sc.nextInt();

            switch (menuNum) {
                // 메인 메뉴가 들어가면, 사이드 메뉴 선택하는 분기 스위치 케이스 분류
                // 일단 메뉴 선택 분기
                case 1:
                    menu = "갈릭버거";
                    System.out.print("사이드 메뉴를 입력하세요.> 1.감자튀김 2.콜라 3. 사이다 \n : ");
                    int sideNum1 = sc.nextInt();

                    // 이 안에 사이드 메뉴 선택 분기
                    switch (sideNum1) {
                        case 1:
                            sideMenu = "감자튀김";
                            System.out.println("결제 방법을 입력하세요.> \"카드\" / \"현금\" / \"상품권\" ");
                            pay = sc.next();

                            // 결제 수단 if문 분기
                            if (pay.equals("카드") || pay.equals("현금") || pay.equals("상품권")) {
                                System.out.println(
                                        "주메뉴 : " + menu + ", " + " 사이드 메뉴 : " + sideMenu + ",  " + "결제 수단 : " + pay);
                            } else {
                                System.out.println("잘못된 결제수단입니다. ");
                            }

                            break; // 선택 끝 // 메뉴 선택으로 간다.

                        // 사이드메뉴 케이스 2
                        case 2:
                            sideMenu = "콜라";
                            System.out.println("결제 방법을 입력하세요.> \"카드\" / \"현금\" / \"상품권\" ");
                            pay = sc.next();

                            // 결제 수단 if문 분기
                            if (pay.equals("카드") || pay.equals("현금") || pay.equals("상품권")) {
                                System.out.println(
                                        "주메뉴 : " + menu + ", " + " 사이드 메뉴 : " + sideMenu + ",  " + "결제 수단 : " + pay);
                            } else {
                                System.out.println("잘못된 결제수단입니다. ");
                            }
                            break; // 메뉴 입력으로 가는 break

                        //사이드메뉴 선택 케이스 3
                        case 3:
                            sideMenu = "사이다";
                            System.out.println("결제 방법을 입력하세요.> \"카드\" / \"현금\" / \"상품권\" ");
                            pay = sc.next();
                            // 결제 수단 if문 분기
                            if (pay.equals("카드") || pay.equals("현금") || pay.equals("상품권")) {
                                System.out.println(
                                        "주메뉴 : " + menu + ", " + " 사이드 메뉴 : " + sideMenu + ",  " + "결제 수단 : " + pay);
                            } else {
                                System.out.println("잘못된 결제수단입니다. ");
                            }
                            break; //메뉴 입력으로 가는 break

                        default:
                            System.out.println("잘못된 사이드 메뉴 입력입니다. 다시 입력하세요.");
                            break;//메뉴 입력으로 가는 break
                    }
                    break;

                case 2:
                    menu = "페퍼로니";
                    System.out.print("사이드 메뉴를 입력하세요.> 1.감자튀김 2.콜라 3. 사이다 \n : ");
                    int sideNum2 = sc.nextInt();

                    switch (sideNum2) {
                        case 1:
                            sideMenu = "감자튀김";
                            System.out.println("결제 방법을 입력하세요.> \"카드\" / \"현금\" / \"상품권\" \n : ");
                            pay = sc.next();
                            // 결제 수단 if문 분기 2
                            if (pay.equals("카드") || pay.equals("현금") || pay.equals("상품권")) {
                                System.out.println(
                                        "주메뉴 : " + menu + " / " + "사이드 메뉴 : " + sideMenu + " / " + "결제 수단 : " + pay);
                            } else {
                                System.out.println("잘못된 결제수단입니다. ");
                            }
                            break;

                        case 2:
                            sideMenu = "콜라";
                            System.out.println("결제 방법을 입력하세요.> \"카드\" / \"현금\" / \"상품권\" \n :");
                            pay = sc.next();
                            // 결제 수단 if문 분기
                            if (pay.equals("카드") || pay.equals("현금") || pay.equals("상품권")) {
                                System.out.println(
                                        "주메뉴 : " + menu + " / 사이드 메뉴 : " + sideMenu + " / 결제 수단 : " + pay);
                            } else {
                                System.out.println("잘못된 결제수단입니다.");
                            }
                            break;

                        case 3:
                            sideMenu = "사이다";
                            System.out.println("결제 방법을 입력하세요.> \"카드\" / \"현금\" / \"상품권\" \n : ");
                            pay = sc.next();
                            // 결제 수단 if문 분기
                            if (pay.equals("카드") || pay.equals("현금") || pay.equals("상품권")) {
                                System.out.println(
                                        "주메뉴 : " + menu + " / 사이드 메뉴 : " + sideMenu + " / 결제수단 : " + pay);
                            } else {
                                System.out.println("잘못된 결제수단입니다.");
                            }
                            break;

                        default:
                            System.out.println("잘못된 사이드 메뉴 입력입니다.");
                            break;
                    }
                    break;

                case 3:
                    menu = "페포로니치킨";
                    System.out.print("사이드 메뉴를 입력하세요.> 1.감자튀김 2.콜라 3. 사이다 \n : ");
                    int sideNum3 = sc.nextInt();

                    switch (sideNum3) {
                        case 1:
                            sideMenu = "감자튀김";
                            System.out.println("결제 수단을 입력하세요. > \"카드\" / \"현금\" / \"상품권\" \n :");
                            pay = sc.next();

                            if (pay.equals("카드") || pay.equals("현금") || pay.equals("상품권")) {
                                System.out.println(
                                        "주메뉴 : " + menu + " / 사이드 메뉴 : " + sideMenu + " / 결제수단 : " + pay);
                            } else {
                                System.out.println("잘못된 결제수단입니다.");
                            }

                        case 2:
                            sideMenu = "콜라";
                            System.out.println("결제 수단을 입력하세요.> \"카드\" + \"현금\" + \"상품권\" \n : ");
                            pay = sc.next();

                            if (pay.equals("카드") || pay.equals("현금") || pay.equals("상품권")) {
                                System.out.println(
                                        "주메뉴 : " + menu + " / 사이드 메뉴 : " + sideMenu + " / 결제수단 : " + pay);
                            } else {
                                System.out.println("잘못된 결제수단입니다.");
                            }
                            break;

                        case 3:
                            sideMenu = "사이다";
                            System.out.println("결제 수단을 입력하세요. > \"카드\" + \"현금\" + \"상품권\" \n : ");
                            pay = sc.next();
                            if (pay.equals("카드") || pay.equals("현금") || pay.equals("상품권")) {
                                System.out.println(
                                        "주메뉴 : " + menu + " / 사이드 메뉴 : " + sideMenu + " / 결제수단 : " + pay);
                            } else {
                                System.out.println("잘못된 결제수단입니다.");
                            }
                            break;

                        default:
                            System.out.println("잘못된 사이드 메뉴 입력입니다.");
                            break;
                    }
                    break;

                case 4:
                    menu = "페포로니";
                    System.out.print("사이드 메뉴를 입력하세요.> 1.감자튀김 2.콜라 3. 사이다 \n : ");
                    int sideNum4 = sc.nextInt();

                    switch (sideNum4) {
                        case 1:
                            sideMenu = "감자튀김";
                            System.out.println("결제 수단을 입력하세요.> 카드 / 현금 / 상품권 : ");
                            pay = sc.next();
                            if (pay.equals("카드") || pay.equals("현금") || pay.equals("상품권")) {
                                System.out.println(
                                        "주메뉴 : " + menu + " / 사이드 메뉴 : " + sideMenu + " / 결제수단 : " + pay);
                            } else {
                                System.out.println("잘못된 결제수단입니다.");
                            }
                        case 2:
                            sideMenu = "콜라";
                            System.out.println("결제 수단을 입력하세요.> \"카드\" + \"현금\" + \"상품권\" \n : ");
                            pay = sc.next();

                            if (pay.equals("카드") || pay.equals("현금") || pay.equals("상품권")) {
                                System.out.println(
                                        "주메뉴 : " + menu + " / 사이드 메뉴 : " + sideMenu + " / 결제수단 : " + pay);
                            } else {
                                System.out.println("잘못된 결제수단입니다.");
                            }

                        case 3:
                            sideMenu = "사이다";
                            System.out.println("결제 수단을 입력하세요. > \"카드\" + \"현금\" + \"상품권\" \n : ");
                            pay = sc.next();
                            if (pay.equals("카드") || pay.equals("현금") || pay.equals("상품권")) {
                                System.out.println(
                                        "주메뉴 : " + menu + " / 사이드 메뉴 : " + sideMenu + " / 결제수단 : " + pay);
                            } else {
                                System.out.println("잘못된 결제수단입니다.");
                            }
                            break;
                        default:
                            System.out.println("잘못된 사이드 메뉴 입력입니다.");
                            break;
                    }
                    break;

                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    check = false;
                    break;

                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }
}
