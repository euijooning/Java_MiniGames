package games.fishing_web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;
import java.util.Scanner;

@Controller
public class FishingGameController {

    private int[][] lake = new int[5][5];
    private int fishCount = 0;
    private int[] input = new int[2];
    private Scanner sc = new Scanner(System.in);

    @GetMapping("/fish-game")
    public String showFishGame(Model model) {
        if (fishCount == 0) {
            fishCount = randomFish(lake);
        }
        lakePrint(lake, input, false);
        model.addAttribute("fishCount", fishCount);
        model.addAttribute("input", input);
        model.addAttribute("lake", lake); // 이 부분을 추가
        return "fishing-game/fishingGame";
    }

    @PostMapping("/fish-game")
    public String handleMove(int direction, Model model) {
        fishermanMove(direction, input);
        fishCount = fishCheck(lake, input, fishCount);
        lakePrint(lake, input, true);
        if (fishCount == 0) {
            return "fishing-game/fishingGameResult";
        }
        model.addAttribute("fishCount", fishCount);
        model.addAttribute("input", input);
        model.addAttribute("lake", lake);  // 추가된 부분
        return "fishing-game/fishingGame";
    }

    private int randomFish(int[][] lake) {
        Random r = new Random();
        int fishCount = 0;
        while (fishCount < 3) {
            int h = r.nextInt(5);
            int y = r.nextInt(5);
            if (lake[h][y] == 0) {
                lake[h][y] = 1;
                fishCount++;
            }
        }
        return fishCount;
    }

    private void lakePrint(int[][] lake, int[] input, boolean check) {
        for (int i = 0; i < lake.length; i++) {
            for (int j = 0; j < lake[i].length; j++) {
                if (input[0] == i && input[1] == j && check) {
                    System.out.print("X");
                } else if (lake[i][j] == 0) {
                    System.out.print("○");
                } else {
                    System.out.print("■");
                }
            }
            System.out.println();
        }
    }

    private void input(int[] input, Scanner sc) {
        while (true) {
            System.out.print("행 입력 : ");
            input[0] = sc.nextInt();
            System.out.print("열 입력 : ");
            input[1] = sc.nextInt();
            if (input[0] > -1 && input[0] < 5 && input[1] > -1 && input[1] < 5) {
                break;
            }
            System.out.println("잘못된 입력입니다.");
        }
    }

    private int fishCheck(int[][] lake, int[] input, int fishCount) {
        if (lake[input[0]][input[1]] == 1) {
            System.out.println("물고기를 잡았습니다.");
            lake[input[0]][input[1]] = 0;
            fishCount--;
        }
        return fishCount;
    }

    private int directionInput(Scanner sc) {
        System.out.print("[[이동할 방향 입력]] \n 1. 위 \n 2. 아래 \n 3. 왼쪽  \n 4. 오른쪽 : ");
        return sc.nextInt();
    }

    private void fishermanMove(int num, int[] input) {
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

    private void moveUp(int[] input) {
        if (input[0] < 0) {
            System.out.println("더이상 위로 움직일 수 없습니다.");
            input[0] = 0;
        }
    }

    private void moveBottom(int[] input) {
        if (input[0] > 4) {
            System.out.println("더이상 아래로 움직일 수 없습니다.");
            input[0] = 4;
        }
    }

    private void moveLeft(int[] input) {
        if (input[1] < 0) {
            System.out.println("더이상 왼쪽으로 움직일 수 없습니다.");
            input[1] = 0;
        }
    }

    private void moveRight(int[] input) {
        if (input[1] > 4) {
            System.out.println("더이상 오른쪽으로 움직일 수 없습니다.");
            input[1] = 4;
        }
    }
}
