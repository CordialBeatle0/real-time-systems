package model;

public class ElectronicControlUnit {
    private AcceleratePedal acceleratePedal;
    private BrakePedal brakePedal;
    private ACUnit acUnit;
    private CruiseControl cruiseControl;
    private DrivingShaftSensor drivingShaftSensor;
    private FuelSensor fuelSensor;
    private HandbrakeSensor handbrakeSensor;
    private MaintenanceNotifier maintenanceNotifier;
    private ThrottleControl throttleControl;
    private boolean engineState;
    
    public ElectronicControlUnit(AcceleratePedal acceleratePedal, BrakePedal brakePedal, ACUnit acUnit, CruiseControl cruiseControl,
                                 DrivingShaftSensor drivingShaftSensor, FuelSensor fuelSensor, HandbrakeSensor handbrakeSensor,
                                 MaintenanceNotifier maintenanceNotifier, ThrottleControl throttleControl, boolean engineState) {
        this.acceleratePedal = acceleratePedal;
        this.brakePedal = brakePedal;
        this.acUnit = acUnit;
        this.cruiseControl = cruiseControl;
        this.drivingShaftSensor = drivingShaftSensor;
        this.fuelSensor = fuelSensor;
        this.handbrakeSensor = handbrakeSensor;
        this.maintenanceNotifier = maintenanceNotifier;
        this.throttleControl = throttleControl;
        this.engineState = engineState;
    }
    
    public void setEngineState(boolean engineState) {
        this.engineState = engineState;
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
    
    public boolean getEngineState() {
        return engineState;
    }
    
    public void start() {
        
    }
    
    public void stop() {
        
    }
    
    public void emergencyStop() {
        
    }
}
