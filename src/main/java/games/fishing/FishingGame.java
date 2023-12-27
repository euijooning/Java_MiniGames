package games.fishing;

import java.util.Random;
import java.util.Scanner;

public class FishingGame {

    static int randomFish(int[][] lake) {
        Random r = new Random();
        int fishCount = 0;
        while (fishCount < 3) {
            int h = r.nextInt(5); //행 랜덤
            int y = r.nextInt(5); //열 랜덤
            if (lake[h][y] == 0) {
                lake[h][y] = 1;
                fishCount++;
            }
        }
        return fishCount;
    }

    static void lakePrint(int[][] lake, int[] input, boolean check) {
        for (int i = 0; i < lake.length; i++) {
            for (int j = 0; j < lake[i].length; j++) {
                //행과 열이 사용자 위치와 일치하고 캐스팅 x일 때
                if (input[0] == i && input[1] == j && check) {
                    System.out.print("X");
                    // 호수의 행 열에 물고기가 없다면
                } else if (lake[i][j] == 0) {
                    System.out.print("○");
                } else { // 그렇지 않으면(물고기 존재)
                    System.out.print("■");
                }
            }
            System.out.println();
        }
    }

    static void input(int[] input, Scanner sc) {
        while (true) {
            System.out.print("행 입력 : ");
            input[0] = sc.nextInt();
            System.out.print("열 입력 : ");
            input[1] = sc.nextInt();

            // 입력값이 범위를 벗어났을 때(1~4 아닌 경우)
            if (input[0] > -1 && input[0] < 5 && input[1] > -1 && input[1] < 5) {
                break;
            }

            System.out.println("잘못된 입력입니다.");
        }
    }

    static int fishCheck(int[][] lake, int[] input, int fishCount) {
        if (lake[input[0]][input[1]] == 1) { // 행 열 입력한게 물고기 위치와 일치
            System.out.println("물고기를 잡았습니다.");
            lake[input[0]][input[1]] = 0; // 그 위치에 들어있는 것을 없애주고
            fishCount--; // 물고기 숫자를 하나 감소시킴
        }
        return fishCount; // 결과값을 반환
    }

    static int directionInput(Scanner sc) {
        System.out.print("[[이동할 방향 입력]] \n 1. 위 \n 2. 아래 \n 3. 왼쪽  \n 4. 오른쪽 : ");
        return sc.nextInt();
    }

    static void fishermanMove(int num, int[] input) {
        if (num == 1) {
            input[0]--;
            moveUp(input);
        } else if (num == 2) {
            input[0]++;
            moveBottom(input);
        } else if (num == 3) {
            input[1]--;
            moveLeft(input);
        } else if (num == 4) {
            input[1]++;
            moveRight(input);
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }

    private static void moveUp(int[] input) {
        if (input[0] < 0) {
            System.out.println("더이상 위로 움직일 수 없습니다.");
            input[0] = 0;
        }
    }

    private static void moveBottom(int[] input) {
        if (input[0] > 4) {
            System.out.println("더이상 아래로 움직일 수 없습니다.");
            input[0] = 4;
        }
    }

    private static void moveLeft(int[] input) {
        if (input[1] < 0) {
            System.out.println("더이상 왼쪽으로 움직일 수 없습니다.");
            input[1] = 0;
        }
    }

    private static void moveRight(int[] input) {
        if (input[1] > 4) {
            System.out.println("더이상 오른쪽으로 움직일 수 없습니다.");
            input[1] = 4;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //1. 5X5 호수 만들기
        int[][] lake = new int[5][5];
        //2. Random을 통해서 물고기 배치
        int fishCount = 0;
        int[] input = new int[2];
        fishCount = randomFish(lake);
        lakePrint(lake, input, false);
        //캐스팅
        input(input, sc);
        System.out.println(input[0] + "," + input[1]);
        //물고기 확인
        fishCount = fishCheck(lake, input, fishCount);
        while (fishCount > 0) {
            int num = directionInput(sc);
            fishermanMove(num, input);
            //물고기체크
            fishCount = fishCheck(lake, input, fishCount);
            //출력
            lakePrint(lake, input, true);
        }
        System.out.println("낚시게임을 종료합니다.");
    }
}
