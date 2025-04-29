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
        
        ElectronicControlUnit ecu = new ElectronicControlUnit(
                new AcceleratePedal(0), new BrakePedal(0), new ACUnit(false, 0),
                new CruiseControl(false), new DrivingShaftSensor(0), new FuelSensor(0),
                new HandbrakeSensor(false), new MaintenanceNotifier(0), new ThrottleControl(0), true
        );
        
        Config.createStatement("select state from ACButtonState").setSubscriber(new Object() {
            public void update(boolean state) {
                ecu.getAcUnit().setStatus(state);
            }
        });
        
        Config.createStatement("select pressed from AccelerateButtonState").setSubscriber(new Object() {
            public void update(boolean state) {
                if (state) {
                    ecu.getCruiseControl().accelerate(0); // TODO: Change to a random or fixed number
                }
            }
        });
        
        Config.createStatement("select pressed from AcceleratePedalState").setSubscriber(new Object() {
            public void update(boolean state) {
                if (state) {
                    ecu.getAcceleratePedal().adjustSpeed(0); // TODO: Change to a random or fixed number
                }
            }
        });
        
        Config.createStatement("select pressed from BrakePedalState").setSubscriber(new Object() {
            public void update(boolean state) {
                if (state) {
                    ecu.getBrakePedal().adjustSpeed(0); // TODO: Change to a random or fixed number
                }
            }
        });
        
        Config.createStatement("select state from CruiseButtonState").setSubscriber(new Object() {
            public void update(boolean state) {
                ecu.getCruiseControl().setCruiseStatus(state);
            }
        });
        
        Config.createStatement("select pressed from DecelerateButtonState").setSubscriber(new Object() {
            public void update(boolean state) {
                if (state) {
                    ecu.getCruiseControl().decelerate(0); // TODO: Change to a random or fixed number
                }
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
    }
}
