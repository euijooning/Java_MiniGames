package games.applianceStore;

public class Computer implements Product {

    String menu;
    String cpu;
    int price;

    Computer(String menu, String cpu, int price) {
        this.menu = menu;
        this.cpu = cpu;
        this.price = price;
    }

    public void use() {
        System.out.println("제조사가 " + menu + "인 " + cpu + " 스펙의 컴퓨터를 사용합니다.");
        // 가격은 여기 가지고 있는 게 아니라 사람이 사면 차감시키려고 하는 것이기 때문에 여기 굳이 넣어줄 필요가 없다.
    }
}
