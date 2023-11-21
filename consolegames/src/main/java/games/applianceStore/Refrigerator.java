package games.applianceStore;

public class Refrigerator implements Product {

    String menu;
    String type;
    String size;
    int price;

    Refrigerator(String menu, String type, String size, int price) {
        this.menu = menu;
        this.type = type;
        this.size = size;
        this.price = price;
    }

    public void use() {
        System.out.println("제조사가 " + menu + "인 " + type + "형 " + size + " 냉장고가 식품을 관리합니다.");
    }

}