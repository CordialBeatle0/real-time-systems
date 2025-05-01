package model;

import threads.ACTempThread;

public class ACUnit {
    private boolean status;
    private double setTemperature;
    private double currentTemperature;
    private final Thread acTempThread;
    private final ElectronicControlUnit ecu;
    
    public ACUnit(boolean status, double setTemperature, double currentTemperature, ElectronicControlUnit ecu) {
        this.status = status;
        this.setTemperature = setTemperature;
        this.currentTemperature = currentTemperature;
        this.ecu = ecu;
        acTempThread = new Thread(new ACTempThread(status, setTemperature, currentTemperature, this));
        acTempThread.start();
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public void setSetTemperature(double setTemperature) {
        this.setTemperature = setTemperature;
    }
    
    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }
    
    public boolean getStatus() {
        return status;
    }
    
    public double getSetTemperature() {
        return setTemperature;
    }
    
    public ElectronicControlUnit getEcu() {
        return ecu;
    }
    
    public void incrementTemperature() {
        if (status) {
            setTemperature += 1.0;
            ecu.getEcuView().getjTextFieldSetTemp().setText(String.valueOf(setTemperature));
        }
    }
    
    public void decrementTemperature() {
        if (status) {
            setTemperature -= 1.0;
            ecu.getEcuView().getjTextFieldSetTemp().setText(String.valueOf(setTemperature));
        }
    }
}
