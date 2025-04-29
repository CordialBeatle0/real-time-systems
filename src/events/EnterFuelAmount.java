package events;

public class EnterFuelAmount {
    private final double fuelAmount;
    
    public EnterFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }
    
    public double getFuelAmount() {
        return fuelAmount;
    }
}
