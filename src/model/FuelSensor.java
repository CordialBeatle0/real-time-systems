package model;

public class FuelSensor {
    private static final double MAX_CAPACITY = 100;
    private double fuelLevel;
    private ElectronicControlUnit ecu;
    
    public FuelSensor(double fuelLevel, ElectronicControlUnit ecu) {
        this.fuelLevel = fuelLevel;
        this.ecu = ecu;
    }
    
    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }
    
    public double getFuelLevel() {
        return fuelLevel;
    }
    
    public void calculateFuelConsumption(double fuel) {
        fuelLevel -= fuel;
        if (fuelLevel < 0) {
            fuelLevel = 0;
        }
        ecu.getEcuView().getjTextFieldFuel().setText(String.valueOf(fuelLevel));
    }
    
    public void refuel(double fuel) {
        if (fuelLevel + fuel <= MAX_CAPACITY) {
            fuelLevel += fuel;
        } else {
            throw new IllegalArgumentException("Cannot refuel beyond maximum capacity of: " + MAX_CAPACITY);
        }
    }
}
