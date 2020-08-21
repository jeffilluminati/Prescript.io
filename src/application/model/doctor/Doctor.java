package application.model.doctor;

import application.model.base.*;
import application.model.patient.Patient;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Doctor extends Stakeholder {
    private ArrayList<Patient> patientList;
    private ArrayList<Prescription> prescriptions;

    public Doctor(String name) {
        super(name, "");
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(ArrayList<Patient> patientList) {
        this.patientList = patientList;
    }

    public ArrayList<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(ArrayList<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public void saveToCsv(String filename) {
        try {
            PrintWriter output = new PrintWriter(filename);
            output.printf("%s,%s", super.getName(), patientList.toString());
        } catch (IOException e) {
            System.out.println("Error in writing to file: " + e.getMessage());
        }
    }

    public static Doctor loadFromCsv(String fileName) {
        try {
            String[] content = Files.readString(Paths.get("doctor.csv")).split(",");
            ArrayList<Patient> patients = new ArrayList<>();
            ArrayList<Prescription> prescriptions = new ArrayList<>();
            String doctorName = content[0];
            Doctor doctor = new Doctor(doctorName);

            for (int i = 1; i < content.length; i += 4) {
                patients.add(new Patient(content[i], content[i + 1], content[i + 2]));
                prescriptions.add(new Prescription(doctor, patients.get(-1), content[i + 3]));
            }

            return doctor;

        } catch (IOException e) {
            System.out.println("Error in writing to file: " + e.getMessage());
            return new Doctor("");
        }
    }
}