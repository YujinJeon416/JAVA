public class Client extends Application {

    AsynchronousChannelGroup channelGroup; // 비동기 채널 그룹 필드 선언

    AsynchronousSocketChannel socketChannel; // 비동기 소켓 채널 필드 선언


    void startClient() {

        try {

            channelGroup = AsynchronousChannelGroup.withFixedThreadPool(

                    Runtime.getRuntime().availableProcessors(),

                    Executors.defaultThreadFactory()

            ); // CPU 코어 수만큼 스레드를 관리하는 스레드풀 생성하고 이것을 이용하느

            비동기 채널 그룹 생성.

            socketChannel = AsynchronousSocketChannel.open(channelGroup);

            //비동기 소켓 채널 생성.

            socketChannel.connect(new InetSocketAddress("localhost", 5001), null, new CompletionHandler<Void, Void>() {

                @Override

                public void completed(Void result, Void attachment) {

                    Platform.runLater(()->{

                        try {

                            displayText("[연결 완료: "  + socketChannel.getRemoteAddress() + "]");

                            btnConn.setText("stop");

                            btnSend.setDisable(false);

                        } catch (Exception e) {}

                    });

                    receive(); // 서버에서 보낸 데이터 받기

                }

                @Override

                public void failed(Throwable e, Void attachment) {

                    Platform.runLater(()->displayText("[서버 통신 안됨]"));

                    if(socketChannel.isOpen()) { stopClient(); }

                }

            });

        } catch (IOException e) {}



    }

        void stopClient() {//연결 끊기 코드 }


            void receive() {//데이터 받기 코드}


                void send(String data) {//데이터 쓰기 코드}