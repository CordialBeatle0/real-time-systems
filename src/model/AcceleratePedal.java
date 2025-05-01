package model;

public class AcceleratePedal {
    private final ThrottleControl throttleControl;
    
    public AcceleratePedal(ThrottleControl throttleControl) {
        this.throttleControl = throttleControl;
    }
    
    public void adjustSpeed(boolean state) {
        throttleControl.activatePedalThread(true, state);
    }
}
