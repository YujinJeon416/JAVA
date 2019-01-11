# Synchroneized란
> 자바에서 동기화란 여러 개의 스레드가 한개의 자원을 사용하고자 할 때 해당 스레드만 제외하고 나머지는 접근을 못하도록 막는 것이다.

- `synchronized`식별자를 통하여 구현한다.
- 변수와 함수에 사용하여 동기화 할 수 있다.

# 채팅 앱
## Thread
- `Thread[] thread = new Thread[10];`
- `threads[count] = new Thread(new Receiver(user, socket));`

메인 스레드를 10개의 스레드로 생성하고 유저가들어올때마다 thread를 다시 생성하는 개념?

- Thread pool을 사용하지 않은 것과 무슨 차이가 있을까?
- thread[count].start(): 정확히 start는 무슨 역활을 하는가?
- serverSocket.accept()의 return 값은?


## try ~ catch
- serverSocket = new ServerSocket(port); 할때 try~catch하는 이유
