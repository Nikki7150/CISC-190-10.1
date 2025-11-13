package edu.sdccd.cisc;

//TODO: import javafx libraries
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.text.Font;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        // TODO: title

        // TODO: header
        Label header = new Label("Message Board");
        header.setFont(new Font(30));
        header.setStyle("-fx-font-weight: bold");
        header.setAlignment(Pos.CENTER);

        // TODO: status label
        Label status = new Label("Ready");

        // TODO: Input row: TextField + Add button
        TextField message = new TextField();
        message.setPromptText("Enter Message");

        // TODO: prompt for message
        Label prompt = new Label("Write your message: ");

        // TODO: add button
        Button addBtn = new Button("Add");

        // TODO: reset button
        Button resetBtn = new Button("Reset");

        // TODO: message history area
        TextArea messageLog = new TextArea();
        messageLog.setEditable(false);

        // TODO: Wire up the Add button.
        // - If input text is empty or blank: set status to "Nothing to add" and return.
        // - Otherwise: append text to history (one line per message),
        //              clear the input field,
        //              set status to "Last action: added message".

        addBtn.setOnAction(e -> {
            // TODO: implement
            if (message.getText().isBlank()) {
                status.setText("Nothing to Add.");
                message.setText("");
            }
            else {
                status.setText("Last Action: Added message");
                messageLog.appendText(message.getText() + "\n");
                message.setText("");
            }
        });

        // TODO: Wire up the Reset button.
        // - Clear history and input.
        // - Set status to "Cleared".
        resetBtn.setOnAction(e -> {
            // TODO: implement
            status.setText("Last Action: Reset");
            message.setText("");
            messageLog.setText("");
        });

        // TODO: add content to root
        HBox buttonBar = new HBox( 40, addBtn, resetBtn);
        buttonBar.setAlignment(Pos.CENTER);
        VBox topContainer = new VBox(20, header, status);
        VBox messagesBox =  new VBox(20, messageLog, prompt, message);
        messagesBox.setAlignment(Pos.CENTER);
        BorderPane root = new BorderPane();
        root.setTop(topContainer);
        root.setCenter(messagesBox);
        root.setBottom(buttonBar);

        // TODO: set scene and show stage
        Scene scene = new Scene(root, 450, 300);
        stage.setMinWidth(400);
        stage.setMinHeight(250);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Message Board");
    }

    public static void main(String[] args) {
        launch(args);
    }
}