package message;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class MessageListItem extends ListCell<Message> {
    @FXML
    private Label date;

    @FXML
    private Label message;

    @FXML
    private GridPane gridPane;

    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(Message chatMessage, boolean empty) {
        super.updateItem(chatMessage, empty);

        if(empty || chatMessage == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("MessageListItem.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            message.setText(String.valueOf(chatMessage.getText()));
            date.setText(String.valueOf(chatMessage.getTime()));

            setText(null);
            setGraphic(gridPane);
        }
    }
}
