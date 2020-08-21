package application.model.delivery;

import application.model.base.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Deliverer extends Stakeholder {
    /*
    Prannaya, please do this file.
     */

    private ArrayList<Prescription> deliveries;

    public Deliverer(String name) {
        super(name, "Deliverer");
        deliveries = new ArrayList<>();
    }

    public Deliverer() {
        this("");
    }

    public void addDeliveries(Prescription ...prescriptions) {
        deliveries.addAll(Arrays.asList(prescriptions));
    }

    public void markComplete(Prescription prescription) {
        deliveries.remove(prescription);
    }
}
