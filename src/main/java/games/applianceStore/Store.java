package games.applianceStore;

public class Store {

    // 10개씩 전부 가지고 있어야 함.
    Computer[] com = new Computer[10];
    AirConditioner[] ac = new AirConditioner[10];
    Refrigerator[] ref = new Refrigerator[10];
    AirCleaner[] air = new AirCleaner[10];
    int index; //null 바꿈을 용이하게 하기 위한 변수 선언.


    Store() {
        for (int i = 0; i < 10; i++) { // 아예 마트가 생성될 때 객체 넣어주기
            if (i < 5) { //0~4
                com[i] = new Computer("삼성", "i7", 200);
                ac[i] = new AirConditioner("삼성", "벽걸이", 100);
                ref[i] = new Refrigerator("삼성", "양문", "600L", 200);
                air[i] = new AirCleaner("다이슨", 60);
            } else { // 5~9
                com[i] = new Computer("LG", "i5", 150);
                ac[i] = new AirConditioner("LG", "스탠드형", 250);
                ref[i] = new Refrigerator("LG", "4도어", "800L", 350);
                air[i] = new AirCleaner("LG", 80);
            }
        }
    }


    Computer sendComputer(int start, int end) { // 시작점과 끝점을 받아서
        // 삼성: start 0 , end 5(작다니까) // LG: start 5 , end 10
        for (int i = start; i < end; i++) { //이렇게 하면, 삼성send, LGsend 따로 만들 필요가 없음.
            if (com[i] != null) { // null이 아니면
                index = i; // null로 나중에 바꿔줘야하는데, 이걸 체크 안하면 어디 인덱스가 팔렸는지를 파악하기 어렵다.
                // 마트에서 바로 체크하기 위해서 편리하게
                return com[i]; //컴퓨터를 소비자에게 주면 됨.
            }
        }
        return null; //for문을 돌았는데 객체가 없을 때.(다 팔린 것)
    }

    AirConditioner sendAirConditioner(int start, int end) {
        for (int i = start; i < end; i++) {
            if (ac[i] != null) {
                index = i;
                return ac[i];
            }
        }
        return null;
    }

    Refrigerator sendRef(int start, int end) {
        for (int i = start; i < end; i++) {
            if (ref[i] != null) {
                index = i;
                return ref[i];
            }
        }
        return null;
    }

    AirCleaner sendAirCleaner(int start, int end) {
        for (int i = start; i < end; i++) {
            if (air[i] != null) {
                index = i;
                return air[i];
            }
        }
        return null;
    }


    // 소비자에게 전달된 객체를 null로 바꾸는 기능
    void changeComputerNull() {
        com[index] = null; // 위에서 인덱스를 받았으므로, 편리하게 사용 가능.
    }

    void changeAirconditionerNull() {
        ac[index] = null;
    }

    void changeRefNull() {
        ref[index] = null;
    }

    void changeAirCleanerNull() {
        air[index] = null;
    }
}

