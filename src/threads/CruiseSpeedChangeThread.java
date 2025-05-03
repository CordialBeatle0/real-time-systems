package threads;

import model.CruiseControl;

public class CruiseSpeedChangeThread implements Runnable {
    private boolean pressed;
    private boolean accelerate;
    private double setSpeed;
    private final CruiseControl cruiseControl;
    
    public CruiseSpeedChangeThread(boolean pressed, boolean accelerate, CruiseControl cruiseControl) {
        this.pressed = pressed;
        this.cruiseControl = cruiseControl;
        this.accelerate = accelerate;
        this.setSpeed = cruiseControl.getEcu().getGUISetSpeed();
    }
    
    @Override
    public void run() {
        while (pressed) {
            double setSpeed = cruiseControl.getEcu().getGUISetSpeed();
            if (accelerate) {
                setSpeed += 5;
            } else {
                setSpeed -= 5;
            }
            
            if (setSpeed < 0) {
                setSpeed = 0;
            }
            
            cruiseControl.getEcu().setGUISetSpeed(setSpeed);
            cruiseControl.setSetSpeed(setSpeed);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
