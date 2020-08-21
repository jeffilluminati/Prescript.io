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

    public Doctor(String name, ArrayList<Patient> patientList) {
        super(name, "");
        this.patientList = patientList;
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(ArrayList<Patient> patientList) {
        this.patientList = patientList;
    }

    public void saveToCsv(String filename) throws IOException {
        PrintWriter output = new PrintWriter(filename);
        output.printf("%s,%s", super.getName(), patientList.toString());
    }

    public static Doctor loadFromCsv(String fileName) throws IOException{
        String[] content = Files.readString(Paths.get("doctor.csv")).split(",");
        ArrayList<Patient> patients = new ArrayList<>();
        String doctorName = content[0];

        for (int i = 1; i < content.length; i += 5) {
            patients.add(new Patient(content[i], content[i + 1], content[i + 2], content[i + 3], content[i + 4]));
        }

        return new Doctor(doctorName, patients);
    }
}