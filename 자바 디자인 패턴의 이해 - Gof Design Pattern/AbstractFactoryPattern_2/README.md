# Abstract Factory Pattern 2
> 1보다 실용적인 예제를 통한 학습

- GUI관련된 abstract Factory Pattern

## 구성
1. abstract
    - abstFactory
        - create 추상 부품
    - 부품들
        - 추상적인 기능(method) 보유

2. concrete
    - Main() 함수에서 사용할 abstract interface 제공
        - class FactoryInstance
            - static `getGuiFac()`
            - static `getOsCode()`
    - **이를 통하여 main에서는 어떤 os인지 상관없이, 동일한 인터페이스로 여러 상황에 맞게 활용될 수 있다.**(핵심적인 추상팩토리 패턴 장점) 

3. linux,mac,windows..
    - concreteFactory
    - 구체적인 부품들(linuxButton, MacTextArea ...)
