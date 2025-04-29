package model;

public class MaintenanceNotifier {
    private int currentMileage;
    private static final int MILEAGE_REQUIRED_FOR_OIL = 0; // TODO: change to an actual number
    private static final int MILEAGE_REQUIRED_FOR_AIR = 0; // TODO: change to an actual number
    private static final int MILEAGE_REQUIRED_FOR_MAJOR_SERVICE = 0; // TODO: change to an actual number
    private int lastOilFilterChangeMileage;
    private int lastAirFilterChangeMileage;
    private int lastMajorServiceMileage;
    
    public MaintenanceNotifier(int currentMileage) {
        this.currentMileage = currentMileage;
    }
    
    public void setCurrentMileage(int currentMileage) {
        this.currentMileage = currentMileage;
    }
    
    public void setLastOilFilterChangeMileage(int lastOilFilterChangeMileage) {
        this.lastOilFilterChangeMileage = lastOilFilterChangeMileage;
    }
    
    public void setLastAirFilterChangeMileage(int lastAirFilterChangeMileage) {
        this.lastAirFilterChangeMileage = lastAirFilterChangeMileage;
    }
    
    public void setLastMajorServiceMileage(int lastMajorServiceMileage) {
        this.lastMajorServiceMileage = lastMajorServiceMileage;
    }
    
    public int getCurrentMileage() {
        return currentMileage;
    }
    
    public int getLastOilFilterChangeMileage() {
        return lastOilFilterChangeMileage;
    }
    
    public int getLastAirFilterChangeMileage() {
        return lastAirFilterChangeMileage;
    }
    
    public int getLastMajorServiceMileage() {
        return lastMajorServiceMileage;
    }
    
    public void sendOilFilterChangeNotification() {
        
    }
    
    public void sendAirFilterChangeNotification() {
        
    }
    
    public void sendMajorServiceNotification() {
        
    }
    
    public void incrementMileage() {
        
    }
}
