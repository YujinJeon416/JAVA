[출처](https://dololak.tistory.com/67)
# 자바의 향상된 예외처리- TRY-WITH-RESOURCES

## IO Resource(입출력 자원)

> 프로그램은 os에서 자원을 할당 받아 동작한다. 자원은 한정되어있기에, 여러 프로그램에 공평하게 분배되어야 한다.
- `자원(resource)`: 연산을 담당하는 CPU, Main Mem, 보조기억 장치 등

- 자원들을 할당받기만 하고 반납해주지 않는다면 다른 프로그램은 자원을 사용하지 못한다. 이와 같은 현상 지속되면 starvation 현상이 발생하게 된다.
- 특히 IO resource에서 가장 문제가 많이 발생한다. 
- 입출력을 수행하기 위해서는 `스트림`이라 불리는 데이터 통로를 열어주어야 하는데, 이것이 IO Resource이다.


![](https://t1.daumcdn.net/cfile/tistory/998C2B4B5A3525C810)

자바에서는 `open()`, `close()`을 통해 입출력 자원 관리를 수행한다.

## 자바의 입출력 예외처리
> 그런데 입출력을 수행하는 도중 예외가 발생하는 경우는 어떻게 될까요?
입출력 도중 예외가 발생하게 될경우, exception을 처리하지 못했다면 입출력을 수행하던 `스트림`은 open 되어진 상태로 남겨지게 된다.
이와 같은 현상이 쌓이게 되면 메모리 부족현상이 생긴다.(`Memory Leak`)

**과거 IO exception handling**
```java
FileOutputStream out = null;
try {
    out = new FileOutputStream("exFile.txt");
    //...이후 입출력 로직 처리...
} catch (FileNotFoundException e) {
    e.printStackTrace();
} finally {
    
    if(out != null) { //스트림이 null인지 체크
        try {
            out.close(); //close 하다가 예외가 발생할 수 있다.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
open(), close()모두 exception 처리를 해주어 매우 복잡하게 보인다.

## 예외시 자원을 자동으로 닫아주는 try - with - resources 문

> 자바7 버전에서 `try - with - resources` 구문이 추가되었다.

- `try - with - resources` 구문을 사용하게 되면 입출력 처리시 예외가 발생하는 경우 JVM이 자동으로 close()를 호출하여 자원을 반납시켜준다.
- `try()` 안에 입출력 스트림을 생성하는 로직을 작성하는데 이때 해당 객체는 `AutoCloseable` 인터페이스를 구현한 객체여야함.

```java
try(FileOutputStream out = new FileOutputStream("exFile.txt")) { 
//...이후 입출력 로직 처리... 
}catch(IOException e){
e.printStackTrace(); 
}
```
![](https://t1.daumcdn.net/cfile/tistory/991C2F4B5A3525C623)
![](https://t1.daumcdn.net/cfile/tistory/99609A4B5A3525C718)


## AutoCloseable 인터페이스
try - with - resources 구문을 통해 자동 자원 반납을 지원하기 위해서는 해당 입출력 객체가 AutoCloseable 인터페이스를 구현해야 합니다.
그 이유는 AutoCloseable은 다음과 같이 정의되어 있는데 예외가 발생하면 JVM이 구현된 close() 메서드를 호출하기 때문입니다.

```java
public interface AutoCloseable {
    void close() throws Exception;
}
```








