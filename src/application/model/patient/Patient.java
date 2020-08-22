package application.model.patient;

import application.model.base.*;
import application.model.doctor.Doctor;

import java.io.*;
import java.util.ArrayList;

public class Patient extends Stakeholder {
    private ArrayList<Prescription> prescriptions;
    private ArrayList<Doctor> doctors;
    private String IC;

    private void addPrescription(Prescription p) { prescriptions.add(p); }
    private void removePrescription(Prescription p) { prescriptions.remove(p); }

    private void addDoctor(Doctor d) { doctors.add(d); }
    private void removeDoctor(Doctor d) { doctors.remove(d); }


    public ArrayList<Prescription> getPrescriptions() { return prescriptions; }
    public String getAddress() { return super.getAddress(); }

    public static Patient self;

    public Patient(String name, String address, String IC) {
        super(name,address);
        this.IC = IC;
        prescriptions = new ArrayList<>();
        doctors = new ArrayList<>();
    }

    public Patient(String name) {
        this(name, "", "");
    }

    //copies whole prescription list to file
    private void updatePrescriptionFile() {
        try {
            PrintWriter printWriter = new PrintWriter("prescriptionFile.csv");
        } catch (IOException ex) {
            System.out.println("ioexception in updateprescriptionfile");//temp
        }
    }


    public void setPrescriptions(ArrayList<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void setIC(String IC) {
        this.IC = IC;
    }

    public String getIC() {
        return IC;
    }

    /*
    public static Patient loadFromCsv(String filename) throws IOException {
        Patient returnPatient;

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String[] line;
        line = br.readLine().split(",");
        returnPatient = new Patient(line[0],line[1],line[2]);

        while(br.readLine() != null) {
            returnPatient.prescriptions.add(new Prescription());
        }
        return returnPatient;
    }


     */

    public void setDoctorsList() {
        Doctor d;
        for (int i = 0; i < prescriptions.size(); i++) {
            d = new Doctor(prescriptions.get(i).getDocName());
            if (!doctors.contains(d)) {
                doctors.add(d);
            }
        }
    }

    public static void setSelf(Patient p) { self = p; }

    public static Patient getSelf() { return self; }
}
