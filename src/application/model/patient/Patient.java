package application.model.patient;

import application.model.base.*;
import application.model.doctor.Doctor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Patient extends Stakeholder {
    private ArrayList<Prescription> prescriptions;
    private ArrayList<Doctor> doctors;

    private void addPrescription(Prescription p) { prescriptions.add(p); }
    private void removePrescription(Prescription p) { prescriptions.remove(p); }

    private void addDoctor(Doctor d) { doctors.add(d); }
    private void removeDoctor(Doctor d) { doctors.remove(d); }



    public ArrayList<Prescription> getPrescriptions() { return prescriptions; }
    public String getAddress() { return super.getAddress(); }



    public Patient(String name, String address) {
        super(name,address);
        prescriptions = new ArrayList<>();
        doctors = new ArrayList<>();
    }

    //copies whole prescription list to file
    private void updatePrescriptionFile() {
        try {
            PrintWriter printWriter = new PrintWriter("prescriptionFile.csv");
        } catch (IOException ex) {
            System.out.println("ioexception in updateprescriptionfile");//temp
        }
    }

    //adds one prescription to end of prescription file
    private void addToPrescriptionFile(Prescription p) {

    }


}
