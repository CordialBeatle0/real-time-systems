package esper;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import events.*;

public class Config {
    private static final EPServiceProvider engine = EPServiceProviderManager.getDefaultProvider();
    
    public static void registerEvents() {
        try {
            engine.getEPAdministrator().getConfiguration().addEventType(ACButtonState.class);
            engine.getEPAdministrator().getConfiguration().addEventType(AccelerateButtonState.class);
            engine.getEPAdministrator().getConfiguration().addEventType(AcceleratePedalState.class);
            engine.getEPAdministrator().getConfiguration().addEventType(DeceleratePedalState.class);
            engine.getEPAdministrator().getConfiguration().addEventType(CruiseButtonState.class);
            engine.getEPAdministrator().getConfiguration().addEventType(DecelerateButtonState.class);
            engine.getEPAdministrator().getConfiguration().addEventType(EnterFuelAmount.class);
            engine.getEPAdministrator().getConfiguration().addEventType(HandbrakeState.class);
            engine.getEPAdministrator().getConfiguration().addEventType(ACTempButtons.class);
            engine.getEPAdministrator().getConfiguration().addEventType(MaintenanceCompletion.class);
            System.out.println("Events Successfully Registered.");
        } catch (Exception e) {
            System.out.println("Error registering events: " + e.getMessage());
        }
    }
    
    public static EPStatement createStatement(String s) {
        EPStatement result = engine.getEPAdministrator().createEPL(s);
        System.out.println(s + " successful.");
        return result;
    }
    
    public static void sendEvent(Object o) {
        engine.getEPRuntime().sendEvent(o);
    }
}
