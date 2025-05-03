package esper;

import model.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        
        // Disable logging
        Logger.getRootLogger().setLevel(Level.OFF);
        
        // Register events
        Config.registerEvents();
        
        ElectronicControlUnit ecu = new ElectronicControlUnit();
        
        Config.createStatement("select state from ACButtonState").setSubscriber(new Object() {
            public void update(boolean state) {
                ecu.getAcUnit().setStatus(state);
            }
        });
        
        Config.createStatement("select pressed from AccelerateButtonState").setSubscriber(new Object() {
            public void update(boolean state) {
                ecu.getCruiseControl().accelerate(state);
            }
        });
        
        Config.createStatement("select pressed from AcceleratePedalState").setSubscriber(new Object() {
            public void update(boolean state) {
                ecu.getAcceleratePedal().increaseSpeed(state);
            }
        });
        
        Config.createStatement("select pressed from DeceleratePedalState").setSubscriber(new Object() {
            public void update(boolean state) {
                ecu.getBrakePedal().decreaseSpeed(state);
            }
        });
        
        Config.createStatement("select state, speed from CruiseButtonState").setSubscriber(new Object() {
            public void update(boolean state, double speed) {
                if (state) {
                    ecu.getCruiseControl().start();
                } else {
                    ecu.getCruiseControl().stop();
                }
            }
        });
        
        Config.createStatement("select pressed from DecelerateButtonState").setSubscriber(new Object() {
            public void update(boolean state) {
                ecu.getCruiseControl().decelerate(state);
            }
        });
        
        Config.createStatement("select fuelAmount from EnterFuelAmount").setSubscriber(new Object() {
            public void update(double fuelAmount) {
                ecu.getFuelSensor().refuel(fuelAmount);
            }
        });
        
        Config.createStatement("select pulled from HandbrakeState").setSubscriber(new Object() {
            public void update(boolean state) {
                ecu.getHandbrakeSensor().setHandbrakeStatus(state);
            }
        });
        
        Config.createStatement("select incrementButtonPressed from ACTempButtons").setSubscriber(new Object() {
            public void update(boolean state) {
                if (state) {
                    ecu.getAcUnit().incrementTemperature();
                } else {
                    ecu.getAcUnit().decrementTemperature();
                }
            }
        });
        
        Config.createStatement("select selection from MaintenanceCompletion").setSubscriber(new Object() {
            public void update(int selection) {
                ecu.getMaintenanceNotifier().completeMaintenance(selection);
            }
        });
    }
}
