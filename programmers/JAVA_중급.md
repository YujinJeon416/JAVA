# 중급 자바 정리 자료
> https://programmers.co.kr/learn/courses/9

# java.lang 패키지/오토박싱

- java.lang패키지의 클래스는 import를 하지 않고도 사용할 수 있다.
- java.lang패키지에는 기본형타입을 객체로 변환시킬때 사용하는 Wrapper클래스가 있다.
    - Boolean, Byte, Short, Integer, Long, Float, Double 클래스
- 모든 클래스의 최상위 클래스인 Object도 java.lang패키지
- 문자열과 관련된 String, StringBuffer, StringBuilder도 모두 java.lang패키지
- 화면에 값을 출력할때 사용했던 System클래스도 java.lang패키지
- 수학과 관련된 Math클래스도 java.lang패키지
- Thread와 관련된 중요 클래스들이 java.lang패키지

```java
    public class WrapperExam {
        public static void main(String[] args) {
            int i = 5; 
            Integer i2 = new Integer(5); // 실제 생략된 작동 오토박싱
            Integer i3 = 5;     //오토박싱
            int i4 = i2.intValue(); //실제 생략된 작동 오토언박싱
            int i5 = i2;       //오토언박싱
        }
    }
```

# StringBuffer
> muttable String

- String 클래스의 인스턴스는 한 번 생성되면 그 값을 읽기만 할 수 있고, 변경할 수는 없습니다.
- StringBuffer 클래스의 인스턴스는 그 값을 변경할 수도 있고, 추가할 수도 있습니다.

```java
    StringBuffer sb = new StringBuffer();
    // 해당 스트링 버퍼에 "hello", 공백, "world"를 차례대로 추가

    sb.append("hello");
    sb.append(" ");
    sb.append("world");
    // StringBuffer에 추가된 값을 toString()메소드를 이용하여 반환

    String str = sb.toString();
```
- `sb.toString();`와 같이 String을 반환해야 한다.

- **StringBuffer가 가지고 있는 메소드들은 대부분 자기 자신, this를 반환**

```java
    StringBuffer sb2 = new StringBuffer();
    StringBuffer sb3 = sb2.append("hello");
    if(sb2 == sb3){
        System.out.println("sb2 == sb3");
    }
```
- `메소드 체이닝`: 자기 자신의 메소드를 호출하여 자기 자신의 값을 바꿔나가는 것

- `StringBuffer`는 메소드 체인 방식사용 하도록 만들어짐
    - `this`를 반환하는 것이 이러한 이유
    - `String str2 = new StringBuffer().append("hello").append(" ").append("world").toString();`

# 스트링 클래스의 문제점

- 문자열 + 문자열시 생기는 문제점

```java
    String str3 = str1 + str2;
    System.out.println(str3);
```
- 위의 코드가 내부적으로 진행되는 코드는 아래와 같다.

```java
    String str4 = new StringBuffer().append(str1).append(str2).toString();
    System.out.println(str4);
```

- **이와 같은 이유로 문자열과 문자열을 더하는 것, 특히 반복문 안엣 더하는 것은 성능상의 문제가 생길 수 있다.**

# Math
- Math클래스는 생성자가 private으로 되어 있기 때문에 new 연산자를 이용하여 객체를 생성할 수 없다.

- 객체를 생성할 수는 없지만 모든 메소드와 속성이 static으로 정의되어 있기 때문에 객체를 생성하지 않고도 사용할 수 있다.

```java
    public class MathExam {
        public static void main(String[] args) {
            int value1 = Math.max(5, 20);
            int value2 = Math.min(5, -5);
            int value3 = Math.abs(-10);
            double value4 = Math.random();
            double value5 = Math.sqrt(25);  
        }
    }
```

# java.util 패키지

- 날짜와 관련된 클래스인 Date, Calendar클래스
- 자료구조와 관련된 컬렉션 프레임워크와 관련된 인터페이스와 클래스 deprecated란 더이상 지원하지 않으니 사용하지 않는 것이 좋다란 의미다.
- Date클래스는 지역화를 지원하지 않는다. 지역화란 국가별로 현재 날짜와 시간은 다를 수 있는데, 그 부분을 지원하지 못한다.
- 이런 문제를 해결하기 위하여 나온 클래스가 Calendar클래스. Calendar클래스는 자바 1.1에 등장하였다.
- 지역화와 관련된 클래스들은 Locale로 시작되는 이름을 가진 클래스들입니다. 역시 1.1 이후에 등장한다.
- List, Set, Collection, Map은 자료구조 즉 컬렉션 프레임워크와 관련된 인터페이스

# 컬렉션 프레임워크
> java.util패키지 中 자료구조 클래스들을 칭하는 용어

- [컬렉션 프레임워크 TCP SCHOOL](http://tcpschool.com/java/java_collectionFramework_concept)

- [프로그래머스 컬렉션 프레임 워크](https://programmers.co.kr/learn/courses/9/lessons/256)

# Generic

- 제너릭 사용전
    - 
    ```java
            // Box 클래스
            public class Box {
                private Object obj;
                public void setObj(Object obj){
                this.obj = obj;
                }

                public Object getObj(){
                return obj;
                }
            }
            // BoxExam 클래스
            public class BoxExam {
            public static void main(String[] args) {
                Box box = new Box();
                box.setObj(new Object());
                Object obj = box.getObj();

                box.setObj("hello");
                String str = (String)box.getObj();
                System.out.println(str);

                box.setObj(1);
                int value = (int)box.getObj();
                System.out.println(value);
            }
        }
  ```
    - 일일이 casting을 하고 있는 것을 볼 수 있다.

- Generic 사용 후
    - 
    ```java
        public class Box<E> {
            private E obj;
            public void setObj(E obj){
                this.obj = obj;
            }

            public E getObj(){
                return obj;
            }
        }

    
        public class BoxExam {
            public static void main(String[] args) {
                Box<Object> box = new Box<>();
                box.setObj(new Object());
                Object obj = box.getObj();

                Box<String> box2 = new Box<>();
                box2.setObj("hello");
                String str = box2.getObj();
                System.out.println(str);

                Box<Integer> box3 = new Box<>();
                box3.setObj(1);
                int value = (int)box3.getObj();
                System.out.println(value);
            }
        }
    ```
    - 참조타입에 `<Object> , <String>, <Integer>`가 있는 것을 볼 수 있다.

- **Generic을 사용함으로써 선언할때는 가상의 타입으로 선언하고, 사용시에는 구체적인 타입을 설정함으로써 다양한 타입의 클래스를 이용하는 클래스를 만들 수 있습니다. Generic을 사용하는 대표적인 클래스는 컬렉션 프레임워크와 관련된 클래스입니다.**


# set
> set은 중복이 없고, 순서도 없는 자료구조
- `HashSet`
- `TreeSet`

```java
    import java.util.HashSet;
    import java.util.Iterator;
    import java.util.Set;

    public class SetExam {
        public static void main(String[] args) {
            Set<String> set1 = new HashSet<>();

            boolean flag1 = set1.add("kim");
            boolean flag2 = set1.add("lee");
            boolean flag3 = set1.add("kim");

            System.out.println(set1.size());   //저장된 크기를 출력합니다. 3개를 저장하였지만, 이미 같은 값이 있었기 때문에 2개가 출력
            System.out.println(flag1);  //true
            System.out.println(flag2);  //true
            System.out.println(flag3);  //false

            Iterator<String> iter = set1.iterator();

            while (iter.hasNext()) {   // 꺼낼 것이 있다면 true 리턴.          
                String str = iter.next(); // next()메소드는 하나를 꺼낸다. 하나를 꺼내면 자동으로 다음것을 참조한다.
                System.out.println(str);
            }
        }
    }
```

- 연습 코드
    - `for .. each`
    ```java
        import java.util.*;

        public class SetExam{
            public static void main(String[] args){
                Set<String> set = new HashSet<String>();
                set.add("a");
                set.add("a");
                set.add("b");
                
                System.out.println("set의 내용을 출력합니다.");
                for(String str : set){
                    System.out.println(str);
                }
            }
        }
    ```
    - `hasNext(), next()`
    ```java
        import java.util.*;

        public class SetExam{
            public static void main(String[] args){
                Set<String> set = new HashSet<String>();
                set.add("a");
                set.add("b");
                
                Iterator<String> iter = set.iterator();
                //iter를 이용해서 set의 내용을 출력하세요.
                while (iter.hasNext()){
                    String str = iter.next();
                    System.out.println(str);
                }
            }
        }
    ```
# List
> list는 데이터의 중복이 있을 수 있고, 순서도 있다.

```java
    import java.util.ArrayList;
    import java.util.List;

    public class ListExam {

        public static void main(String[] args) {
            List<String> list = new ArrayList<>();

            // list에 3개의 문자열을 저장합니다.
            list.add("kim");
            list.add("lee");
            list.add("kim");

            System.out.println(list.size()); //list에 저장된 자료의 수를 출력 (중복을 허용하므로 3 출력) 
            for(int i = 0; i < list.size(); i++){
                String str = list.get(i);
                System.out.println(str);
            }
        }   
    }
```

- Excercise
    ```java
        import java.util.*;

        public class ListExam{
            public List<String> addArray(String[]arr1, String[]arr2){
                List<String> list = new ArrayList<String>();
                
                for(String str : arr1){
                    System.out.println(str); 
                    list.add(str);
                }
                
                for(String str : arr2){
                    System.out.println(str);
                    list.add(str);
                }
                return list;
            }
            
            public static void main(String[] args){
            }
        }
    ```

# Map
> Map은 key와 value를 쌍으로 저장하는 자료구조 키는 중복될 수 없고, 값은 중복될 수 있다.

```java
    import java.util.HashMap;
    import java.util.Iterator;
    import java.util.Map;
    import java.util.Set;   
    public class MapExam {  
        public static void main(String[] args) {
            // Key, Value가 모두 String 타입인 HashMap인스턴스를 만듭니다.
            Map<String, String> map = new HashMap<>();

            // key와 value값을 put으로 저장합니다.
            map.put("001", "kim");
            map.put("002", "lee");
            map.put("003", "choi");
            // 같은 key가 2개 있을 수 없습니다. 첫번째로 저장했던 001, kim은 001, kang으로 바뀐다.
            map.put("001", "kang");

            // map에 저장된 자료의 수를 추력합니다. 3이 출력됩니다.
            System.out.println(map.size());

            // 키가 001, 002, 003인 값을 꺼내 출력합니다.
            System.out.println(map.get("001"));
            System.out.println(map.get("002"));
            System.out.println(map.get("003"));

            // map에 저장된 모든 key들을 Set자료구조로 꺼냅니다.
            Set<String> keys = map.keySet();
            // Set자료구조에 있는 모든 key를 꺼내기 위하여 Iterator를 구합니다.
            Iterator<String> iter = keys.iterator();
            while (iter.hasNext()) {
                // key를 꺼냅니다.
                String key = iter.next();
                // key에 해당하는 value를 꺼냅니다.
                String value = map.get(key);
                // key와 value를 출력합니다.
                System.out.println(key + " : " + value);
            }
        }
    }
```

