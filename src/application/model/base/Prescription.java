package application.model.base;

import application.model.patient.Patient;
import application.model.doctor.Doctor;

public class Prescription {
    Doctor doctor; String target, prescription, docName, patientName;
    Patient patient;
    public Prescription(Doctor doctor, Patient patient, String prescription) {
        this.doctor = doctor;
        this.patient = patient;
        this.prescription = prescription;
        this.target = patient.getAddress();
        this.docName = doctor.getName();
        this.patientName = patient.getName();
    }

    public Doctor getDoctor() {
        return doctor;
    }

    // public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public String getDoctorName() { return doctor.getName(); }

    //public String getPatientName() { return patient.getName(); }

    //public Patient getPatient() { return patient; }

    //public void setPatient(Patient patient) { this.patient = patient; }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
}
