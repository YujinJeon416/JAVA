package com.minkj1992.helper;

public abstract class AbstGameConnectHelper {

    // ���ø� �޼ҵ忡 ���Ե� �ܰ��
    protected abstract String doSecurity(String str);

    protected abstract boolean authentication(String id, String password);

    protected abstract int authorization(String userName);

    protected abstract String connection(String info);

    // ���ø� �޼ҵ�
    // abstract�� method ���� ���־ �Ǵ°�?
    public String requestConnection(String encodedInfo) {

        // ����: ��ȣȭ�� ���ڿ� ��ȣȭ(���ڵ�)
        String decodedInfo = doSecurity(encodedInfo);

        // ����
        String id = "minkj1992";
        String password = "1234";

        if (!authentication(id, password)) {
            throw new Error("���̵� �Ǵ� ��ȣ ����ġ");
        }
        // userName = getUserName(decodedInfo);
        String userName = "��ġ������ġ";

        // ����
        int i = authorization(userName);
        switch (i) {
            case 0:// ���� �Ŵ���
                break;
            case 1: // ���� ȸ��
                break;
            case 2: // ���� ȸ��
                break;
            case 3:// ���� ����
                break;
            default: // ��Ÿ ����
                break;
        }

        return connection(userName);
    }
}
