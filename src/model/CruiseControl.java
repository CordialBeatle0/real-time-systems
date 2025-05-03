package model;

import threads.CruiseSpeedChangeThread;

public class CruiseControl {
    private boolean cruiseStatus;
    private double setSpeed;
    private final ElectronicControlUnit ecu;
    private Thread speedChangeThread;
    
    public CruiseControl(boolean cruiseStatus, double setSpeed, ElectronicControlUnit ecu) {
        this.cruiseStatus = cruiseStatus;
        this.setSpeed = setSpeed;
        this.ecu = ecu;
    }
    
    public void setCruiseStatus(boolean cruiseStatus) {
        this.cruiseStatus = cruiseStatus;
    }
    
    public void setSetSpeed(double setSpeed) {
        this.setSpeed = setSpeed;
    }
    
    public boolean isCruiseStatus() {
        return cruiseStatus;
    }
    
    public double getSetSpeed() {
        return setSpeed;
    }
    
    public ElectronicControlUnit getEcu() {
        return ecu;
    }
    
    public void start() {
        cruiseStatus = true;
        setSpeed = ecu.getGUISetSpeed();
        ecu.sendAdjustSpeedRequest();
    }
    
    public void stop() {
        cruiseStatus = false;
        setSpeed = 0;
        ecu.sendAdjustSpeedRequest();
    }
    
    public void accelerate(boolean pressed) {
        if (cruiseStatus) {
            if (speedChangeThread != null && speedChangeThread.isAlive()) {
                speedChangeThread.interrupt();
            }
            speedChangeThread = new Thread(new CruiseSpeedChangeThread(pressed, true, this));
            speedChangeThread.start();
            ecu.sendAdjustSpeedRequest();
        }
    }
    
    public void decelerate(boolean pressed) {
        if (cruiseStatus) {
            if (speedChangeThread != null && speedChangeThread.isAlive()) {
                speedChangeThread.interrupt();
            }
            speedChangeThread = new Thread(new CruiseSpeedChangeThread(pressed, false, this));
            speedChangeThread.start();
            ecu.sendAdjustSpeedRequest();
        }
    }
}
