package games.applianceStore;

public class Human {

    Product[] pro = new Product[10];
    int money;


    // 마트에서 산 객체를 담아주는 기능
    void receiveProduct(Product product) { // 컴퓨터를 받아와서
        for (int i = 0; i < pro.length; i++) {
            if (pro[i] == null) { // 그 공간이 null이면
                pro[i] = product; // 구매한 컴퓨터를 채워준다(장바구니에)
                break;
            }
        }
    }

    // 내가 산 물품 출력
    void allPrint() {
        for (int i = 0; i < 10; i++) {
            if (pro[i] != null) {
                pro[i].use();
            }
        }
    }

}
