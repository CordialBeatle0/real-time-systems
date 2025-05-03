package threads;

import model.FuelSensor;
import model.ThrottleControl;

import javax.swing.*;
import java.util.Random;

public class PedalThread implements Runnable {
    private boolean accelerate;
    private boolean pressed;
    private double currentSpeed;
    private final FuelSensor fuelSensor;
    private final ThrottleControl throttleControl;
    
    public PedalThread(boolean accelerate, boolean pressed, double currentSpeed, FuelSensor fuelSensor, ThrottleControl throttleControl) {
        this.accelerate = accelerate;
        this.pressed = pressed;
        this.currentSpeed = currentSpeed;
        this.fuelSensor = fuelSensor;
        this.throttleControl = throttleControl;
    }
    
    public void setAccelerate(boolean accelerate) {
        this.accelerate = accelerate;
    }
    
    public boolean isAccelerate() {
        return accelerate;
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
            // Fuel consumption
            if (currentSpeed > 0) {
                double fuelConsumption = currentSpeed * 0.01; // Example consumption rate
                fuelSensor.calculateFuelConsumption(fuelConsumption);
            }
            
            // Fuel check
            if (fuelSensor.getFuelLevel() <= 0) {
                pressed = false;
                accelerate = false;
            }
            
            // Mileage monitor
            double mileage = currentSpeed * 0.01; // Example mileage calculation
            throttleControl.getEcu().getMaintenanceNotifier().incrementMileage(mileage);
            
            currentSpeed = throttleControl.getCurrentSpeed();
            
            if (pressed) {
                if (accelerate) {
                    currentSpeed += random(0, 5);
                } else {
                    currentSpeed -= random(0, 5);
                }
            } else { // if no pedal pressed
                currentSpeed -= random(0, 3); // decelerate slower
            }
            
            if (currentSpeed < 0) {
                currentSpeed = 0;
            }
            
            throttleControl.setCurrentSpeed(currentSpeed);
            throttleControl.getEcu().setGUICurrentSpeed(currentSpeed);
            
            if (!accelerate && currentSpeed <= 0) {
                if (fuelSensor.getFuelLevel() <= 0) {
                    JOptionPane.showMessageDialog(null, "Fuel level is too low. Please refuel.");
                }
                Thread.currentThread().interrupt(); // kill thread when decelerating and speed is 0
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
