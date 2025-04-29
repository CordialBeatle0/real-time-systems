package events;

public class AccelerateButtonState {
    private final boolean pressed;
    
    public AccelerateButtonState(boolean pressed) {
        this.pressed = pressed;
    }
    
    public boolean isPressed() {
        return pressed;
    }
}
