package games.applianceStore;

public class AirConditioner implements Product{

    String menu;
    String type;
    int price;

    AirConditioner(String menu, String type, int price) {
        this.menu = menu;
        this.type = type;
        this.price = price;
    }

    public void use() {
        System.out.println("제조사가 " + menu + "인 " + type + " 에어컨을 사용합니다.");
    }
}
