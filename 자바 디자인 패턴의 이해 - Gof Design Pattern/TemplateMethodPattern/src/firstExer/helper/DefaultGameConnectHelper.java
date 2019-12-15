package firstExer.helper;

public class DefaultGameConnectHelper extends AbstGameConnectHelper{
    @Override
    protected String doSecurity(String str) {
        System.out.println("디코드");
        return str;
    }

    @Override
    protected boolean authentication(String id, String password) {
        System.out.println("아이디/암호 확인과정");
        return true;
    }

    @Override
    protected int authorization(String userName) {
        System.out.println("권한 확인");
        return 0;
    }

    @Override
    protected String connection(String info) {
        System.out.println(info+" 님이 접속하셨습니다.");
        return info;
    }
}
