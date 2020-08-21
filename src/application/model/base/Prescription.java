package application.model.base;

import application.model.patient.Patient;
import application.model.doctor.Doctor;

public class Prescription {
    Doctor doctor; Patient client; String prescription, target;

    public Prescription(Doctor doctor, Patient client, String prescription) {
        this.doctor = doctor;
        this.client = client;
        this.prescription = prescription;
        this.target = client.getAddress();
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getClient() {
        return client;
    }

    public void setClient(Patient client) {
        this.client = client;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
}
