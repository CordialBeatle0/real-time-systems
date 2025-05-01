package events;

public class ACTempButtons {
    private final boolean incrementButtonPressed;
    
    public ACTempButtons(boolean incrementButtonPressed) {
        this.incrementButtonPressed = incrementButtonPressed;
    }
    
    public boolean isIncrementButtonPressed() {
        return incrementButtonPressed;
    }
}
