package entities;

public class GuardTime {
    private Guard guard;
    private int time;

    public GuardTime(Guard guard, int time) {
        this.guard = guard;
        this.time = time;
    }

    public Guard getGuard() {
        return guard;
    }

    public void setGuard(Guard guard) {
        this.guard = guard;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    public void addTime(int time) {
        this.time += time;
    }
}
