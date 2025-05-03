package threads;

import model.FuelSensor;
import model.ThrottleControl;

import javax.swing.*;
import java.util.Random;

public class CruiseControlThread implements Runnable {
    private double setSpeed;
    private double currentSpeed;
    private final ThrottleControl throttleControl;
    private final FuelSensor fuelSensor;
    
    public CruiseControlThread(double currentSpeed, ThrottleControl throttleControl, FuelSensor fuelSensor) {
        this.setSpeed = throttleControl.getEcu().getGUISetSpeed();
        this.currentSpeed = currentSpeed;
        this.throttleControl = throttleControl;
        this.fuelSensor = fuelSensor;
    }
    
    public void setThrottleControlSetSpeed() {
        throttleControl.setCurrentSpeed(currentSpeed);
    }
    
    public void getThrottleControlCurrentSpeed() {
        currentSpeed = throttleControl.getCurrentSpeed();
    }
    
    private double random(double min, double max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextDouble() * (max - min) + min;
    }
    
    @Override
    public void run() {
        while (true) {
            // Handbrake sensor
            if (throttleControl.isEmergencyStop()) {
                setSpeed = 0;
                throttleControl.getEcu().setGUISetSpeed(0);
                while (true) {
                    currentSpeed -= random(5, 10); // faster speed reduction than normal
                    
                    if (currentSpeed <= 0) {
                        currentSpeed = 0;
                    }
                    
                    throttleControl.setCurrentSpeed(currentSpeed);
                    throttleControl.getEcu().setGUICurrentSpeed(currentSpeed);
                    
                    if (currentSpeed <= 0) {
                        Thread.currentThread().interrupt(); // kill thread when speed is 0
                    }
                    try {
                        Thread.sleep(400); // Adjust speed every 0.4 seconds
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); // interrupt the thread if attempted to interrupt during sleep
                        break;
                    }
                }
                break;
            }
            
            // Fuel consumption
            if (currentSpeed > 0) {
                double fuelConsumption = currentSpeed * 0.01; // Example consumption rate
                fuelSensor.calculateFuelConsumption(fuelConsumption);
            }
            
            // Fuel check
            if (fuelSensor.getFuelLevel() <= 0) {
                setSpeed = 0;
            }
            
            // Mileage monitor
            double mileage = currentSpeed * 0.01; // Example mileage calculation
            throttleControl.getEcu().getMaintenanceNotifier().incrementMileage(mileage);
            
            // Cruise Control
            currentSpeed = throttleControl.getCurrentSpeed(); // In case the speed is changed elsewhere
            
            if (currentSpeed < setSpeed) {
                currentSpeed += random(0, 5);
            } else if (currentSpeed > setSpeed) {
                currentSpeed -= random(0, 5);
            } else {
                currentSpeed += random(-1, 0);
            }
            if (currentSpeed < 0) {
                currentSpeed = 0;
            }
            
            throttleControl.setCurrentSpeed(currentSpeed);
            throttleControl.getEcu().setGUICurrentSpeed(currentSpeed);
            
            if (setSpeed <= 0 && currentSpeed <= 0) {
                if (fuelSensor.getFuelLevel() <= 0) {
                    JOptionPane.showMessageDialog(null, "Fuel level is too low. Please refuel.");
                }
                Thread.currentThread().interrupt(); // kill thread when speed is 0
            }
            
            try {
                Thread.sleep(1000); // Adjust speed every second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // interrupt the thread if attempted to interrupt during sleep
                break;
            }
        }
    }
}
