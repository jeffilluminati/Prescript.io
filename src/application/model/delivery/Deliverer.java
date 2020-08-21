package application.model.delivery;

import application.model.base.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Deliverer extends Stakeholder {
    /*
    Prannaya, please do this file.
     */

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
    format of each line in delivers.csv: <name>,<address>
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
}
