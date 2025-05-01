package model;

import threads.CruiseControlThread;
import threads.PedalThread;

public class ThrottleControl {
    private boolean emergencyStop;
    private double currentSpeed;
    private final ElectronicControlUnit ecu;
    private Thread cruiseThread;
    private Thread pedalThread;
    
    public ThrottleControl(double currentSpeed, ElectronicControlUnit ecu) {
        this.emergencyStop = false;
        this.currentSpeed = currentSpeed;
        this.ecu = ecu;
    }
    
    public void setEmergencyStop(boolean emergencyStop) {
        this.emergencyStop = emergencyStop;
    }
    
    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
    
    public boolean isEmergencyStop() {
        return emergencyStop;
    }
    
    public double getCurrentSpeed() {
        return currentSpeed;
    }
    
    public ElectronicControlUnit getEcu() {
        return ecu;
    }
    
    public void activateCruiseThread() {
        // stop the pedal thread if it's running
        if (pedalThread != null && pedalThread.isAlive()) {
            pedalThread.interrupt();
        }
        // stop the cruise thread if it's running
        if (cruiseThread != null && cruiseThread.isAlive()) {
            cruiseThread.interrupt();
        }
        
        cruiseThread = new Thread(new CruiseControlThread(currentSpeed, this, ecu.getFuelSensor()));
        cruiseThread.start();
    }
    
    public void activatePedalThread(boolean isAccelerate, boolean pressed) {
        // stop the cruise thread if it's running
        if (cruiseThread != null && cruiseThread.isAlive()) {
            cruiseThread.interrupt();
        }
        // stop the pedal thread if it's running
        if (pedalThread != null && pedalThread.isAlive()) {
            pedalThread.interrupt();
        }
        
        pedalThread = new Thread(new PedalThread(isAccelerate, pressed, currentSpeed, ecu.getFuelSensor(), this));
        pedalThread.start();
    }
}
