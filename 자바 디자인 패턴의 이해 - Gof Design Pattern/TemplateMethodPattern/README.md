# Template Method Pattern
- **일정한 프로세스**를 가진 요구사항을 템플릿 메소드 패턴을 활용해 구현할 수 있다.

## Template Method Pattern 이란
- 알고리즘의 **구조를 메소드에 정의**하고, 하위 클래스에서 알고리즘의 구조를 변경없이 **재정의** 하는 패턴

## 사용 경우
- 구현하려는 알고리즘이 일정한 프로세스가 있다.
- 구현하려는 알고리즘의 변경 가능성이 크다.

## 생성 방법
1. 알고리즘을 여러 단계로 나눈다.
2. 나눠진 알고리즘의 단계를 메소드로 선언한다. (`Abstract class`)
    - 각 method들 선언은 하위 클래스에서 override해주어야 한다.
    - 그러므로 **protected method**로 정의
3. 알고리즘을 수행할 템플릿 메소드 생성. (`Abstract class`)
    - 각 메소드를 실행시키는 템플릿 메소드를 정의한다.
4. 하위 클래스에서 나눠진 메소드들을 구현한다(`DefaultConnectHelper`)
    - extend Abstract class
5. Main method에서 생성 후 실행
    - 이때 Helper class의 패키지와 Main 패키지를 나누어 주어야 한다.
        - protected로 구현된 code들을 Main에서 접근하지 못하도록함
    - `AbsConnectHelper helper = new DefaultConnectHelper();`
    - `helper.템플릿method();`
        - 템플릿 메소드를 통해 알고리즘 실행

## 예제 요구사항
![](../images/TemplateMethod.png)

## 추가 요구사항
![](../images/TemplateMethod2.png)

