package games.game31_web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
@RequestMapping("/game31")
public class Game31Controller {

    private final Random random = new Random();
    private int com;
    private int attempts;

    @RequestMapping
    public String startGame(Model model) {
        com = random.nextInt(31) + 1;
        attempts = 0;
        model.addAttribute("message", "1부터 31 사이의 숫자를 입력하세요.");
        return "game31";
    }

    @PostMapping("/play")
    public String playGame(@RequestParam("user") int user,
                           Model model) {
        attempts++;

        if (attempts >= 10) {
            model.addAttribute("message", "10번의 기회를 모두 사용하였습니다. 정답은 " + com + "입니다. 게임을 종료합니다.");
            return "game31";
        }

        if (user < 1 || user > 31) {
            model.addAttribute("message", "입력한 숫자가 범위를 벗어났습니다. 다시 입력하세요.");
        } else if (com > user) {
            model.addAttribute("message", "컴퓨터의 숫자가 더 큽니다.");
        } else if (com < user) {
            model.addAttribute("message", "컴퓨터의 숫자가 더 작습니다.");
        } else {
            model.addAttribute("message", "일치합니다! 축하합니다. 게임을 종료합니다.");
            return "game31";
        }
        return "game31";
    }
}