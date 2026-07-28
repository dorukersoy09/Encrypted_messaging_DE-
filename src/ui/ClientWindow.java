package ui;

import crypto.CryptoUtils;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import network.Client;

public class ClientWindow {

    private Client client;

    public void show(Stage stage) {

        TextArea chatArea = new TextArea();
        chatArea.setEditable(false);

        TextField input = new TextField();

        Button sendBtn = new Button("Send");

        client = new Client(msg -> {
            Platform.runLater(() -> {
                String decrypted = CryptoUtils.decrypt(msg);
                chatArea.appendText("SERVER: " + decrypted + "\n");
            });
        });

        sendBtn.setOnAction(e -> {

            String plaintext = input.getText();

            chatArea.appendText("ME: " + plaintext + "\n");

            String encrypted = CryptoUtils.encrypt(plaintext);

            client.send(encrypted);

            input.clear();
        });

        VBox root = new VBox(10, chatArea, input, sendBtn);

        stage.setScene(new Scene(root, 500, 400));
        stage.setTitle("Client");
        stage.show();
    }
}
