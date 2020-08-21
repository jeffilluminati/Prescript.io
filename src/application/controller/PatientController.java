package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.base.Prescription;
import application.model.doctor.Doctor;
import application.model.patient.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class PatientController implements Initializable {
    @FXML
    public ListView prescriptionLV;
    @FXML
    public Button updateButton;


    public void displayPrescriptions(Patient patient, ActionEvent event) {
        for (int i = 0; i < patient.getPrescriptions().size(); i++) {
            prescriptionLV.getItems().add(patient.getPrescriptions().get(i));
        }
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Patient testPatient = new Patient("li da","changi", "9678C");

        testPatient.getPrescriptions();

        updateButton.setOnAction(actionEvent -> displayPrescriptions(testPatient, actionEvent));
    }
}
