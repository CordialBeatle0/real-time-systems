package threads;

import model.ACUnit;

public class ACTempThread implements Runnable {
    private boolean status;
    private double setTemperature;
    private double currentTemperature;
    private final ACUnit acUnit;
    
    public ACTempThread(boolean status, double setTemperature, double currentTemperature, ACUnit acUnit) {
        this.status = status;
        this.setTemperature = setTemperature;
        this.currentTemperature = currentTemperature;
        this.acUnit = acUnit;
    }
    
    private void getNewSetTemperature() {
        setTemperature = acUnit.getSetTemperature();
    }
    
    @Override
    public void run() {
        while (true) {
            status = acUnit.getStatus();
            if (!status) { // turn off ac display
                acUnit.getEcu().setGUISetTemp("");
                acUnit.getEcu().setGUICurrentTemp("");
                acUnit.setSetTemperature(25); // reset to default
                acUnit.setCurrentTemperature(25); // reset to default
                continue;
            } else {
                getNewSetTemperature();
            }
            
            if (currentTemperature < setTemperature) {
                currentTemperature += 0.2; // Increase temperature
                if (currentTemperature > setTemperature) {
                    currentTemperature = setTemperature;
                }
            } else if (currentTemperature > setTemperature) {
                currentTemperature -= 0.2; // Decrease temperature
                if (currentTemperature < setTemperature) {
                    currentTemperature = setTemperature;
                }
            }
            
            acUnit.getEcu().setGUICurrentTemp(String.valueOf(currentTemperature));
            acUnit.getEcu().setGUISetTemp(String.valueOf(setTemperature));
            
            acUnit.setCurrentTemperature(currentTemperature);
            acUnit.setSetTemperature(setTemperature);
            
            try {
                Thread.sleep(1000); // Adjust temperature every second
            } catch (InterruptedException e) {
                System.out.println("ACTempThread interrupted: " + e.getMessage());
                // Thread.currentThread().interrupt(); // interrupt the thread if attempted to interrupt during sleep
                // break;
            }
        }
    }
}
