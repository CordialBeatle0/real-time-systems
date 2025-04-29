package model;

public class HandbrakeSensor {
    private boolean handbrakeStatus;
    
    public HandbrakeSensor(boolean handbrakeStatus) {
        this.handbrakeStatus = handbrakeStatus;
    }
    
    public void setHandbrakeStatus(boolean handbrakeStatus) {
        this.handbrakeStatus = handbrakeStatus;
    }
    
    public boolean isHandbrakeStatus() {
        return handbrakeStatus;
    }
    
    public void detectHandbrake() {
        
    }
    
    public void sendEmergencyStopNotification() {
        
    }
}
