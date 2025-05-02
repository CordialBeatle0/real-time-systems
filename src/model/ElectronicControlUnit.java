package model;

import view.ElectronicControlUnitView;

public class ElectronicControlUnit {
    private final AcceleratePedal acceleratePedal;
    private final BrakePedal brakePedal;
    private final ACUnit acUnit;
    private final CruiseControl cruiseControl;
    private final FuelSensor fuelSensor;
    private final HandbrakeSensor handbrakeSensor;
    private final MaintenanceNotifier maintenanceNotifier;
    private final ThrottleControl throttleControl;
    private final ElectronicControlUnitView ecuView;
    
    public ElectronicControlUnit() {
        ecuView = new ElectronicControlUnitView();
        
        throttleControl = new ThrottleControl(0, this);
        acceleratePedal = new AcceleratePedal(throttleControl);
        brakePedal = new BrakePedal(throttleControl);
        acUnit = new ACUnit(false, 25, 25, this);
        cruiseControl = new CruiseControl(false, 0, this);
        fuelSensor = new FuelSensor(50, this);
        handbrakeSensor = new HandbrakeSensor(false, this);
        maintenanceNotifier = new MaintenanceNotifier(0, this);
        
        ecuView.setLocationRelativeTo(null);
        ecuView.setVisible(true);
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
    
    public ElectronicControlUnitView getEcuView() {
        return ecuView;
    }
    
    public void emergencyStop(boolean status) {
        throttleControl.setEmergencyStop(status);
        throttleControl.activateCruiseThread();
    }
    
    public void sendAdjustSpeedRequest() {
        throttleControl.activateCruiseThread();
    }
}
