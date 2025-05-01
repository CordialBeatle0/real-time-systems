package model;

import threads.HandbrakeThread;

public class HandbrakeSensor {
    private boolean handbrakeStatus;
    private ElectronicControlUnit ecu;
    
    public HandbrakeSensor(boolean handbrakeStatus, ElectronicControlUnit ecu) {
        this.handbrakeStatus = handbrakeStatus;
        this.ecu = ecu;
        new Thread(new HandbrakeThread(false, this)).start();
        
    }
    
    public void setHandbrakeStatus(boolean handbrakeStatus) {
        this.handbrakeStatus = handbrakeStatus;
    }
    
    public boolean getHandbrakeStatus() {
        return handbrakeStatus;
    }
    
    public void sendEmergencyStopNotification(boolean handbrakeStatus) {
        ecu.emergencyStop(handbrakeStatus);
    }
}
