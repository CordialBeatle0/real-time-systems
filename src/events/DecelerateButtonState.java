package events;

public class DecelerateButtonState {
    private final boolean pressed;
    
    public DecelerateButtonState(boolean pressed) {
        this.pressed = pressed;
    }
    
    public boolean isPressed() {
        return pressed;
    }
}
