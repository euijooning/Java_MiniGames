package games.guessNumber;

import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    private static int secretNumber;
    private static int attempts = 0;
    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. 새로운 게임 시작");
            System.out.println("2. 종료");
            System.out.print("선택: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                playGame(scanner);
            } else if (choice == 2) {
                break;
            } else {
                System.out.println("올바른 선택이 아닙니다. 다시 선택하세요.");
            }
        }

        System.out.println("프로그램을 종료합니다.");
        scanner.close();
    }

    private static void playGame(Scanner scanner) {
        showGamePage();

        while (true) {
            System.out.print("추측할 숫자를 입력하세요: ");
            int guess = scanner.nextInt();

            playGame(guess);

            // 사용자 입력이 "y" 또는 "n"이 아닌 경우 계속해서 입력 받기
            while (true) {
                System.out.println("게임을 계속하시겠습니까? (y/n): ");
                String continueChoice = scanner.next();

                if (continueChoice.equalsIgnoreCase("y") || continueChoice.equalsIgnoreCase("n")) {
                    if (continueChoice.equalsIgnoreCase("n")) {
                        return; // 종료
                    } else {
                        break; // 게임 계속 진행
                    }
                } else {
                    System.out.println("올바른 선택이 아닙니다. 다시 선택하세요.");
                }
            }
        }
    }



    private static void showGamePage() {
        secretNumber = generateRandomNumber();
        attempts = 0;
        System.out.println("숫자를 추측해 보세요!");
    }

    private static void playGame(int guess) {
        String message;

        if (attempts + 1 >= MAX_ATTEMPTS) {
            message = "기회가 모두 소진되었습니다. 정답은 " + secretNumber + "입니다.";
            attempts = 0;
            secretNumber = generateRandomNumber();
        } else {
            attempts++;
            if (guess == secretNumber) {
                message = "정답입니다! 축하합니다!";
                attempts = 0;
                secretNumber = generateRandomNumber();
            } else if (guess < secretNumber) {
                message = "더 큰 숫자를 입력하세요. (남은 기회: " + (MAX_ATTEMPTS - attempts) + ")";
            } else {
                message = "더 작은 숫자를 입력하세요. (남은 기회: " + (MAX_ATTEMPTS - attempts) + ")";
            }
        }
        System.out.println(message);
    }

    private static int generateRandomNumber() {
        int target = new Random().nextInt(50) + 1;
        return target;
    }
}
