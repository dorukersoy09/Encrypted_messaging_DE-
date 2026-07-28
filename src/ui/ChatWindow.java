package ui;

import crypto.CryptoUtils;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import network.Client;

public class ChatWindow {

    public void show(Stage stage) {

        TextArea chatArea = new TextArea();
        chatArea.setEditable(false);

        TextField input = new TextField();
        input.setPromptText("Type message...");

        Button encryptBtn = new Button("Encrypt");
        Button decryptBtn = new Button("Decrypt");
        Button sendBtn = new Button("Send");

        Client client = new Client(msg -> {
            Platform.runLater(() -> {
                chatArea.appendText("SERVER: " + msg + "\n");
            });
        });

        encryptBtn.setOnAction(e -> {
            input.setText(CryptoUtils.encrypt(input.getText()));
        });

        decryptBtn.setOnAction(e -> {
            input.setText(CryptoUtils.decrypt(input.getText()));
        });

        sendBtn.setOnAction(e -> {

            String text = input.getText();

            chatArea.appendText("ME: " + text + "\n");

            client.send(text);

            input.clear();
        });

        VBox root = new VBox(
                10,
                chatArea,
                input,
                new VBox(5, encryptBtn, decryptBtn, sendBtn)
        );

        stage.setScene(new Scene(root, 500, 400));
        stage.setTitle("Chat Window");
        stage.show();
    }
}
