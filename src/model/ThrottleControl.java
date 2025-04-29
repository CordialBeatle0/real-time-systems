package model;

public class ThrottleControl {
    private double currentSpeed;
    
    public ThrottleControl(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
    
    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
    
    public double getCurrentSpeed() {
        return currentSpeed;
    }
    
    public void adjustSpeed(double speed) {
        
    }
}
