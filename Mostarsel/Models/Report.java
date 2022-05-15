package Models;

import java.time.LocalDateTime;

public class Report {
    private int ID;
    private String name;
    private String content;
    private LocalDateTime createdOn;

    public Report() {
    }

    public int getID() {
        return ID;
    }

    public Report(int iD, String name, String content, LocalDateTime createdOn) {
        ID = iD;
        this.name = name;
        this.content = content;
        this.createdOn = createdOn;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

}
