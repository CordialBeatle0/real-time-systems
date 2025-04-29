package model;

public class CruiseControl {
    private boolean cruiseStatus;
    
    public CruiseControl(boolean cruiseStatus) {
        this.cruiseStatus = cruiseStatus;
    }
    
    public void setCruiseStatus(boolean cruiseStatus) {
        this.cruiseStatus = cruiseStatus;
    }
    
    public boolean isCruiseStatus() {
        return cruiseStatus;
    }
    
    public void start(double speed) {
        
    }
    
    public void stop() {
        
    }
    
    public void accelerate(double speed) {
        
    }
    
    public void decelerate(double speed) {
        
    }
}
