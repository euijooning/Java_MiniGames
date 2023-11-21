package games.airplain;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Seat seat = new Seat();
        ReservationSystem.run(sc, seat);
    }
}
