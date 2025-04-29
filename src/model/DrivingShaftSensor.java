package model;

public class DrivingShaftSensor {
    private int pulsesPerMinute;
    
    public DrivingShaftSensor(int pulsesPerMinute) {
        this.pulsesPerMinute = pulsesPerMinute;
    }
    
    public void setPulsesPerMinute(int pulsesPerMinute) {
        this.pulsesPerMinute = pulsesPerMinute;
    }
    
    public int getPulsesPerMinute() {
        return pulsesPerMinute;
    }
    
    public void measureShaftPulses() {
        
    }
    
    public void adjustRPM(double rpm) {
        
    }
    
    public void sendMileageIncrementNotification() {
        
    }
}
