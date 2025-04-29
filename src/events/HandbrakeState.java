package events;

public class HandbrakeState {
    private final boolean pulled;
    
    public HandbrakeState(boolean pulled) {
        this.pulled = pulled;
    }
    
    public boolean isPulled() {
        return pulled;
    }
}
