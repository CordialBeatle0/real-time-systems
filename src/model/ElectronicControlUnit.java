package model;

public class ElectronicControlUnit {
    private final AcceleratePedal acceleratePedal;
    private final BrakePedal brakePedal;
    private final ACUnit acUnit;
    private final CruiseControl cruiseControl;
    private final FuelSensor fuelSensor;
    private final HandbrakeSensor handbrakeSensor;
    private final MaintenanceNotifier maintenanceNotifier;
    private final ThrottleControl throttleControl;
    private final DashboardDisplay display;
    
    public ElectronicControlUnit() {
        display = new DashboardDisplay();
        throttleControl = new ThrottleControl(0, this);
        acceleratePedal = new AcceleratePedal(throttleControl);
        brakePedal = new BrakePedal(throttleControl);
        acUnit = new ACUnit(false, 25, 25, this);
        cruiseControl = new CruiseControl(false, 0, this);
        fuelSensor = new FuelSensor(50, this);
        handbrakeSensor = new HandbrakeSensor(false, this);
        maintenanceNotifier = new MaintenanceNotifier(0, this);
    }
    
    public AcceleratePedal getAcceleratePedal() {
        return acceleratePedal;
    }
    
    public BrakePedal getBrakePedal() {
        return brakePedal;
    }
    
    public ACUnit getAcUnit() {
        return acUnit;
    }
    
    public CruiseControl getCruiseControl() {
        return cruiseControl;
    }
    
    public FuelSensor getFuelSensor() {
        return fuelSensor;
    }
    
    public HandbrakeSensor getHandbrakeSensor() {
        return handbrakeSensor;
    }
    
    public MaintenanceNotifier getMaintenanceNotifier() {
        return maintenanceNotifier;
    }
    
    public ThrottleControl getThrottleControl() {
        return throttleControl;
    }
    
    public void emergencyStop(boolean status) {
        throttleControl.setEmergencyStop(status);
        if (status) {
            throttleControl.activateCruiseThread();
        }
    }
    
    public void sendAdjustSpeedRequest() {
        throttleControl.activateCruiseThread();
    }
    
    public void setGUIFuelLevel(double fuelLevel) {
        display.setFuelLevel(fuelLevel);
    }
    
    public void setGUIMaintenanceCheckbox(int selection, boolean state) {
        display.setMaintenanceCheckbox(selection, state);
    }
    
    public void setGUIMileage(double mileage) {
        display.setMileage(mileage);
    }
    
    public void setGUISetTemp(String temp) {
        display.setSetTemp(temp);
    }
    
    public void setGUICurrentTemp(String temp) {
        display.setCurrentTemp(temp);
    }
    
    public void setGUISetSpeed(double speed) {
        display.setSetSpeed(speed);
    }
    
    public double getGUISetSpeed() {
        return display.getSetSpeed();
    }
    
    public void setGUICurrentSpeed(double speed) {
        display.setCurrentSpeed(speed);
    }
}
