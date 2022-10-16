package proyectoReto3.reto3.entities.dtos;

public class CompleteAndCancelled {
    private long completed;
    private long cancelled;

    public CompleteAndCancelled(long completed, long cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;

    }

    public long getCompleted() {
        return completed;
    }

    public void setCompleted(long completed) {
        this.completed = completed;
    }

    public long getCancelled() {
        return cancelled;
    }

    public void setCancelled(long cancelled) {
        this.cancelled = cancelled;
    }
}
