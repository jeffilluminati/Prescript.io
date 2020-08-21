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

    // public Doctor getDoctor() {return doctor;}

    // public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    // public String getDoctorName() { return doctor.getName(); }

    //public String getPatientName() { return patient.getName(); }

    //public Patient getPatient() { return patient; }

    //public void setPatient(Patient patient) { this.patient = patient; }

    public String getPrescription() {
        return prescription.get();
    }

    public void setPrescription(String prescription) {
        this.prescription.set(prescription);
    }
}
