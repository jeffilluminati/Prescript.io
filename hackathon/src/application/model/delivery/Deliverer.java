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
        super(name, "Deliverer", address);
        deliveries = new ArrayList<>();
    }

    public Deliverer() {
        this("", "");
    }

    /*
    format of each line in delivers.csv: <name>,<address>
     */

    public static Deliverer parse(String str) {
        String[] arr = str.split(",");
        String name = arr[0], address = String.join(",", Arrays.copyOfRange(arr, 1, arr.length));
        return new Deliverer(name, address);
    }

    public void addDeliveries(Prescription ...prescriptions) {
        deliveries.addAll(Arrays.asList(prescriptions));
    }

    public void markComplete(Prescription prescription) {
        deliveries.remove(prescription);
    }
}
