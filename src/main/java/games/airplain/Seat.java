package games.airplain;

// 비행기 좌석과 관련된 클래스
public class Seat {
    private int[][] seat;
    private int count;

    public Seat() { // 생성자, 총 24석
        seat = new int[6][3];
        count = 18;
    }

    public boolean isEmpty(int row, int col) {
        return seat[row - 1][col - 1] == 0;
    }

    public void reserveSeat(int row, int col) {
        seat[row - 1][col - 1]++;
        count--;
    }

    public int getCount() {
        return count;
    }

    public void printEmptySeats() {
        System.out.println("선점된 좌석입니다. / 빈 좌석은 다음과 같습니다. ");
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                if (seat[i][j] == 0) {
                    System.out.println("행: " + (i + 1) + " 열: " + (j + 1));
                }
            }
        }
    }
}
