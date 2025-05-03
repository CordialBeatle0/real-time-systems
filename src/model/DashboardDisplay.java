package model;

import view.ElectronicControlUnitView;

public class DashboardDisplay {
    private final ElectronicControlUnitView view;
    
    public DashboardDisplay() {
        this.view = new ElectronicControlUnitView();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
    public ElectronicControlUnitView getView() {
        return view;
    }
    
    public void setSetSpeed(double speed) {
        view.getjTextFieldSetSpeed().setText(String.valueOf(speed));
    }
    
    public double getSetSpeed() {
        return Double.parseDouble(view.getjTextFieldSetSpeed().getText());
    }
    
    public void setCurrentSpeed(double speed) {
        view.getjTextFieldCurrentSpeed().setText(String.valueOf(speed));
    }
    
    public void setFuelLevel(double fuelLevel) {
        view.getjTextFieldFuel().setText(String.valueOf(fuelLevel));
    }
    
    public void setMaintenanceCheckbox(int selection, boolean state) {
        switch (selection) {
            case 1:
                view.getjCheckBoxOil().setSelected(state);
                view.getjButtonOilComplete().setEnabled(state);
            case 2:
                view.getjCheckBoxAir().setSelected(state);
                view.getjButtonAirComplete().setEnabled(state);
            case 3:
                view.getjCheckBoxMajor().setSelected(state);
                view.getjButtonMajorComplete().setEnabled(state);
            default:
                System.out.println("Incorrect selection for maintenance check");
        }
    }
    
    public void setMileage(double mileage) {
        view.getjTextFieldMileage().setText(String.valueOf(mileage));
    }
    
    public void setSetTemp(String temp) {
        view.getjTextFieldSetTemp().setText(temp);
    }
    
    public void setCurrentTemp(String temp) {
        view.getjTextFieldCurrentTemp().setText(temp);
    }
}
