package application.model.delivery;

import application.model.base.*;

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
        this(str.split(",", 1));
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
}
