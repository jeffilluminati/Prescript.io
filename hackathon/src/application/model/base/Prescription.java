package application.model.base;

import application.model.client.Client;
import application.model.doctor.Doctor;

public class Prescription {
    Doctor doctor; Client client; String prescription;

    public Prescription(Doctor doctor, Client client, String prescription) {
        this.doctor = doctor;
        this.client = client;
        this.prescription = prescription;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
}
