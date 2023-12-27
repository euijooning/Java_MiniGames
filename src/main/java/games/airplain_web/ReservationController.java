package games.airplain_web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/airplane")
public class ReservationController {

    private final Seat seat;

    @Autowired
    public ReservationController(Seat seat) {
        this.seat = seat;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("count", seat.getCount());
        model.addAttribute("emptySeats", seat.getEmptySeats());
        return "airplane";
    }

    @PostMapping("/reserve")
    public String reserve(@RequestParam int row, @RequestParam int col, Model model) {
        if (!validRC(row, col) || !seat.isEmpty(row, col)) {
            model.addAttribute("error", "예약이 불가능한 좌석입니다.");
            return "airplane";
        }

        seat.reserveSeat(row, col);
        model.addAttribute("message", "예약이 완료되었습니다. 예약된 좌석은 [" + row + "][" + col + "] 입니다.");
        model.addAttribute("count", seat.getCount());
        model.addAttribute("emptySeats", seat.getEmptySeats());
        return "redirect:/airplane";
    }

    private boolean validRC(int row, int col) {
        return row >= 1 && row <= 9 && col >= 1 && col <= 2;
    }
}
