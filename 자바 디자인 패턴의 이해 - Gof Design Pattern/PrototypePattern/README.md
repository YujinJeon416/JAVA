# Prototype Pattern
> PrototypePattern을 통해서 **복잡한 인스턴스를 복사**할 수 있다.

- `Prototype 사전의미`
    - 원형
    - 표준
    - 모범
- `Prototype Pattern`
    - **생산 비용이 높은 인스턴스**를 복사를 통해, 쉽게 생성 할 수 있도록 하는 패턴
## 인스턴스 생산비용이 높은 경우
1. **종류가 너무 많아** 클래스로 정리되지 않는 경우
2. 클래스로부터 인스턴스 **생성이 어려운 경우**

## 요구 사항
- 일러스트레이터와 같은 그림 그리기 툴을 개발중입니다. 
    - 어떤 모양(Shpae)을 그릴 수 있도록 하시오
    - 복사 붙여넣기 기능을 구현하시오
 
## 구현방법
- 자바에서는 `public class Prototype.Shape implements Cloneable`를 통하여, `clone()` method를 아주 쉽게 구현할 수 있다.
- 이후 복사 함수를 만들어준다. 
```java
public class Prototype.Circle extends Shape{
    ...
        public Prototype.Circle copy() throws CloneNotSupportedException {
            Prototype.Circle circle = (Prototype.Circle) clone();
            // 복사 후, 겹치지 않도록 생성하기
            circle.x += 1;
            circle.y += 1;
    
            return circle;
}
```
- `Prototype.Circle circle = (Prototype.Circle) clone();`를 통해 손쉽게 Prototype.Shape 자식객체를 복제가능하다.

## 주의사항
> Package `DeepShallow`를 통해 명시
- 깊은 복사
- 얕은 복사



