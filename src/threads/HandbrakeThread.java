package threads;

import model.HandbrakeSensor;

public class HandbrakeThread implements Runnable {
    private boolean handbrakeStatus;
    private final HandbrakeSensor handbrakeSensor;
    
    public HandbrakeThread(boolean handbrakeStatus, HandbrakeSensor handbrakeSensor) {
        this.handbrakeStatus = handbrakeStatus;
        this.handbrakeSensor = handbrakeSensor;
    }
    
    @Override
    public void run() {
        while (true) {
            if (handbrakeStatus != handbrakeSensor.getHandbrakeStatus()) {
                handbrakeStatus = !handbrakeStatus; // Toggle
                handbrakeSensor.sendEmergencyStopNotification(handbrakeStatus);
            }
            
            try {
                Thread.sleep(1000); // Sleep for 1 second before checking again
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore the interrupted status
                break;
            }
        }
    }
}
