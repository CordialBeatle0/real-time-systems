package model;

public class BrakePedal {
    private final ThrottleControl throttleControl;
    
    public BrakePedal(ThrottleControl throttleControl) {
        this.throttleControl = throttleControl;
    }
    
    public void decreaseSpeed(boolean state) {
        throttleControl.activatePedalThread(false, state);
    }
}
