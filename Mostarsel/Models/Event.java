package Models;

import java.time.LocalDateTime;

public class Event {
    private int ID;
    private User createdBy;
    private String eventType;
    private LocalDateTime createOn;

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public LocalDateTime getCreateOn() {
        return createOn;
    }

    public void setCreateOn(LocalDateTime createOn) {
        this.createOn = createOn;
    }

    @Override
    public String toString() {
        return "Event [ID=" + ID + ", createOn=" + createOn + ", createdBy=" + createdBy + ", eventType=" + eventType
                + "]";
    }

}
