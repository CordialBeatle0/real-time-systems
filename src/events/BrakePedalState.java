package events;

public class BrakePedalState {
    private final boolean pressed;
    
    public BrakePedalState(boolean pressed) {
        this.pressed = pressed;
    }
    
    public boolean isPressed() {
        return pressed;
    }
}
