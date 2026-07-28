package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    public interface MessageListener {
        void onMessage(String msg);
    }

    public Server(MessageListener listener) {

        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(5001);
                System.out.println("Server waiting...");

                socket = serverSocket.accept();
                System.out.println("Client connected!");

                writer = new PrintWriter(socket.getOutputStream(), true);

                reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );

                String msg;

                while ((msg = reader.readLine()) != null) {
                    listener.onMessage(msg);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void send(String msg) {
        writer.println(msg);
    }
}
