package firstExer.helper;

public class DefaultGameConnectHelper extends AbstGameConnectHelper{
    @Override
    protected String doSecurity(String str) {
        System.out.println("���ڵ�");
        return str;
    }

    @Override
    protected boolean authentication(String id, String password) {
        System.out.println("���̵�/��ȣ Ȯ�ΰ���");
        return true;
    }

    @Override
    protected int authorization(String userName) {
        System.out.println("���� Ȯ��");
        return 0;
    }

    @Override
    protected String connection(String info) {
        System.out.println(info+" ���� �����ϼ̽��ϴ�.");
        return info;
    }
}
