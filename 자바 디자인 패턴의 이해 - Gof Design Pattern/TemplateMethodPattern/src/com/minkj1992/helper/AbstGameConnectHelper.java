package com.minkj1992.helper;

public abstract class AbstGameConnectHelper {

    // 템플릿 메소드에 포함될 단계들
    protected abstract String doSecurity(String str);

    protected abstract boolean authentication(String id, String password);

    protected abstract int authorization(String userName);

    protected abstract String connection(String info);

    // 템플릿 메소드
    // abstract는 method 정의 해주어도 되는가?
    public String requestConnection(String encodedInfo) {

        // 보안: 암호화된 문자열 복호화(디코드)
        String decodedInfo = doSecurity(encodedInfo);

        // 인증
        String id = "minkj1992";
        String password = "1234";

        if (!authentication(id, password)) {
            throw new Error("아이디 또는 암호 불일치");
        }
        // userName = getUserName(decodedInfo);
        String userName = "참치먹은김치";

        // 권한
        int i = authorization(userName);
        switch (i) {
            case 0:// 게임 매니저
                break;
            case 1: // 유료 회원
                break;
            case 2: // 무료 회원
                break;
            case 3:// 권한 없음
                break;
            default: // 기타 사항
                break;
        }

        return connection(userName);
    }
}
