package model;

import javax.swing.*;

public class MaintenanceNotifier {
    private double currentMileage;
    private static final int MILEAGE_REQUIRED_FOR_OIL = 10;
    private static final int MILEAGE_REQUIRED_FOR_AIR = 20;
    private static final int MILEAGE_REQUIRED_FOR_MAJOR_SERVICE = 30;
    private double lastOilFilterChangeMileage;
    private double lastAirFilterChangeMileage;
    private double lastMajorServiceMileage;
    private final ElectronicControlUnit ecu;
    
    public MaintenanceNotifier(int currentMileage, ElectronicControlUnit ecu) {
        this.currentMileage = currentMileage;
        this.ecu = ecu;
    }
    
    public void setCurrentMileage(double currentMileage) {
        this.currentMileage = currentMileage;
    }
    
    public void setLastOilFilterChangeMileage(double lastOilFilterChangeMileage) {
        this.lastOilFilterChangeMileage = lastOilFilterChangeMileage;
    }
    
    public void setLastAirFilterChangeMileage(double lastAirFilterChangeMileage) {
        this.lastAirFilterChangeMileage = lastAirFilterChangeMileage;
    }
    
    public void setLastMajorServiceMileage(double lastMajorServiceMileage) {
        this.lastMajorServiceMileage = lastMajorServiceMileage;
    }
    
    public double getCurrentMileage() {
        return currentMileage;
    }
    
    public double getLastOilFilterChangeMileage() {
        return lastOilFilterChangeMileage;
    }
    
    public double getLastAirFilterChangeMileage() {
        return lastAirFilterChangeMileage;
    }
    
    public double getLastMajorServiceMileage() {
        return lastMajorServiceMileage;
    }
    
    public void completeMaintenance(int selection) {
        switch (selection) {
            case 1:
                if (currentMileage - lastOilFilterChangeMileage < MILEAGE_REQUIRED_FOR_OIL) {
                    JOptionPane.showMessageDialog(null, "Not enough mileage for oil filter change");
                }
                lastOilFilterChangeMileage = currentMileage;
                ecu.getEcuView().getjCheckBoxOil().setSelected(false);
                ecu.getEcuView().getjButtonOilComplete().setEnabled(false);
                break;
            
            case 2:
                if (currentMileage - lastAirFilterChangeMileage < MILEAGE_REQUIRED_FOR_AIR) {
                    JOptionPane.showMessageDialog(null, "Not enough mileage for air filter change");
                }
                lastAirFilterChangeMileage = currentMileage;
                ecu.getEcuView().getjCheckBoxAir().setSelected(false);
                ecu.getEcuView().getjButtonAirComplete().setEnabled(false);
                break;
            
            case 3:
                if (currentMileage - lastMajorServiceMileage < MILEAGE_REQUIRED_FOR_MAJOR_SERVICE) {
                    JOptionPane.showMessageDialog(null, "Not enough mileage for major service");
                }
                lastMajorServiceMileage = currentMileage;
                ecu.getEcuView().getjCheckBoxMajor().setSelected(false);
                ecu.getEcuView().getjButtonMajorComplete().setEnabled(false);
                break;
            
            default:
                throw new IllegalArgumentException("Invalid maintenance selection");
        }
    }
    
    public void incrementMileage(double mileage) {
        currentMileage += mileage;
        ecu.getEcuView().getjTextFieldMileage().setText(String.valueOf(currentMileage));
        checkMaintenance();
    }
    
    private void checkMaintenance() {
        if (currentMileage - lastOilFilterChangeMileage >= MILEAGE_REQUIRED_FOR_OIL) {
            ecu.getEcuView().getjCheckBoxOil().setSelected(true);
            ecu.getEcuView().getjButtonOilComplete().setEnabled(true);
        }
        if (currentMileage - lastAirFilterChangeMileage >= MILEAGE_REQUIRED_FOR_AIR) {
            ecu.getEcuView().getjCheckBoxAir().setSelected(true);
            ecu.getEcuView().getjButtonAirComplete().setEnabled(true);
        }
        if (currentMileage - lastMajorServiceMileage >= MILEAGE_REQUIRED_FOR_MAJOR_SERVICE) {
            ecu.getEcuView().getjCheckBoxMajor().setSelected(true);
            ecu.getEcuView().getjButtonMajorComplete().setEnabled(true);
        }
    }
}
