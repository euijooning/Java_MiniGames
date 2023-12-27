package games.guessNumber;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
@RequestMapping("/guess")
public class GuessNumberGameController {

    private int secretNumber; // 정답 숫자
    private int attempts = 0; // 시도 횟수
    private static final int MAX_ATTEMPTS = 10; // 기회

    @GetMapping("/number")
    public String showGamePage(Model model) {
        secretNumber = generateRandomNumber();
        attempts = 0; // 0번으로 초기화
        model.addAttribute("message", "숫자를 추측해 보세요!");
        return "guessNumber";
    }

    @PostMapping("/number")
    public String playGame(@RequestParam int guess, Model model) {
        String message;

        if (attempts >= MAX_ATTEMPTS) {
            message = "기회가 모두 소진되었습니다. 정답은 " + secretNumber + "입니다.";
            attempts = 0;
            secretNumber = generateRandomNumber();
        } else {
            attempts++;
            if (guess == secretNumber) {
                message = "정답입니다! 축하합니다!";
                attempts = 0;
                secretNumber = generateRandomNumber(); // 새로운 게임을 위해 숫자 초기화
            } else if (guess < secretNumber) {
                message = "더 큰 숫자를 입력하세요. (남은 기회: " + (MAX_ATTEMPTS - attempts) + ")";
            } else {
                message = "더 작은 숫자를 입력하세요. (남은 기회: " + (MAX_ATTEMPTS - attempts) + ")";
            }
        }
        model.addAttribute("message", message);
        return "guessNumber";
    }

    private int generateRandomNumber() {
        int target = new Random().nextInt(50) + 1;
        System.out.println("정답 : " + target);
        return target;
    }
}

