# Singleton Pattern
> 싱글톤 패턴을 통해 **하나의 인스턴스**만 생성하도록 구현 할 수 있다.

- `static private 싱글톤 instance`
- `private 생성자()`
    - 생성자는 getInstance에서만 호출
- `public static getInstance()`
    - 싱글톤 instance를 불러주어야 하므로

## 요구사항
- 개발중인 시스템에서 스피커에 접근할 수 있는 class를 만들라
    - 스피커에 하나이상 접근한다면, sync가 맞지 않기 때문에
    - 그렇지 않다면 여러개의 instance에 볼륨 값을 계속적으로 update 해주어 overhead일어남
- 결론은 싱글톤
