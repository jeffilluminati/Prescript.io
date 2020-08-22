package application.model.doctor;

import application.model.base.Prescription;
import application.model.base.Stakeholder;
import application.model.patient.Patient;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Doctor extends Stakeholder {
    private ArrayList<Patient> patientList;
    private ArrayList<Prescription> prescriptions;

    public Doctor(String name) {
        super(name, "");
        patientList = new ArrayList<>();
        prescriptions = new ArrayList<>();
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
            output.print(super.getName());
            for (int i = 0; i < patientList.size(); i++) {
                Patient p = patientList.get(i);
                Prescription pp = prescriptions.get(i);

                output.printf(",%s,%s,%s,%s", p.getName(), p.getAddress(), p.getIC(), pp.getPrescription());
            }
            output.close();
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
                prescriptions.add(new Prescription(doctor, patients.get(patients.size() - 1), content[i + 3]));
            }

            doctor.setPatientList(patients);
            doctor.setPrescriptions(prescriptions);

            return doctor;

        } catch (IOException e) {
            System.out.println("Error in reading from file: " + e.getMessage());
            return new Doctor("");
        }
    }
}