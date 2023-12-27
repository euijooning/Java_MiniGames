package games.airplain_web;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class Seat {
    private final int[][] seat;
    private int count;

    public Seat() { // 생성자, 총 24석
        seat = new int[9][2];
        count = 18;
    }

    public boolean isEmpty(int row, int col) {
        return seat[row - 1][col - 1] == 0;
    }

    public void reserveSeat(int row, int col) {
        seat[row - 1][col - 1]++;
        count--;
    }

    public List<int[]> getEmptySeats() {
        List<int[]> emptySeats = new ArrayList<>();
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                if (seat[i][j] == 0) {
                    emptySeats.add(new int[]{i + 1, j + 1});
                }
            }
        }
        return emptySeats;
    }
}