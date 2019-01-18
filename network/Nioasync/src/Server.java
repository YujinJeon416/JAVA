import java.awt.*;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.List;
import java.util.Vector;

public class Server extends Application {

    AsynchronousChannelGroup channelGroup; //비동기 채널 그룹 필드 선언

    AsynchronousServerSocketChannel serverSocketChannel; // 비동기 서버소켓 채널 필드 선언

    List<Client> connections = new Vector<Client>(); // 연결된 클라이언트를 저장하는

//    List<Client> 타입의 connections필드선언하고 스레드에 안전한 Vector로 초기화


    void startServer() {

        try {

            channelGroup = AsynchronousChannelGroup.withFixedThreadPool(

                    Runtime.getRuntime().availableProcessors(),

                    Executors.defaultThreadFactory()

            );//CPU 코어 수만큼 스레드를 관리하는 스레드풀 생성,

            이것을 이용하는 비동기 채널 그룹 생성

            serverSocketChannel = AsynchronousServerSocketChannel.open(channelGroup);

            serverSocketChannel.bind(new InetSocketAddress(5001));

            //5001번 포트에서 클라이언트의 연결을 수락하는 비동기 서버 소켓 채널 생성

        } catch (Exception e) { // 5001포트가 이미 다른 곳에서 사용중이면 예외발생,

            이 경우 비동기서버소켓채널이 열려있느지 확인하고 stopServer () 호출

            if (serverSocketChannel.isOpen()) {
                stopServer();
            }

            return;

        }


        Platform.runLater(() -> {

            displayText("[서버 시작]");

            btnStartStop.setText("stop");

        });


        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {

            @Override

            public void completed(AsynchronousSocketChannel socketChannel, Void attachment) {

                try {

                    String message = "[연결 수락: " + socketChannel.getRemoteAddress() + ": " + Thread.currentThread().getName() + "]";

                    Platform.runLater(() -> displayText(message));

                } catch (IOException e) {
                }


                Client client = new Client(socketChannel);

                connections.add(client);// 클라이언트 객체 저장

                Platform.runLater(() -> displayText("[연결 개수: " + connections.size() + "]"));// 연결 수락 작업을 위한 accept() 메서드


                serverSocketChannel.accept(null, this);//accept() 메서드 호출

            }

            @Override

            public void failed(Throwable exc, Void attachment) { // 실패할 경우

                if (serverSocketChannel.isOpen()) {
                    stopServer();
                }

            }

        });


    }


    void stopServer() {

        try {

            connections.clear(); // connections 컬렉션에 저장되어 있는 모든 Client 제거

            if (channelGroup != null && !channelGroup.isShutdown()) {

                channelGroup.shutdownNow();

            }

            Platform.runLater(() -> {

                displayText("[서버 멈춤]");

                btnStartStop.setText("start");

            });

        } catch (Exception e) {
        }


    }

    class Client {

        AsynchronousSocketChannel socketChannel;

//비동기 소켓 채널 필드 선언.

        Client(AsynchronousSocketChannel socketChannel) {

            this.socketChannel = socketChannel;

            receive(); // 매개값으로 AsynchronousSocketChannel 필드 초기화 후,receive() 호출
        }


        void receive() { }


        void send(String data) { }

    }

    void receive() {

        ByteBuffer byteBuffer = ByteBuffer.allocate(100);



//read() 호출

        socketChannel.read(byteBuffer, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() {

            @Override

            public void completed(Integer result, ByteBuffer attachment) {

                try {

                    String message = "[요청 처리: " + socketChannel.getRemoteAddress() + ": " + Thread.currentThread().getName() + "]";

                    Platform.runLater(()->displayText(message));


                    attachment.flip();

                    Charset charset = Charset.forName("utf-8");

                    String data = charset.decode(attachment).toString();

//문자열 변환

                    for(Client client : connections) {

                        client.send(data);

                    } // 모든 클라이언트에게 보내기


                    ByteBuffer byteBuffer = ByteBuffer.allocate(100);

                    socketChannel.read(byteBuffer, byteBuffer, this);

//다시 데이터 읽기

                } catch(Exception e) {}

            }

            @Override //읽기 작업 실패시 콜백되는 failed() 메서드 재정의

            public void failed(Throwable exc, ByteBuffer attachment) {

                try {

                    String message = "[클라이언트 통신 안됨: " + socketChannel.getRemoteAddress() + ": " + Thread.currentThread().getName() + "]";

                    Platform.runLater(()->displayText(message));

                    connections.remove(Client.this);

                    socketChannel.close();

                } catch (IOException e) {}

            }

        });

    }

    void send(String data) {

        Charset charset = Charset.forName("utf-8");

        ByteBuffer byteBuffer = charset.encode(data);

//        write() 호출

        socketChannel.write(byteBuffer, null, new CompletionHandler<Integer, Void>() {

            @Override

            public void completed(Integer result, Void attachment) {

            }

            @Override

            public void failed(Throwable exc, Void attachment) {

                try {

                    String message = "[클라이언트 통신 안됨: " + socketChannel.getRemoteAddress() + ": " + Thread.currentThread().getName() + "]";

                    Platform.runLater(()->displayText(message));

                    connections.remove(Client.this);

                    socketChannel.close();

                } catch (IOException e) {}

            }

        });

    }

    //UI/////////////////////////////////////////



    TextArea txtDisplay;

    Button btnStartStop;


    @Override

    public void start(Stage primaryStage) throws Exception {

        BorderPane root = new BorderPane();

        root.setPrefSize(500, 300);


        txtDisplay = new TextArea();

        txtDisplay.setEditable(false);

        BorderPane.setMargin(txtDisplay, new Insets(0, 0, 2, 0));

        root.setCenter(txtDisplay);


        btnStartStop = new Button("start");

        btnStartStop.setPrefHeight(30);

        btnStartStop.setMaxWidth(Double.MAX_VALUE);

        btnStartStop.setOnAction(e -> {

            if (btnStartStop.getText().equals("start")) {

                startServer();

            } else if (btnStartStop.getText().equals("stop")) {

                stopServer();

            }

        });

        root.setBottom(btnStartStop);


        Scene scene = new Scene(root);

        scene.getStylesheets().add(getClass().getResource("app.css").toString());

        primaryStage.setScene(scene);

        primaryStage.setTitle("Server");

        primaryStage.setOnCloseRequest(event -> stopServer());

        primaryStage.show();

    }

    void displayText(String text) {

        txtDisplay.appendText(text + "\n");

    }

    public static void main(String[] args) {

        launch(args);


    }

}