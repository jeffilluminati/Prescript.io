package application.model.patient;

import application.model.base.*;

public class Patient extends Stakeholder {
    private String IC, prescriptionName, prescriptionDescription;

    public Patient(String name, String address, String IC) {
        this(name, address, IC, "", "");
    }

    public Patient(String name, String address, String IC, String prescriptionName, String prescriptionDescription) {
        super(name, address);
        this.IC = IC;

        this.prescriptionName = prescriptionName;
        this.prescriptionDescription = prescriptionDescription;
    }

    public String getIC() {
        return IC;
    }

    public void setIC(String IC) {
        this.IC = IC;
    }

    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName;
    }

    public String getPrescriptionDescription() {
        return prescriptionDescription;
    }

    public void setPrescriptionDescription(String prescriptionDescription) {
        this.prescriptionDescription = prescriptionDescription;
    }
}
