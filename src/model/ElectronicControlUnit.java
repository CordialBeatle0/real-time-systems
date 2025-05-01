package model;

import view.ElectronicControlUnitView;

public class ElectronicControlUnit {
    private final AcceleratePedal acceleratePedal;
    private final BrakePedal brakePedal;
    private final ACUnit acUnit;
    private final CruiseControl cruiseControl;
    private final DrivingShaftSensor drivingShaftSensor;
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
        drivingShaftSensor = new DrivingShaftSensor(0);
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
    
    public DrivingShaftSensor getDrivingShaftSensor() {
        return drivingShaftSensor;
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
    
    public void sendSpeedInfo(double speed) {
        
    }
    
    public void sendRPMInfo(double RPM) {
        
    }
    
    public void sendFuelLevelInfo(double fuelLevel) {
        
    }
    
    public void sendHandbrakeStatusInfo(boolean status) {
        
    }
    
    public void sendOilFilterChangeInfo(boolean status) {
        
    }
    
    public void sendAirFilterChangeInfo(boolean status) {
        
    }
    
    public void sendMajorServiceInfo(boolean status) {
        
    }
    
    public void sendMileageInfo(int mileage) {
        
    }
    
    public void sendCruiseControlInfo(boolean status) {
        
    }
    
    public void sendTemperatureInfo(double temp) {
        
    }
}
