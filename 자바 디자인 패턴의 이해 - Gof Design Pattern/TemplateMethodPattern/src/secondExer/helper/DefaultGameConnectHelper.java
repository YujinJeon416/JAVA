package secondExer.helper;

public class DefaultGameConnectHelper extends AbstGameConnectHelper {
    @Override
    protected String doSecurity(String userInfo) {
        System.out.println("��ȭ�� ����ó��");
        return userInfo;
    }

    @Override
    protected boolean authentication(String id, String password) {
        System.out.println("���̵�/��ȣ Ȯ��");
        return true;
    }

    @Override
    protected int authorization(String userName) {
        // 10�� ���� û�ҳ��Ͻ� return -1;
        System.out.println("���� Ȯ��");
        return 0;
    }

    @Override
    protected String connection(String info) {
        System.out.println(info+"���� �����ϼ̽��ϴ�.");
        return info;
    }
}
