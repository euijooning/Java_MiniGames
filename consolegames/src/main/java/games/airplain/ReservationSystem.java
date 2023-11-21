package games.airplain;

import java.util.Scanner;

public class ReservationSystem {
    public static void run(Scanner sc, Seat seat) {
        while (seat.getCount() > 0) {
            int[] select = inputRC(sc, seat.getCount());
            int row = select[0];
            int col = select[1];

            if (!validRC(row, col)) {
                continue;
            }

            if (seat.isEmpty(row, col)) {
                System.out.println("예약이 완료되었습니다.");
                seat.reserveSeat(row, col);
                System.out.println("예약된 좌석은 " + "["+ row + "]" +"[" + col + "]" + " 입니다.");
            } else {
                seat.printEmptySeats();
            }
        }

        System.out.println("모든 자리가 예약되었습니다.");
    }

    static int[] inputRC(Scanner sc, int count) {
        System.out.println("예약하실 좌석을 입력해주세요 (총 " + count + "석)");
        System.out.print("행: ");
        int row = sc.nextInt();
        System.out.print("열: ");
        int col = sc.nextInt();

        int[] select = {row, col};
        return select;
    }

    static boolean validRC(int row, int col) {
        if (row < 1 || row > 9 || col > 2 || col < 1) {
            System.out.println("범위를 초과했습니다. 잘못된 입력입니다.");
            return false;
        }

        return true;
    }
}
