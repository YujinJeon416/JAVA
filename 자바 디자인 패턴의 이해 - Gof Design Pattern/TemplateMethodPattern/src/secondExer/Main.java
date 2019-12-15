package secondExer;

import secondExer.helper.AbstGameConnectHelper;
import secondExer.helper.DefaultGameConnectHelper;

public class Main {
    public static void main(String[] args) {
        AbstGameConnectHelper helper = new DefaultGameConnectHelper();

        helper.requestConnection("유저 민감정보 데이터");
    }
}
