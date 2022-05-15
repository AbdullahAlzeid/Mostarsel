package Models;

import java.time.LocalDateTime;

public class Message {
    private int ID;
    private String sender;
    private String receiver;
    private String messageType;
    private LocalDateTime sendDate;
    private boolean isRead;

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public LocalDateTime getSendDate() {
        return sendDate;
    }

    public void setSendDate(LocalDateTime sendDate) {
        this.sendDate = sendDate;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }

    @Override
    public String toString() {
        return "Message [ID=" + ID + ", isRead=" + isRead + ", messageType=" + messageType + ", receiver=" + receiver
                + ", sendDate=" + sendDate + ", sender=" + sender + "]";
    }

}
