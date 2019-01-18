package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class SessionThread extends Thread {
    private Socket socket;
    private List<SessionThread> sessions;

    public SessionThread(Socket socket, List<SessionThread> sessions) {
        this.socket = socket;
        this.sessions = sessions;
        this.sessions.add(this);
    }

    private void broadcast(String message) throws IOException {
        for (SessionThread e : sessions) {
            OutputStream os = e.socket.getOutputStream();
            os.write(message.getBytes());
        }
    }

    @Override
    public void run() {
        try (InputStream is = socket.getInputStream()) {

            while (true) {
                byte[] buf = new byte[512];
                int len = is.read(buf);
                if (len == -1) {
                    System.out.println("Disconnected");
                    break;
                }

                String message = new String(buf, 0, len);
                broadcast(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Thread 종료되었습니다.");
        sessions.remove(this);
    }
}


// Echo Server
public class Main {
    public static void main(String[] args) {
        List<SessionThread> sessions = new ArrayList<>();
        try {
            ServerSocket serverSocket = new ServerSocket(5000);

            while (true) {
                Socket socket = serverSocket.accept();
                SessionThread sessionThread = new SessionThread(socket, sessions);
                sessionThread.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}