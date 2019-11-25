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

# 자바IO

- 자바 IO는 크게 `byte단위`,`문자단위` 입출력클래스로 나뉜다.
- 장식 클래스

# Byte 단위 입출력
> Byte단위 입출력 클래스는 클래스의 이름이 InputStream이나 OutputStream으로 끝난다.

- 파일로 부터 1byte씩 읽어들여 파일에 1byte씩 저장하는 프로그램을 작성
    - 파일로 부터 읽어오기 위한 객체 - FileInputStream
    - 파일에 쓸수 있게 해주는 객체 - FileOutputStream .
- read()메소드가
    - byte를 리턴한다면 끝을 나타내는 값을 표현할 수가 없기 때문에, byte가 아닌 int를 리턴한다.
    - 음수의 경우 맨 좌측 비트가 1이 된다. 읽어들일 것이 있다면 항상 양수를 리턴한다고볼 수 있다. .
- FileInputStream과 FileOutputStream을 이용하여, 1바이트씩 읽어들여 1바이트씩 저장
    - read()메소드가 리턴하는 타입은 정수인데, 정수 4바이트중 마지막 바이트에 읽어들인 1바이트를 저장한다.
    - read()메소드는 더이상 읽어들일 것이 없을때 -1을 리턴한다.

```java
    public class ByteIOExam1 {
        public static void main(String[] args){     
            FileInputStream fis = null; 
            FileOutputStream fos = null;        
            try {
                fis = new FileInputStream("src/javaIO/exam/ByteExam1.java");
                fos = new FileOutputStream("byte.txt");

                int readData = -1; 
                while((readData = fis.read())!= -1){
                    fos.write(readData);
                }           
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                try {
                    fos.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                try {
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
```
- `int readData = fis.read()`
- `int readDate = fis.read(buffer)`처럼 안에 버퍼 변수를 넣을수 있고, 이 경우 버퍼 단위로 읽어들인다.
    - `void write(byte buf[], int index, int size)` 
    - size에는 읽어들인 데이터 size가 저장된다.
    - index는 읽어들일 위치

- `Q&A`
```
1-1 fis.read()는 파일로부터 읽어들인 1byte를 리턴하는 건가요?
아닙니다. 파일로 부터 읽어들인 문자 하나(크기는 4byte)를 리턴합니다.
그러면 char형으로 리턴하면 되지, 왜 int형으로 리턴하는가에 의문이 남죠.
그 이유는 자료형의 범위 때문인데요. char 자료형은 2byte로 (0 ~ 216 - 1) 의 범위를 가집니다.
그러나 read()는 더 이상 읽을 문자가 없을 경우 -1을 리턴하기 때문에 실제로 필요한 범위는 (-1 ~ 216 - 1) 이죠.
이 범위를 만족하는 가장 작은 자료형이 int형이므로 리턴값의 크기가 int형(4byte)이 된 것입니다.

1-2 fis.read(buffer)는 인자인 buffer에 파일로부터 읽어들인 1byte를 대입하고, 읽어들인 횟수를 리턴하는 건가요?
읽은 값을 buffer에 저장하는 것은 맞습니다.
그러나 buffer의 크기가 512byte이기 때문에, buffer에 읽어들인 (최대)512byte를 저장하는 것 입니다.
리턴값은 읽은 횟수가 아닌 읽은 값의 크기를 리턴합니다.
예를 들어, 327byte인 파일이 있다고 한다면 buffer에는 327byte가 저장되고, readCount에는 읽은 값의 크기(byte 수)인 327을 리턴 받습니다.
그리고 두번째 읽을 때 buffer에는 아무 값이 저장되지 않고, readCount에는 -1을 리턴 받고 종료 되겠죠.
```
# Byte 단위 입출력 심화

```java
    public class ByteIOExam1 {
        public static void main(String[] args){     
            //메소드가 시작된 시간을 구하기 위함
            long startTime = System.currentTimeMillis();        
            FileInputStream fis = null; 
            FileOutputStream fos = null;        
            try {
                fis = new FileInputStream("src/javaIO/exam/ByteExam1.java");
                fos = new FileOutputStream("byte.txt");

                int readCount = -1; 
                byte[] buffer = new byte[512];
                while((readCount = fis.read(buffer))!= -1){
                    fos.write(buffer,0,readCount);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                try {
                    fos.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                try {
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        //메소드가 끝났을때 시간을 구하기 위함. 
        long endTime = System.currentTimeMillis();
        //메소드를 수행하는데 걸린 시간을 구할 수 있음. 
        System.out.println(endTime-startTime); 
        }
    }
```
- 파일로 부터 512byte씩 읽어들여 파일에 512byte씩 저장하는 프로그램을 작성
    - `byte[] buffer = new byte[512];`
    - 512byte만큼 읽어 들이기 위해 byte배열을 사용

# 다양한 타입의 출력

- `try-with-resources`
    - close()메소드를 사용자가 호출하지 않더라도, Exception이 발생하지 않았다면 자동으로 close()가 되게 할 수 있는 방법
    - try(리소스)를 넣어주어 문법을 작성한다.
    - 
    ```java
        try (SomeResource resource = getResource()) {
            use(resource);
        } catch(...) {
            ...
        }
    ```
    - 기존 `try-catch-finally`에서 finally 부분에서 `close`를 담당해주어 `mem leak`을 방지해주었던 부분이, `try(resource1;resource2)`괄호 속에 들어가게 하여 자동으로 close하게 한다.
    - try 괄호 `()`안에서, 예외가 발생할 경우 try 구문 안에서 예외처리가 된다. 그러나 예외는 동시에 2개를 나타낼 수 없으므로 2개 이상이 등장한다면, `Suppressed`형식으로 예외가 표기된다.
    - try with resources를 사용하기 위해서는, `AutoCloseable`을 implements해야 한다.
        - 대부분 resource들은 autocloseable을 implements한 것 같다.
    - **추가로 비동기 순서 강제방법과 예외처리에 대해서 공부!**
    
- `DataOutputStream`
    - `new DataOutputStream(new FileOutputStream("data.txt"));`
    - 다양한 타입의 데이터를 저장할 수 있는 클래스
        - `wirteInt()` - 정수값으로 저장
        - `wirteBoolean()` - boolean값으로 저장
        - `writeDouble()` - double 값으로 저장
    - 
    ```java

    import java.io.DataOutputStream;
    import java.io.FileOutputStream;    
    public class ByteExam3 {    
        public static void main(String[] args) {
            try(
                    DataOutputStream out = new DataOutputStream(new FileOutputStream("data.txt"));
            ){
                out.writeInt(100);
                out.writeBoolean(true);
                out.writeDouble(50.5);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }   
    }
    ```

# 다양한 타입의 입력
- data.dat로부터 값을 읽어들여 화면에 출력하는 클래스
- `DataInputStream out = new DataInputStream(new FileInputStream("data.dat"));`
- **파일에 저장된 순서대로 읽어 들여야한다.**

```java
import java.io.*;

public class DataInputStreamExam{
    public static int read3(){
        int sum = 0;
        //data.txt로부터 int값 3개를 읽어들여서 sum에 더하세요.
        try(
            DataInputStream in = new DataInputStream(new FileInputStream("data.txt"));
        ){
            int cnt = 3;
            while (cnt>0){
                sum += in.readInt();
                cnt -= 1;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return sum;
    }
}
```

# Char 단위 입출력(Console)
> char단위 입출력 클래스는 클래스 이름이 Reader나 Writer로 끝이 난다.

- char단위 입출력 클래스를 이용해서 키보드로 부터 한줄 입력 받아서 콘솔에 출력
    - System.in - 키보드를 의미 (InputStream )
    - BufferedReader - 한줄씩 입력 받기위한 클래스
    - BufferedReader 클래스의 생성자는 InputStream을 입력받는 생성자가 없다.
    - System.in은 InputStream 타입이므로 BufferedReader의 생성자에 바로 들어갈 수 없으므로 InputStreamReader 클래스를 이용해야함.

```java

    import java.io.BufferedReader;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.io.PrintWriter; 
    public class CharIOExam01 {
        public static void main(String[] args) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //키보드로 입력받은 문자열을 저장하기 위해 line변수를 선언               
            String line = null;     
            try {
                line = br.readLine()
            } catch (IOException e) {
                e.printStackTrace();
            }
            //콘솔에 출력 
            System.out.println(line);
        }
    }
```

# Char 단위 입출력(File)


- 파일에서 한 줄씩 입력 받아서 파일에 출력
    - 파일에서 읽기위해서 FileReader 클래스 이용
    - 한 줄 읽어 들이기 위해서 BufferedReader 클래스 이용
        - BufferedReader 클래스가 가지고 있는 readLine() 메소드가 한줄씩 읽게 해준다.
        - readLine()메소드는 읽어낼 때 더 이상 읽어 들일 내용이 없을 때 null을 리턴한다.
    - 파일에 쓰게하기 위해서 FileWriter 클래스 이용
    - 편리하게 출력하기 위해서 PrintWriter 클래스 이용

```java

    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.io.PrintWriter; 
    public class CharIOExam02 {
        public static void main(String[] args) {
            BufferedReader br;
            PrintWriter pw;
            try{        
                br = new BufferedReader(new FileReader("src/javaIO/exam/CharIOExam02.java"));
                pw = new PrintWriter(new FileWriter("test.txt"));
                String line = null;
                while((line = br.readLine())!= null){
                    pw.println(line);
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                pw.close();
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
```

- 연습문제 ( 파일에 string 한 문장 입력하기 )
```java
import java.io.*;
public class CharIOExam{
    public static void main(String[]args){
        try(PrintWriter pw = new PrintWriter(new FileWriter("data.txt"))){
            String line = "안녕하세요. PrintWriter입니다.";
            pw.println(line);
            }catch(Exception e){
                e.printStackTrace();
        }
    }
}
```

# 어노테이션
> 어노테이션을 클래스나 메타코드에 붙인 후, 클래스가 컴파일되거나 실행될 때 어노테이션의 유무나 어노테이션에 설정된 값을 통하여 클래스가 좀 더 다르게 실행되게 할 수 있습니다.이런 이유로 어노테이션을 일정의 설정파일처럼 설명하는 경우도 있습니다.

- [링크](https://programmers.co.kr/learn/courses/9/lessons/269)

# 쓰레드 만들기 ( `extend Thread` )

- 자바에서 Thread를 만드는 방법 ( 2 )
    - Thread 클래스를 상속받는 방법
    - Runnable인터페이스를 구현하는 방법

# 1. Thread 클래스를 상속받는 방법

- Thread를 상속 받아서 쓰레드를 생성하는 방법
    - java.lang.Thread클래스를 상속받는다. 
    - Thread가 가지고 있는 run()메소드를 오버라이딩한다.
    - 10번 반복하면서 str을 찍는다.
```java
    public class MyThread1 extends Thread {
        String str;
        public MyThread1(String str){
            this.str = str;
        }

        public void run(){
            for(int i = 0; i < 10; i ++){
                System.out.print(str);
                try {
                    Thread.sleep((int)(Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } 
        } 
    }
```

- Thread 클래스를 상속받은 MyThread1을 사용하는 클래스
    - Thread를 상속 받았으므로 MyThread1은 Thread 이다.
    - 쓰레드를 생성하고, Thread 클래스가 가지고 있는 start() 메소드를 호출 한다.

```java
    public class ThreadExam1 {
        public static void main(String[] args) {
            // MyThread인스턴스를 2개 만듭니다. 
            MyThread1 t1 = new MyThread1("*");
            MyThread1 t2 = new MyThread1("-");

            t1.start();
            t2.start();
            System.out.print("!!!!!");  
        }   
    }
```

# 2. Runnable인터페이스를 구현하는 방법 
- Runnable인터페이스를 구현해서 쓰레드를 만드는 방법
    - Runable 인터페이스가 가지고 있는 run()메소드를 구현한다.
```java
    public class MyThread2 implements Runnable {
        String str;
        public MyThread2(String str){
            this.str = str;
        }

        public void run(){
            for(int i = 0; i < 10; i ++){
                System.out.print(str);
                try {
                    Thread.sleep((int)(Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } 
        } 
    }
```
- Runable 인터페이스를 구현한 MyThread2 사용하는 방법
    - MyThread2는 Thread를 상속받지 않았기 때문에 Thread가 아니다.
    - Thread를 생성하고, 해당 생성자에 MyThread2를 넣어서 Thread를 생성한다.
    - Thread 클래스가 가진 start()메소드를 호출한다.

```java
    public class ThreadExam2 {  
        public static void main(String[] args) {
            MyThread2 r1 = new MyThread2("*");
            MyThread2 r2 = new MyThread2("-");

            Thread t1 = new Thread(r1);
            Thread t2 = new Thread(r2);

            t1.start();
            t2.start();
            System.out.print("!!!!!");  
        }   
    }
```

# 쓰레드와 공유객체
> 하나의 객체를 여러개의 Thread가 사용한다는 것을 의미

- Critical Section ( Music 함수를 가지고 있는 class )
```java
    public class MusicBox { 
        //신나는 음악!!! 이란 메시지가 1초이하로 쉬면서 10번 반복출력
        public void playMusicA(){
            for(int i = 0; i < 10; i ++){
                System.out.println("신나는 음악!!!");
                try {
                    Thread.sleep((int)(Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } // for        
        } //playMusicA

        //슬픈 음악!!!이란 메시지가 1초이하로 쉬면서 10번 반복출력
        public void playMusicB(){
            for(int i = 0; i < 10; i ++){
                System.out.println("슬픈 음악!!!");
                try {
                    Thread.sleep((int)(Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } // for        
        } //playMusicB
        //카페 음악!!! 이란 메시지가 1초이하로 쉬면서 10번 반복출력
        public void playMusicC(){
            for(int i = 0; i < 10; i ++){
                System.out.println("카페 음악!!!");
                try {
                    Thread.sleep((int)(Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } // for        
        } //playMusicC  
    }
```

- MusicBox를 공유하는 User Thread (3개 생성 in 예제)
```java
    public class MusicPlayer extends Thread{
        int type;
        MusicBox musicBox;  
        // 생성자로 부터 musicBox와 정수를 하나 받아들여서 필드를 초기화
        public MusicPlayer(int type, MusicBox musicBox){
            this.type = type;
            this.musicBox = musicBox;
        }       
        // type이 무엇이냐에 따라서 musicBox가 가지고 있는 메소드가 다르게 호출
        public void run(){
            switch(type){
                case 1 : musicBox.playMusicA(); break;
                case 2 : musicBox.playMusicB(); break;
                case 3 : musicBox.playMusicC(); break;
            }
        }       
    }
```
- MusicBox를 테스트하는 main 코드
```java
    public class MusicBoxExam1 {

        public static void main(String[] args) {
            // MusicBox 인스턴스
            MusicBox box = new MusicBox();

            MusicPlayer kim = new MusicPlayer(1, box);
            MusicPlayer lee = new MusicPlayer(2, box);
            MusicPlayer kang = new MusicPlayer(3, box);

            // MusicPlayer쓰레드를 실행합니다. 
            kim.start();
            lee.start();
            kang.start();           
        }   
    }
```

- 전체적으로 User 3명(Thread)가 동시에 하나의 `MusicBox` 객체를 공유하기 때문에, Race condition이 발생할 수 밖에 없다.

# 동기화 메소드와 동기화 블록
> `Synchronized`

- [프로그래머스 링크](https://programmers.co.kr/learn/courses/9/lessons/274)

# Thread 상태제어
> New Thread, Blocked, Dead, Runnable, Running

- 쓰레드는 실행가능상태인 Runnable과 실행상태인 Running상태로 나뉜다.
- 실행되는 쓰레드 안에서 Thread.sleep()이나 Object가 가지고 있는 wait()메소드가 호출이 되면 쓰레드는 블록상태가 된다.
- Thread.sleep()은 특정시간이 지나면 자신 스스로 블록상태에서 빠져나와 Runnable이나 Running상태가 된다.
- Object가 가지고 있는 wait()메소드는 다른 쓰레드가 notify()나 notifyAll()메소드를 호출하기 전에는 블록상태에서 해제되지 않는다.
- wait()메소드는 호출이 되면 모니터링 락을 놓게 된다. 그래서 대기중인 다른 메소드가 실행한다.
- 쓰레드의 run메소드가 종료되면, 쓰레드는 종료된다. 즉 Dead상태가 된다.
- Thread의 yield메소드가 호출되면 해당 쓰레드는 다른 쓰레드에게 자원을 양보하게 된다.
- Thread가 가지고 있는 join메소드를 호출하게 되면 해당 쓰레드가 종료될 때까지 대기하게 된다.

# 쓰레드와 상태제어(join)
> join()메소드는 쓰레드가 멈출때까지 기다리게 한다.

- `sleep()` 하는 class
```java
    public class MyThread5 extends Thread{
        public void run(){
            for(int i = 0; i < 5; i++){
                System.out.println("MyThread5 : "+ i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } // run
    }
```

- `join()` 하는 class
```java
    public class JoinExam { 
        public static void main(String[] args) {
            MyThread5 thread = new MyThread5();
            // Thread 시작 
            thread.start(); 
            System.out.println("Thread가 종료될때까지 기다립니다.");
            try {
                // 해당 쓰레드가 멈출때까지 멈춤
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread가 종료되었습니다."); 
        }   
    }
```

# 쓰레드와 상태제어
> wait, notify

- wait와 notify는 동기화된 블록안에서 사용해야 한다.
- wait를 만나게 되면 해당 쓰레드는 해당 객체의 모니터링 락에 대한 권한을 가지고 있다면 모니터링 락의 권한을 놓고 대기한다.
    - **자바 Thread와 운영체제 Thread 추가 학습**
        - https://ssipflow.github.io/os/Thread/
- **자바 모니터링 락과 락 체계 공부해보자**
    - http://happinessoncode.com/2017/10/04/java-intrinsic-lock/
    - https://parkcheolu.tistory.com/24

- 
```java
    public class ThreadB extends Thread{
       // 해당 쓰레드가 실행되면 자기 자신의 모니터링 락을 획득
       // 5번 반복하면서 0.5초씩 쉬면서 total에 값을 누적
       // 그후에 notify()메소드를 호출하여 wiat하고 있는 쓰레드를 깨움 
        int total;
        @Override
        public void run(){
            synchronized(this){
                for(int i=0; i<5 ; i++){
                    System.out.println(i + "를 더합니다.");
                    total += i;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                notify();
            }
        }
    }
```

-
```java
    public class ThreadA {
        public static void main(String[] args){
            // 앞에서 만든 쓰레드 B를 만든 후 start 
            // 해당 쓰레드가 실행되면, 해당 쓰레드는 run메소드 안에서 자신의 모니터링 락을 획득
            ThreadB b = new ThreadB();
            b.start();

            // b에 대하여 동기화 블럭을 설정
            // 만약 main쓰레드가 아래의 블록을 위의 Thread보다 먼저 실행되었다면 wait를 하게 되면서 모니터링 락을 놓고 대기       
            synchronized(b){
                try{
                    // b.wait()메소드를 호출.
                    // 메인쓰레드는 정지
                    // ThreadB가 5번 값을 더한 후 notify를 호출하게 되면 wait에서 깨어남
                    System.out.println("b가 완료될때까지 기다립니다.");
                    b.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

                //깨어난 후 결과를 출력
                System.out.println("Total is: " + b.total);
            }
        }
    }
```

- 실행결과
```
        b가 완료될때까지 기다립니다.
        0를 더합니다.
        1를 더합니다.
        2를 더합니다.
        3를 더합니다.
        4를 더합니다.
        Total is: 10
```

# 데몬 쓰레드

```java
    public class DaemonThread implements Runnable {...}

    Thread th = new Thread(new DaemonThread());
    // 데몬쓰레드로 설정
    th.setDaemon(true);
    // 쓰레드를 실행
    th.start();
```

```java
    // Runnable을 구현하는 DaemonThread클래스를 작성
    public class DaemonThread implements Runnable {

        // 무한루프안에서 0.5초씩 쉬면서 데몬쓰레드가 실행중입니다를 출력하도록 run()메소드를 작성
        @Override
        public void run() {
            while (true) {
                System.out.println("데몬 쓰레드가 실행중입니다.");

                try {
                    Thread.sleep(500);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break; //Exception발생시 while 문 빠찌도록 
                }
            }
        }

        public static void main(String[] args) {
            // Runnable을 구현하는 DaemonThread를 실행하기 위하여 Thread 생성
            Thread th = new Thread(new DaemonThread());
            // 데몬쓰레드로 설정
            th.setDaemon(true);
            // 쓰레드를 실행
            th.start();

            // 메인 쓰레드가 1초뒤에 종료되도록 설정. 
            // 데몬쓰레드는 다른 쓰레드가 모두 종료되면 자동종료.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }   
            System.out.println("메인 쓰레드가 종료됩니다. ");    
        }   
    }
```

# 람다식
> 람다식은 다른말로 익명 메소드라고도 함
