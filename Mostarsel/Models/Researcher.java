package Models;

import java.time.LocalDateTime;

public class Researcher {
    private boolean isOnline;
    private LocalDateTime lastSeen;
    private LocalDateTime joinedDate;
    private LocalDateTime leftDate;
    private LocalDateTime beingOnline;

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public LocalDateTime getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(LocalDateTime lastSeen) {
        this.lastSeen = lastSeen;
    }

    public LocalDateTime getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDateTime joinedDate) {
        this.joinedDate = joinedDate;
    }

    public LocalDateTime getLeftDate() {
        return leftDate;
    }

    public void setLeftDate(LocalDateTime leftDate) {
        this.leftDate = leftDate;
    }

    public LocalDateTime getBeingOnline() {
        return beingOnline;
    }

    public void setBeingOnline(LocalDateTime beingOnline) {
        this.beingOnline = beingOnline;
    }

    @Override
    public String toString() {
        return "Researcher [beingOnline=" + beingOnline + ", isOnline=" + isOnline + ", joinedDate=" + joinedDate
                + ", lastSeen=" + lastSeen + ", leftDate=" + leftDate + "]";
    }

}
