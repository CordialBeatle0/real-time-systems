package model;

public class ACUnit {
    private boolean status;
    private double temperature;
    
    public ACUnit(boolean status, double temperature) {
        this.status = status;
        this.temperature = temperature;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    
    public boolean getStatus() {
        return status;
    }
    
    public double getTemperature() {
        return temperature;
    }
    
    public void start() {
        
    }
    
    public void stop() {
        
    }
    
    public void incrementTemperature() {
        
    }
    
    public void decrementTemperature() {
        
    }
}
