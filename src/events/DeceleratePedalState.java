package events;

public class DeceleratePedalState {
    private final boolean pressed;
    
    public DeceleratePedalState(boolean pressed) {
        this.pressed = pressed;
    }
    
    public boolean isPressed() {
        return pressed;
    }
}
