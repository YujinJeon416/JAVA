package secondExer.helper;

public class DefaultGameConnectHelper extends AbstGameConnectHelper {
    @Override
    protected String doSecurity(String userInfo) {
        System.out.println("강화된 보안처리");
        return userInfo;
    }

    @Override
    protected boolean authentication(String id, String password) {
        System.out.println("아이디/암호 확인");
        return true;
    }

    @Override
    protected int authorization(String userName) {
        // 10시 이후 청소년일시 return -1;
        System.out.println("권한 확인");
        return 0;
    }

    @Override
    protected String connection(String info) {
        System.out.println(info+"님이 접속하셨습니다.");
        return info;
    }
}
