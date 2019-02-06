package message;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
    private String text;
    private Date date;

    public Message(String text) {
        this.text = text;
        this.date = new Date();
    }

    public String getText() {
        return text;
    }

    String getTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(date);
    }
}
