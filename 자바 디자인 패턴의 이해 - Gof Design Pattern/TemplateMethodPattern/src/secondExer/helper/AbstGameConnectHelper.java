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
            throw new Error("유저 아이디/패스워드 불일치");
        }

        String userName = "참치먹은김치";
        int i = authorization(userName);
        switch (i) {
            case -1:
                throw new Error("셧다운 실시");
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
