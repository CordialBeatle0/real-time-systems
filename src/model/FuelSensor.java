package model;

public class FuelSensor {
    private static final double MAX_CAPACITY = 0; // TODO: change to actual number
    private double fuelLevel;
    
    public FuelSensor(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }
    
    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }
    
    public double getFuelLevel() {
        return fuelLevel;
    }
    
    public void calculateFuelConsumption(double fuel) {
        
    }
    
    public void refuel(double fuel) {
        
    }
}
