package application.model.base;

import application.model.patient.Patient;
import application.model.doctor.Doctor;
import javafx.beans.property.SimpleStringProperty;

public class Prescription {
    private final SimpleStringProperty target = new SimpleStringProperty(""),
            prescription = new SimpleStringProperty(""),
            docName = new SimpleStringProperty(""), patientName  = new SimpleStringProperty("");

    public Prescription(Doctor doctor, Patient patient, String prescription) {
        this.prescription.set(prescription);
        this.target.set(patient.getAddress());
        this.docName.set(doctor.getName());
        this.patientName.set(patient.getName());
    }

    public String getTarget() {
        return target.get();
    }

    public SimpleStringProperty targetProperty() {
        return target;
    }

    public void setTarget(String target) {
        this.target.set(target);
    }

    public String getDocName() {
        return docName.get();
    }

    public SimpleStringProperty docNameProperty() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName.set(docName);
    }

    public String getPatientName() {
        return patientName.get();
    }

    public SimpleStringProperty patientNameProperty() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName.set(patientName);
    }

    public String getPrescription() {
        return prescription.get();
    }

    public SimpleStringProperty prescriptionProperty() { return prescription; }

    public void setPrescription(String prescription) {
        this.prescription.set(prescription);
    }
}
