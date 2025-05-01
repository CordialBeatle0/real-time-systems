package threads;

import model.CruiseControl;

import javax.swing.*;

public class CruiseSpeedChangeThread implements Runnable {
    private boolean pressed;
    private boolean accelerate;
    private final JTextField setSpeedField;
    private final CruiseControl cruiseControl;
    
    public CruiseSpeedChangeThread(boolean pressed, boolean accelerate, CruiseControl cruiseControl) {
        this.pressed = pressed;
        this.cruiseControl = cruiseControl;
        this.accelerate = accelerate;
        this.setSpeedField = cruiseControl.getEcu().getEcuView().getjTextFieldSetSpeed();
    }
    
    @Override
    public void run() {
        while (pressed) {
            double setSpeed = Double.parseDouble(setSpeedField.getText());
            if (accelerate) {
                setSpeed += 5;
            } else {
                setSpeed -= 5;
            }
            
            if (setSpeed < 0) {
                setSpeed = 0;
            }
            
            setSpeedField.setText(setSpeed + "");
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
