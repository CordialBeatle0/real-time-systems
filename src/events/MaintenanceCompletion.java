package events;

public class MaintenanceCompletion {
    private final int selection;
    
    public MaintenanceCompletion(int selection) {
        this.selection = selection;
    }
    
    public int getSelection() {
        return selection;
    }
}
