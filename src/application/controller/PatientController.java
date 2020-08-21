package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.base.Prescription;
import application.model.patient.Patient;
import javafx.fxml.*;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class PatientController implements Initializable {
    @FXML
    public ListView prescriptionLV;


    public void displayPrescriptions(Patient patient) {
        for(Prescription p:patient.getPrescriptions()) {
            prescriptionLV.getItems().add(p);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
