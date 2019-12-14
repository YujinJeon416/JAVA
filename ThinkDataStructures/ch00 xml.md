# XML

## XML이란 무엇인가?
- xml(`eXtensible Markup Language`)
- `확장될 수 있는 표시 언어`
- Markup language의 대표적 예로 `HTML`
    - `HTML`은 이미 약속한 태그들만 사용 가능
    - `XML`태그는 사용자 임의로 만들 수 있다.
- 웹에서 디스플레이 표준을 HTML로 한것처럼 데이터의 표준으로 만들기 위한 노력이 있었다.
- XML은 데이터를 구조화시키는데 사용, 데이터를 기술하기 위해 고안
- HTML은 동일한 데이터를 표시하고 꾸미는데 사용

## JSON과 XML의 차이
> https://12bme.tistory.com/202
- XML 단점
    - XML은 장황하고 복잡하다.
        - 각 프로그래밍 언어, DB시스템 입력을 위해 XML MAPPING하기 어렵다.
        - 데이터가 특정 애플리케이션에 맞춰 구조화된 경우 더 까다롭
        - 많은 태그로 문자량이 늘어나 응답시간 느려짐

    - 보안
        - BL(Billion Laughs) 공격 또는 EE(External Entity) 공격 같은 보안 취약성

    - 자바스크립트 호환
- XML 장점
    - 쿼리가 적용된 XML기반 데이터베이스
    - JSON은 데이터 교환 형식이고, XML은 더 광범위한 일련의 툴
        - XML은 Metadata 지원
        - JSON은 속성에 불가하여 메타데이터를 JSON으로 표현해야함
        - JSON은 명칭공간을 지원하지 않음
        - 그래픽 파일, 문서등의 바이너리 코딩 파일은 xml이 더 적합

## JSON 사용 범위
> http://tcpschool.com/json/json_intro_xml

- XML 문서는 XML DOM(Document Object Model)을 이용하여 해당 문서에 접근합니다. 하지만 JSON은 문자열을 전송받은 후에 해당 문자열을 바로 파싱하므로, XML보다 더욱 빠른 처리 속도를 보여줍니다.
- 따라서 HTML과 자바스크립트가 연동되어 빠른 응답이 필요한 웹 환경에서 많이 사용되고 있습니다.
- 하지만 JSON은 전송받은 데이터의 무결성을 사용자가 직접 검증해야 합니다. 따라서 데이터의 검증이 필요한 곳에서는 스키마를 사용하여 데이터의 무결성을 검증할 수 있는 XML이 아직도 많이 사용되고 있습니다.