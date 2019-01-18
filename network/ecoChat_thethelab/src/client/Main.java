package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

// Processing => GUI(Client) => 산성비
// Server(1초에 한개씩 연결된 클라이언트에게 단어를 전달한다.)

// Clean Code
//  : 로버트 C 마틴(엉클 밥)

// 최소 지식의 원칙: 디미터의 법칙
// => 객체를 설계할 때, 최소한의 필요한 정보만 전달 받는 것이 좋다.
class ReceiveThread extends Thread {
    private InputStream is;

    ReceiveThread(InputStream is) {
        this.is = is;
    }

    @Override
    public void run() {
        byte[] buf = new byte[512];
        try {
            while (true) {
                int len = is.read(buf);
                if (len == -1) {
                    break;
                }

                System.out.println("From server: " + new String(buf, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Socket socket = new Socket("127.0.0.1", 5000);

            ReceiveThread receiveThread = new ReceiveThread(socket.getInputStream());
            receiveThread.start();

            try (OutputStream os = socket.getOutputStream()) {
                while (scanner.hasNext()) {
                    String line = scanner.next();
                    os.write(line.getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}