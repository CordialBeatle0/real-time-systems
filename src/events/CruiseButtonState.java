package events;

public class CruiseButtonState {
    private final boolean state;
    private final double speed;
    
    public CruiseButtonState(boolean state, double speed) {
        this.state = state;
        this.speed = speed;
    }
    
    public boolean getState() {
        return state;
    }
    
    public double getSpeed() {
        return speed;
    }
}
