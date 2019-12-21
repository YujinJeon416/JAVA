# Builder Pattern
> 복잡한 단계가 있는 인스턴스 생성과정 단순화

- 패턴1: 책에서 배운 패턴
- 패턴2: 현장에서 배운 패턴

# 패턴 1
> 템플릿 메서드 패턴과 유사함

- `Builder Pattern`: **복잡한 단계**를 거쳐야 생성되는 객체의 구현을 **서브 클래스**에게 넘겨주는 패
턴
    - 복잡한 단계는 추상화 시켜서 sub 클래스에 전달
    - sub클래스에서 실제 구현
 
## 요소 및 기능
- Builder(Factory)
    - BluePrint를 받아들이고, 생성하고 내보낸다.
- BluePrint
    - 추상적인 설계도
    - 설계에 필요한 양식을 정한다.
- LgGramBluePrint
    - 실제적인 설계도
    - 필요한 양식들에 복잡한 알고리즘을 구체화 시킨다.
    - 설계도 끼리의 순서를 강제하기도 한다.
        - 예시에서는 `makeAndGet()`
- Computer
    - 생성될 class instance

  