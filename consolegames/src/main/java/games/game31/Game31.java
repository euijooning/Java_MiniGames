package games.game31;

import java.util.Random;
import java.util.Scanner;

public class Game31 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int com = r.nextInt(31) + 1;

        while (true) {
            System.out.print("유저, 숫자를 입력하세요 : ");
            int user = sc.nextInt();

            if (user < 1 || user > 31) {
                System.out.println("입력한 숫자가 범위를 벗어났습니다. 다시 입력하세요.");
                // 다시 입력받기 위해 continue 문을 사용하여 반복문의 처음으로 돌아감
                continue;
            }

            if (com > user) {
                System.out.println("컴퓨터의 숫자가 더 큽니다.");
            } else if (com < user) {
                System.out.println("컴퓨터의 숫자가 더 작습니다.");
            } else {
                System.out.println("일치합니다! 축하합니다. 게임을 종료합니다.");
                break;
            }
        }
    }
}
