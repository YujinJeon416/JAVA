

# STRING

> [string](https://programmers.co.kr/learn/courses/5/lessons/139)
- `==`: ref 확인
- new연산자를 이용하여 인스턴스를 만들면 인스턴스는 무조건 새롭게 만들어진다.
- String이 가지고 있는 메소드중 String을 반환하는 메소드는 모두 새로운 String을 생성해서 반환한다.

- `str.substring(3);`
    - 문자열 중 3번째 위치부터 끝까지 자른 결과를 새로운 String 형태로 return
- `str.substring(a,b)`
    - a..b-1까지 idx의 string을 생성하여 return

- `str.equals(str2);`
    - 값에 대한 비교 후 bool 반환

- `str.concat(subWord);`
    - `str + subWord` return

# field
> 클래스가 가지는 속성 == **field == 멤버변수 == 전역변수**(class안에서)

- `car.name, car.number`등 `.`(dot)을 통해 참조변수를 참조한다.

- static을 붙이지 않아도, class field는 global scope이다.
- main은 static한 메소드이다. static 메소드에서는 non-static 필드를 사용할 수 없다.

```java
public class ScopeTest{
    // 둘 모두 global variable(전역변수) == 멤버변수 == field

    // 1-1.클래스변수 = static 변수
    // 1-2. convention: ScopeTest.staticVariable (0)
    static int staticVariable = 1;
    
    // 2-1.인스턴스변수
    // 2-2. convention: scopeInstance1.instanceVariable (0)
    int instanceVariable = 1;

    public static void main(String[] args){
        ScopeTest scopeInstance1 =new ScopeTest();
    }

}
```

# method
> 클래스가 가지는 행동(기능)

# static
- 같은 클래스 내에 있음에도, 해당 변수들을 사용할 수 없다.
- static한 메소드는 초기에 생성되기에 class가 인스턴스화 되지 않아도 사용할 수 있다.
- static한 변수는 공유된다.
    - static 변수는 값을 저장하는 공간이 하나만 생성된다.
    - 인스턴스가 여러개 생기더라도 static 변수는 공유된다.


# enum
> https://programmers.co.kr/learn/courses/5/lessons/423

- 열거형
- 가능한 값의 목록을 명시하고, 사용자들의 선택을 해당 범위를 벗어나지 못하도록 강제한다.

```java
enum Gender{
    MALE, FEMALE;
}
Gender gender1;
gender1 = Gender.MALE;
gender1 = Gender.FEMALE;
```

- **특정 값만 가져야 한다면 열거형을 사용하는 것이 좋다.**

# 생성자
> 객체 필드 초기화 역활 수행

- 클래스의 이름과 생성자의 이름이 같아야 한다.
- 생성자는 리턴타입이 없다.
- 만약 프로그래머가 생성자를 만들지 않는다면, 컴파일시 자동으로 `매개변수가 없는 생성자`(=`기본 생성자`)가 자동으로 만들어진다.
- 만약 매개변수가 있는 생성자를 프로그래머가 만든다면 `Car c1 = new Car();`과 같은 구문은 허용되지 않는다. ( `기본 생성자 x` )

# this
> 현재 객체, 자기 자신을 나타냄

```java
    public Car(String name){
        name = name;
    }
```
- `name=name` 이라고 코드를 바꾸면, 가깝게 선언된 변수를 우선 사용하기 때문에 `name=name`이라는 코드는 매개변수의 name의 값을 매개변수 name에 대입하라는 의미가 된다.

- `this`를 사용해 위의 문제를 수정하면,
```java
    // 생성자 
    public Car(String name){
        this.name = name;
    }
```

- **클래스 안에서 자기 자신이 가지고 있는 메소드를 사용할 때는 `this.method()`를 통해 호출할 수 있다.**

# 메소드 오버로딩
> 같은 이름의 여러 메소드들을 매개변수의 유형과 갯수를 다르게 하여 사용하도록 하는 기술 ( 다형성 )

- 하나의 함수에 여러개의 기능을 부여 가능
- 매개변수 타입, 갯수를 통해 차이를 둔다. (return은 상관없음)

# 생성자 오버로딩과 this()

### 생성자 오버로딩
> 생성자를 오버로딩 시킨다.

- 생성자가 여러개 생길 때, 그냥 this를 하게된다면, 코드의 중복이 발생한다.

- `this()`: 자신의 생성자를 호출하는 것.

- 코드 중복 발생
```java
public Car() {
    this.name = "이름없음";
    this.number = 0;
}

public Car(String name, int number) {
    this.name = name;
    this.number = number;
}
```
- **car()이 car(name,number)생성자를 호출 함으로써 코드의 중복을 피한다.**
- `this()`를 통한 해결

```java
public Car() {
    // 자기 자신의 생성자를 호출
    this("이름없음", 0);
}
public Car(String name, int number) {
    this.name = name;
    this.number = number;
}
```

# 상속
> 부모가 자식에게 매소드,필드 물려주는것

- `is a`, `kind of`관계
- `public class Child extends Parent{}`

# 접근 제한자
> 클래스 내에서 멤버의 접근을 제한하는 역할

# 추상 클래스
> 구체적이지 않은 클래스, 하위 개념들의 공통점을 묶어 추상화한 상위 클래스

- **class 앞에 `abstract`를 붙여야한다.**
- `추상 클래스`는 미완성의 `추상 메소드`를 포함할 수 있다.
    - `추상메소드`
        - 내용이 없는 메소드 (구현 되지 않은 메소드)
        - **return type 앞에 abstract를 붙여야한다.**
- **추상 클래스는 인스턴스를 생성할 수 없다.**

- 추상 클래스를 상속받는 클래스를 생성 ( **사용법** )
    - 상속 받은 클래스는 추상 클래스가 가지고 있는 추상 메소드를 반드시 구현해야 한다. 
    - (구현하지)그렇지 않다면, 상속받은 클래스를 추상클래스로 해야한다.


# super와 부모생성자
> class가 인스턴스화 될때 생성자가 실행되면서 객체의 초기화를 한다. 그 때 자신의 생성자만 실행이 되는것이 아니고, 부모의 생성자부터 실행된다.

- `super`: 부모를 가리키는 키워드
- `super()`: 부모의 생성자

- 부모의 생성자를 임의로 호출하지 않으면, 부모 class의 기본 생성자가 자동으로 호출된다.

- **super 키워드는 자식에서 부모의 메소드나 필드를 사용할 때도 사용합니다.**

# 오버라이딩
> 오버라이딩이란 부모가 가지고 있는 메소드와 똑같은 모양의 메소드를 자식이 가지고 있는 것이다. 즉 오버라이딩이란 메소드를 재정의 하는 것이다.

- 메소드를 오버라이드 하면, 항상 자식클래스에서 정의된 메소드가 호출된다.
- 오버라이딩 한다고 해서 부모의 메소드가 사라지는 것은 아니다.
- `super.parentMethod()`를 이용하면, 부모의 메소드를 호출 할 수 있다.

# 클래스 형변환
> https://programmers.co.kr/learn/courses/5/lessons/193

> 부모 타입으로 자식을 가리킬 수 있다.

- 부모타입으로 자식객체를 참조하게 되면 부모가 가지고 있는 메소드만 사용할 수 있다. 자식객체가 가지고 있는 메소드나 속성을 사용하고 싶다면 형변환 해야 한다.

- **객체들 끼리도 형변환이 가능하다. 단 상속관계에 있었을 때만 가능하다.**

- 부모타입으로 자식타입의 객체를 참조할 때는 묵시적으로 형변환이 일어난다.
```java
    public class BusExam{
        public static void main(String args[]){
            //  부모 = 자식
            //  묵시적 형변환
            Car car = new Bus();
            car.run();
            //car.ppangppang(); // 컴파일 오류 발생

            //  자식 = (자식)부모
            //  명시적 형변환
            Bus bus = (Bus)car;  //부모타입을 자식타입으로 형변환 
            bus.run();
            bus.ppangppang();
        }
    }
```

- `클래스.getClass().getName()`: 클래스가 실제로 어떤 클래스name인지 알려준다.

# 인터페이스
> 서로 관계 없는 물체들이 상호작용 하기위해 사용하는 장치나 시스템

- `인터페이스 =추상메소드 + 상수`
- 인터페이스에 정의된 메소드는 모두 `abstract method`이다.

- 컴파일 전
```java
    public interface TV{
        public int MAX_VOLUME = 100;
        public int MIN_VOLUME = 0;

        public void turnOn();
        public void turnOff();
        public void changeVolume(int volume);
        public void changeChannel(int channel);
    }
```
- 컴파일 후
```java
public interface TV{
    public static final int MAX_VOLUME = 100;
    public static final int MIN_VOLUME = 0;

    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void changeVolume(int value);
    public abstract void changeChannel(int number);
}
```

# 인터페이스 사용법

- `class 클래스 implements 인터페이스`

- 인터페이스가 가지고 있는 메소드를 하나라도 구현하지 않는다면 해당 클래스는 추상클래스가 된다.(추상클래스는 인스턴스를 만들 수 없음)

- 참조변수의 타입으로 인터페이스를 사용할 수 있다. 이 경우 인터페이스가 가지고 있는 메소드만 사용할 수 있다.
    - `TV tv = new LedTV();`
    - TV는 인터페이스

# 인터페이스의 default method
> https://programmers.co.kr/learn/courses/5/lessons/241

- JAVA 8이 등장하면서 interface에 대한 정의가 몇 가지 변경되었다.

- 기존에는 인터페이스가 변경되면 인터페이스를 구현하는 모든 클래스들이 해당 메소드를 구현해야 한다는 문제가 있었다.
- 이를 해결하기 위해 default, static method 도입

- default method
    - Override 가능
- static method
    - Override 불가능

```java
    public interface Calculator {
        public int plus(int i, int j);
        public int multiple(int i, int j);
        // 오버라이딩 가능
        default int exec(int i, int j){
            return i + j;
        }
        // 오버라이딩 불가능
        public static int exec2(int i, int j){   //static 메소드 
            return i * j;
        }
    }
```

# 내부클래스
> https://programmers.co.kr/learn/courses/5/lessons/242

1. `인스턴스 클래스`
    - 생성법: `외부클래스.인스턴스클래스 ref변수명 = 외부클래스.new 인스턴스클래스();`
    
    - ```java
        public class InnerExam1{
            class Cal{
                int value = 0;
                public void plus(){
                    value++;
                }
            }

            public static void main(String args[]){
                InnerExam1 t = new InnerExam1();
                InnerExam1.Cal cal = t.new Cal();
                cal.plus();
                System.out.println(cal.value);

            }
        }
    ```
2. `static 클래스`
    - 필드 선언할 때 스태틱한 필드로 선언한 것과 같다. 이 경우에는 InnerExam2객체를 생성할 필요없이 new InnerExam2.Cal() 로 객체를 생성할 수 있다.
    - ```java
        public class InnerExam2{
        static class Cal{
            int value = 0;
            public void plus(){
                value++;
            }
        }

        public static void main(String args[]){
            InnerExam2.Cal cal = new InnerExam2.Cal();
            cal.plus();
            System.out.println(cal.value);

        }
    }
    ```
3. `지역 클래스(local class)`
    - ```java
        public class InnerExam3{
            public void exec(){
                class Cal{
                    int value = 0;
                    public void plus(){
                        value++;
                    }
                }
                Cal cal = new Cal();
                cal.plus();
                System.out.println(cal.value);
            }


            public static void main(String args[]){
                InnerExam3 t = new InnerExam3();
                t.exec();
            }
        }
    ```
4. `익명클래스`

# 익명클래스
> 익명클래스 

```java
    //추상클래스 Action 
    public abstract class Action{
        public abstract void exec();
    }

    //추상클래스 Action을 상속받은 클래스 MyAction

    public class MyAction extends Action{
        public void exec(){
            System.out.println("exec");
        }
    }

    //MyAction을 사용하는 클래스 ActionExam 
    public class ActionExam{
        public static void main(String args[]){
            Action action = new MyAction();
            action.exec();
        }
    }

    //MyAction을 사용하지 않고 Action을 상속받는 익명 클래스를 만들어서 사용하도록 수정해 보도록 하겠습니다.
    public class ActionExam{
        public static void main(String args[]){
            Action action = new Action(){
                public void exec(){
                    System.out.println("exec");
                }
            };
            action.exec();
        }
    }
```
- 생성자 다음에 중괄호 열고 닫고가 나오면, 해당 생성자 이름에 해당하는 클래스를 상속받는 이름없는 객체를 만든다는 것을 뜻한다.

- 괄호 안에는 메소드를 구현하거나 메소드를 추가할 수 있다. 이렇게 생성된 이름 없는 객체를 action이라는 참조변수가 참조하도록 하고, exec()메소드를 호출.

- 익명클래스를 만드는 이유는 Action을 상속받는 클래스를 만들 필요가 없을 경우이다.

- Action을 상속받는 클래스가 해당 클래스에서만 사용되고 다른 클래스에서는 사용되지 않는 경우이다.

--------------------예외처리
> https://programmers.co.kr/learn/courses/5/lessons/244