import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import javafx.collections.ObservableList;
import message.Message;
import message.MessageListItem;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private Button sendButton;

    @FXML
    private TextField text;

    @FXML
    private ListView<Message> listView;

    private ObservableList<Message> chatMessageObservableList;


    public Controller() {
        chatMessageObservableList = FXCollections.observableArrayList();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.setItems(chatMessageObservableList);
        listView.setCellFactory(messageListView -> new MessageListItem());
    }

    @FXML
    private void stageKeyReleased(KeyEvent event) {
        if (event.getCode() != KeyCode.ENTER) return;

        addMessage();
    }

    @FXML
    private void sendButtonAction(ActionEvent event) {
        addMessage();
    }

    private void addMessage() {
        chatMessageObservableList.add(new Message(text.getText()));
        text.clear();
        checkButtonStatus();
    }

    @FXML
    private void textFieldKeyReleased(KeyEvent event) {
        checkButtonStatus();
    }

    private void checkButtonStatus() {
        String message = text.getText();
        sendButton.setDisable(message.length() == 0);
    }
}
