# Generic
> 컴파일 타임에 타입 체크하여, 클래스 내부에서 사용할 데이터 타입을 인스턴스를 생성한 뒤 확정하는 기능

- [참조링크](https://devbox.tistory.com/entry/Java-%EC%A0%9C%EB%84%A4%EB%A6%AD)

# 장점
- 형변환의 번거로움 줄어듬
- 객체의 타입 안정성 증가

# 사용법
```java
class Person<T>{
    public T info;
}

public class GenericDemo{
    public static void main(String[] args){
        Person<String> p1 = new Person<String>();
        Person<StringBuilder> p2 = new Person<StringBuilder>();
    }
}
```

# 특징

1. 다형성을 사용해야 하는 경우, 부모 타입을 지정함으로 여러 종류의 객체 저장 가능

```java
class Product{}
class Tv extends Product{}
class Radio extends Product{}

ArrayList<Product> list = new ArrayList<Product>();
list.add(new Product());
list.add(new Tv());
list.add(new Radio());

Product p = list.get(0); // 형변환 필요 x
Radio r = (Radio)list.get(0); // 형변환 필요 x
```

2. 제너릭의 안정성 + 와일드 카드 등장 배경
    - Product 클래스가 Tv클래스의 조상이라 할지라도 아래와 같이는 할 수는 없다.
    - ```java
        ArrayList<Product> list = new ArrayList<Tv>();//허용안함
        List<Tv> tvList = new ArrayList<Tv>();// But, 허용된다.
        ```

3. 와일드 카드

- ```java
    class Product{}
    class Tv extends Product{}
    class Radio extends Product{}

    public class GenericTest{

        public static void main(String[] args) {
            ArrayList<Product> list = new ArrayList<Tv>();//허용안함
            List<Tv> tvList = new ArrayList<Tv>();// But, 허용된다.
            ArrayList<? extends Product> list = new ArrayList<Tv>();//허용
        }
    }
    ```

4. 제너릭의 제한
```java
class Person<T extends Info>{
    public T info;  // Info의 child type만 T가 가능하다
}
```