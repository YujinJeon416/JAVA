package secondExer.helper;

public abstract class AbstGameConnectHelper {

    protected abstract String doSecurity(String userInfo);

    protected abstract boolean authentication(String id, String password);

    protected abstract int authorization(String userName);

    protected abstract String connection(String info);

    public String requestConnection(String encodedInfo) {
        String decodedInfo = doSecurity(encodedInfo);

        String id = "minkj1992";
        String password = "1234";
        if (!authentication(id, password)) {
            throw new Error("���� ���̵�/�н����� ����ġ");
        }

        String userName = "��ġ������ġ";
        int i = authorization(userName);
        switch (i) {
            case -1:
                throw new Error("�˴ٿ� �ǽ�");
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
        return connection(userName);
    }
}
