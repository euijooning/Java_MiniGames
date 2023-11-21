package games.applianceStore;

public class AirCleaner implements Product {

    String menu;
    int price;

    AirCleaner(String menu, int price) {
        this.menu = menu;
        this.price = price;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void use() {
        System.out.println("제조사가 " + menu + "인 " + "공기청정기입니다.");
    }

}
