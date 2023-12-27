package games.phone_web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/phone-converter")
public class PhoneKeypadConverterController {

    @GetMapping
    public String showForm() {
        return "phone-converter";
    }

    @PostMapping
    public String convertPhoneNumber(@RequestParam("phoneNumber") String phoneNumber,
                                     Model model) {
        String result = makeResult(phoneNumber);
        model.addAttribute("result", result);
        return "phone-converter";
    }

    private static String makeResult(String str) {
        String result = ""; // 빈 문자열
        char ch = str.charAt(0); // 현재 문자
        int count = 0; // 연속으로 나타난 문자의 수

        // 문자열 탐색
        for (int i = 0; i<str.length(); i++) {
            if (ch == str.charAt(i)) { // 현재 문자와 i번째 문자가 같은 경우
                count++; // 연속된 문자의 수 증가
            }
            else {
                // 문자, count를 보내 결과 문자를 받는다.
                result += makeChar(ch, count);

                // ch를 그 다음 결과로 변경
                ch = str.charAt(i);

                // 카운터 초기화 => 연속된 문자의 수 초기화
                count = 1;
            }
        }
        // 마지막 문자와 연속된 문자의 수를 이용해 문자열을 생성
        // 마지막 인덱스가 없으므로 이 작업 한번 더 굳이 해줘야 함.
        result += makeChar(ch, count);
        return result;
    }

    private static char makeChar(char ch, int count) {
        char result;
        char[][] keypad = {
                {'A', 'B', 'C'}, // 1
                {'D', 'E', 'F'}, // 2
                {'G', 'H', 'I'}, // 3
                {'J', 'K', 'L'}, // 4
                {'M', 'N', 'O'}, // 5
                {'P', 'Q', 'R'}, // 6
                {'S', 'T', 'U'}, // 7
                {'V', 'W', 'X'},  // 8
                {'Y'},
                {'*'},
                {'Z'},
                {'#'}
        };

        // 숫자 9, *, 0, # 인 경우 처리
        if (ch == 9) {
            result = keypad[8][0];
        }
        else if (ch == '*') {
            result = keypad[9][0];
        }
        else if (ch == '0') {
            result = keypad[10][0];
        }
        else if (ch == '#') {
            result = keypad[11][0];
        }

        // 숫자 1 ~ 8 경우 처리 (몇 번 클릭했느냐에 따라 문자가 달라짐)
        else {
            // 연속된 문자의 수에 따라 인덱스 값 조정
            if (count <= 3) {
                count--;
            }
            else {
                count = (count-1) % 3;
            }
            result = keypad[(ch - '0') -1][count];
        }
        return result;
    }

}