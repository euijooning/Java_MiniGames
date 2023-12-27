package games.fastfood_web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/fast-food")
public class FastFoodController {
    @GetMapping("/menu")
    public String showMenu(Model model) {
        return "fast-food/menu";
    }

    @PostMapping("/order")
    public String placeOrder(@RequestParam("menuNum") int menuNum,
                             @RequestParam("sideNum") int sideNum,
                             @RequestParam("paymentMethod") String paymentMethod,
                             Model model) {

        String menu = getMenuName(menuNum);
        String sideMenu = getSideMenuName(sideNum);

        String orderSummary = "주메뉴: " + menu + ", 사이드 메뉴: " + sideMenu + ", 결제 수단: " + paymentMethod;
        model.addAttribute("orderSummary", orderSummary);

        return "fast-food/order";
    }

    private String getMenuName(int menuNum) {
        if (menuNum == 1) {
            return "갈릭버거";
        }
        else if (menuNum == 2) {
            return "싸이버거";
        }
        else if (menuNum == 3) {
            return "갈릭치킨";
        }
        else {
            return "잘못된 입력입니다.";
        }

    }

    private String getSideMenuName(int sideNum) {
        if (sideNum == 1) {
            return "감자튀김";
        }
        else if (sideNum == 2) {
            return "콜라";
        }
        else if (sideNum == 3) {
            return "사이다";
        }
        else {
            return "잘못된 입력입니다.";
        }
    }
}
