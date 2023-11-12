package games.applianceStore;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Store store = new Store();
        Human[] hum = new Human[3];

        // 소비자 돈 입력
        for (int i = 0; i < hum.length; i++) {
            humanHoldingAmount(hum, i, sc);
        }

        // 상품 구입 시작(공통조건 돈이 70원 이상)
        while (hum[0].money >= 70 || hum[1].money >= 70 || hum[2].money >= 70) {
            System.out.println("==================================================");
            for (int i = 0; i < hum.length; i++) {
                System.out.println((i + 1) + "번째 소비자 남은 금액 : " + hum[i].money);
                System.out.println();

                if (hum[i].money >= 70) { // 구입할 수 있는 조건을 먼저 적어줌. 해당 안 되면 넘어감.
                    System.out.print((i + 1) + "번째 소비자 상품을 선택해주세요 :  \n 1. 컴퓨터, 2. 에어컨, 3. 냉장고, 4. 공기청정기 > ");
                    int item = sc.nextInt();

                    if (item == 1) { // 컴퓨터 구매 시
                        System.out.print("<컴퓨터 브랜드> 1. 삼성 2. LG : ");
                        int brand = sc.nextInt();

                        System.out.println("==================================================");

                        if (brand == 1) { // <브랜드> 삼성 컴퓨터 선택
                            if (hum[i].money >= 100) { // 금액이 충분한 경우
                                Computer computer = store.sendComputer(0, 5);
                                if (computer == null) { // 객체가 없는 경우
                                    System.out.println("삼성 컴퓨터가 모두 팔린 상태입니다.");
                                } else { // 물건(객체)도 있고 돈도 충분한 경우
                                    comCalculate(computer, store, hum[i]);
                                }
                            } else { // 돈이 부족한 경우
                                System.out.println("삼성 컴퓨터를 구매하기에는 돈이 부족합니다.");
                                System.out.println();
                            }

                        } else if (brand == 2) {// <브랜드> LG 컴퓨터 선택
                            if (hum[i].money >= 150) { // 금액이 충분한 경우
                                Computer computer = store.sendComputer(5, 10);
                                if (computer == null) { // 객체가 없는 경우
                                    System.out.println("LG 컴퓨터가 모두 팔린 상태입니다.");
                                } else { // 물건(객체)도 있고 돈도 충분한 경우
                                    comCalculate(computer, store, hum[i]);
                                }
                            } else { // 돈이 부족한 경우
                                System.out.println("LG 컴퓨터를 구매하기에는 돈이 부족합니다.");
                                System.out.println();
                            }
                        } else {
                            System.out.println("컴퓨터 브랜드를 잘못 선택했습니다.");
                        }


                    } else if (item == 2) { // 에어컨 구매 시
                        System.out.print("<에어컨 브랜드> 1. 삼성 2. LG : ");
                        int brand = sc.nextInt();

                        System.out.println("==================================================");

                        if (brand == 1) { // <브랜드> 삼성 에어컨 선택
                            if (hum[i].money >= 200) { // 금액이 충분한 경우
                                AirConditioner conditioner = store.sendAirConditioner(0, 5);
                                if (conditioner == null) { // 객체가 없는 경우
                                    System.out.println("삼성 에어컨이 모두 팔린 상태입니다.");
                                } else { // 물건(객체)도 있고 돈도 충분한 경우
                                    airConditionerCalculate(conditioner, store, hum[i]);
                                }
                            } else { // 돈이 부족한 경우
                                System.out.println("삼성 에어컨을 구매하기에는 돈이 부족합니다.");
                                System.out.println();
                            }

                        } else if (brand == 2) {// <브랜드> LG 에어컨 선택
                            if (hum[i].money >= 250) { // 금액이 충분한 경우
                                AirConditioner conditioner = store.sendAirConditioner(5, 10);
                                if (conditioner == null) { // 객체가 없는 경우
                                    System.out.println("LG 에어컨이 모두 팔린 상태입니다.");
                                } else { // 물건(객체)도 있고 돈도 충분한 경우
                                    airConditionerCalculate(conditioner, store, hum[i]);
                                }
                            } else { // 돈이 부족한 경우
                                System.out.println("LG 에어컨을 구매하기에는 돈이 부족합니다.");
                                System.out.println();
                            }
                        } else {
                            System.out.println("에어컨 브랜드를 잘못 선택했습니다.");
                        }
                    } 
                    else if (item == 3) {
                        // 냉장고 구매 시
                        System.out.print("<냉장고 브랜드> 1. 삼성 2. LG : ");
                        int brand = sc.nextInt();

                        System.out.println("==================================================");

                        if (brand == 1) { // <브랜드> 삼성 냉장고 선택
                            if (hum[i].money >= 200) { // 금액이 충분한 경우
                                Refrigerator refrigerator = store.sendRef(0, 5);
                                if (refrigerator == null) { // 객체가 없는 경우
                                    System.out.println("삼성 냉장고가 모두 팔린 상태입니다.");
                                } else { // 물건(객체)도 있고 돈도 충분한 경우
                                    refCalculate(refrigerator, store, hum[i]);
                                }
                            } else { // 돈이 부족한 경우
                                System.out.println("삼성 냉장고를 구매하기에는 돈이 부족합니다.");
                                System.out.println();
                            }

                        } else if (brand == 2) {// <브랜드> LG 냉장고 선택
                            if (hum[i].money >= 350) { // 금액이 충분한 경우
                                Refrigerator refrigerator = store.sendRef(5, 10);
                                if (refrigerator == null) { // 객체가 없는 경우
                                    System.out.println("LG 냉장고가 모두 팔린 상태입니다.");
                                } else { // 물건(객체)도 있고 돈도 충분한 경우
                                    refCalculate(refrigerator, store, hum[i]);
                                }
                            } else { // 돈이 부족한 경우
                                System.out.println("LG 냉장고를 구매하기에는 돈이 부족합니다.");
                                System.out.println();
                            }
                        } else {
                            System.out.println("냉장고 브랜드를 잘못 선택했습니다.");
                        }
                    } else if (item == 4) { // 공기청정기 선택
                        // 공기청정기 구매 시
                        System.out.print("<공기청정기 브랜드> 1. 다이슨 2. LG : ");
                        int brand = sc.nextInt();

                        System.out.println("==================================================");

                        if (brand == 1) { // <브랜드> 다이슨 선택
                            if (hum[i].money >= 200) { // 금액이 충분한 경우
                                AirCleaner cleaner = store.sendAirCleaner(0, 5);
                                if (cleaner == null) { // 객체가 없는 경우
                                    System.out.println("다이슨 공기청정기 모두 팔린 상태입니다.");
                                } else { // 물건(객체)도 있고 돈도 충분한 경우
                                    airCleanerCalculate(cleaner, store, hum[i]);
                                }
                            } else { // 돈이 부족한 경우
                                System.out.println("다이슨 공기청정기 구매하기에는 돈이 부족합니다.");
                                System.out.println();
                            }

                        } else if (brand == 2) {// <브랜드> LG 공기청정기 선택
                            if (hum[i].money >= 100) { // 금액이 충분한 경우
                                AirCleaner cleaner = store.sendAirCleaner(5, 10);
                                if (cleaner == null) { // 객체가 없는 경우
                                    System.out.println("LG 공기청정기 모두 팔린 상태입니다.");
                                } else { // 물건(객체)도 있고 돈도 충분한 경우
                                    airCleanerCalculate(cleaner, store, hum[i]);
                                }
                            } else { // 돈이 부족한 경우
                                System.out.println("LG 공기청정기를 구매하기에는 돈이 부족합니다.");
                                System.out.println();
                            }
                        } else {
                            System.out.println("공기청정기 브랜드를 잘못 선택했습니다.");
                        }
                    } else {
                        System.out.println("잘못된 입력입니다.");
                    }
                }
            }
        }

        // 마지막 출력
        System.out.println();
        for (int i = 0; i < hum.length; i++) {
            System.out.println("<" + (i + 1) + "번째 소비자의 구매 상품>");
            hum[i].allPrint();
        }

    }

    // 공통 로직들 메서드로 분리
    private static void humanHoldingAmount(Human[] hum, int i, Scanner sc) {
        hum[i] = new Human(); // Human 객체 생성
        System.out.print((i + 1) + "번째 소비자가 최초로 보유할 금액 입력 : "); // 인덱스 맞춰주기
        hum[i].money = sc.nextInt(); // Human의 money에 돈 입력
    }

    private static void airCleanerCalculate(AirCleaner cleaner, Store store, Human hum) {
        hum.money -= cleaner.price; // 소비자가 보유한 금액 - 다이슨 청정기 가격
        hum.receiveProduct(cleaner); // 청정기를 소비자가 보유하게 하기
        store.changeAirCleanerNull(); // null로 바꿔줌.
    }

    private static void refCalculate(Refrigerator refrigerator, Store store, Human hum) {
        hum.money -= refrigerator.price; // 소비자가 보유한 금액 - 삼성 냉장고 가격
        hum.receiveProduct(refrigerator); // 냉장고를 소비자가 보유하게 하기
        store.changeRefNull(); // null로 바꿔줌.
    }

    private static void airConditionerCalculate(AirConditioner conditioner, Store store, Human hum) {
        hum.money -= conditioner.price; // 소비자가 보유한 금액 - 삼성 에어컨 가격
        hum.receiveProduct(conditioner); // 에어컨을 소비자가 보유하게 하기
        store.changeAirconditionerNull(); // null로 바꿔줌.
    }


    private static void comCalculate(Computer computer, Store store, Human hum) {
        hum.money -= computer.price; // 소비자가 보유한 금액 - 삼성 컴퓨터 가격
        hum.receiveProduct(computer); // 컴퓨터를 소비자가 보유하게 하기
        store.changeComputerNull(); // null로 바꿔줌.
    }
}
