package application.model.delivery;

import application.model.base.*;
import application.model.doctor.Doctor;
import application.model.patient.Patient;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Deliverer extends Stakeholder {

    private ArrayList<Prescription> deliveries;

    public Deliverer(String name, String address) {
        super(name, address);
        deliveries = new ArrayList<>();
    }

    public Deliverer() {
        this("", "");
    }

    private Deliverer(String[] args) {
        this(args[0], args[1]);
    }

    public Deliverer(String str) {
        this(str.split(",", 2));
    }

    /*
    format of each line in deliverers.csv: <name>,<address>
     */

    public static Deliverer parse(String str) {
        return new Deliverer(str.split(",", 1));
    }

    public void addDeliveries(Prescription ...prescriptions) {
        deliveries.addAll(Arrays.asList(prescriptions));
    }

    public void markComplete(Prescription prescription) {
        deliveries.remove(prescription);
    }

    public ArrayList<Prescription> getDeliveries() {
        return deliveries;
    }

    public static ArrayList<Prescription> loadPrescriptions() {
        ArrayList<Prescription> arr = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(System.getProperty("user.dir")+"\\prescriptions.csv"));
            String[] currentLine;
            while(sc.hasNext()) {
                currentLine = sc.nextLine().split(",[^\\w]", 3);
                String doctor = currentLine[0], patient = currentLine[1], prescription = currentLine[2];
                arr.add(new Prescription(new Doctor(doctor), new Patient(patient), prescription));
            }
        } catch(FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            return arr;
        }
    }
}
