package firstExer;

import firstExer.helper.AbstGameConnectHelper;
import firstExer.helper.DefaultGameConnectHelper;

public class Main {
    public static void main(String[] args) {
        AbstGameConnectHelper helper = new DefaultGameConnectHelper();

        helper.requestConnection("���̵� ��ȣ �� ���� ����");
    }
}
