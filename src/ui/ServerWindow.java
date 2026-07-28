package ui;

import crypto.CryptoUtils;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import network.Server;

public class ServerWindow {

    private Server server;

    public void show(Stage stage) {

        TextArea chatArea = new TextArea();
        chatArea.setEditable(false);

        TextField input = new TextField();

        Button sendBtn = new Button("Send");

        server = new Server(msg -> {
            Platform.runLater(() -> {
                String decrypted = CryptoUtils.decrypt(msg);
                chatArea.appendText("CLIENT: " + decrypted + "\n");
            });
        });

        sendBtn.setOnAction(e -> {

            String plaintext = input.getText();

            chatArea.appendText("ME: " + plaintext + "\n");

            String encrypted = CryptoUtils.encrypt(plaintext);

            server.send(encrypted);

            input.clear();
        });

        VBox root = new VBox(10, chatArea, input, sendBtn);

        stage.setScene(new Scene(root, 500, 400));
        stage.setTitle("Server");
        stage.show();
    }
}
