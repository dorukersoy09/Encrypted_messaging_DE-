package network;

import java.io.*;
import java.net.Socket;

public class Client {

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    private MessageListener listener;

    public interface MessageListener {
        void onMessage(String msg);
    }

    public Client(MessageListener listener) {
        this.listener = listener;

        try {
            socket = new Socket("localhost", 5001);

            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            startReceiver();

            System.out.println("Client connected");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send(String msg) {
        writer.println(msg);
    }

    private void startReceiver() {

        new Thread(() -> {
            try {
                String msg;

                while ((msg = reader.readLine()) != null) {
                    listener.onMessage(msg);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
