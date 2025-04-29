package events;

public class AcceleratePedalState {
    private final boolean pressed;
    
    public AcceleratePedalState(boolean pressed) {
        this.pressed = pressed;
    }
    
    public boolean isPressed() {
        return pressed;
    }
}
