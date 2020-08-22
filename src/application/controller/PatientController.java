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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class PatientController implements Initializable {
    @FXML
    public ListView prescriptionLV;
    @FXML
    public Button updateButton;
    @FXML
    public Button prescriptionButton;
    @FXML
    public Button doctorsButton;
    @FXML
    public TableView prescriptionTable;
    @FXML
    public TableColumn<String, Prescription> prescriptionLeft;
    @FXML
    public TableColumn<String, Prescription> prescriptionRight;





    public void displayPrescriptions(Patient patient, ActionEvent event) {
        if (!patient.getPrescriptions().equals(prescriptionTable.getItems())) {
            Prescription p;
            for (int i = 0; i < patient.getPrescriptions().size(); i++) {
                p = patient.getPrescriptions().get(i);
                prescriptionTable.getItems().add(p);
            }
        }

    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        prescriptionLeft.setCellValueFactory(new PropertyValueFactory<>("prescription"));
        prescriptionRight.setCellValueFactory(new PropertyValueFactory<>("docName"));
        displayPrescriptions(Patient.getSelf(), new ActionEvent());

        updateButton.setOnAction(actionEvent -> displayPrescriptions(Patient.getSelf(), actionEvent));
    }
}
