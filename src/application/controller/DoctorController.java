package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DoctorController implements Initializable {
    @FXML
    public Accordion leftAccordion;
    @FXML
    public Label patientNameLabel;
    @FXML
    public TextField patientNameTF;
    @FXML
    public Label ICLabel;
    @FXML
    public TextField ICTF;
    @FXML
    public Label addressLabel;
    @FXML
    public TextField addressTF;
    @FXML
    public Label prescriptionNameLabel;
    @FXML
    public TextField prescriptionNameTF;
    @FXML
    public Label prescriptionDescriptionLabel;
    @FXML
    public TextField prescriptionDescriptionTF;
    @FXML
    public Label errorLabel;
    @FXML
    public Button addPatientBtn;
    @FXML
    public Button editPatientBtn;
    @FXML
    public Button deletePatientBtn;
    @FXML
    public Button editPrescriptionButton;
    @FXML
    public Button saveBtn;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void onAddPatientBtn(ActionEvent actionEvent) {

    }

    @FXML
    public void onEditPatientBtn(ActionEvent actionEvent) {

    }

    @FXML
    public void onDeletePatientBtn(ActionEvent actionEvent) {

    }

    @FXML
    public void onEditPrescriptionBtn(ActionEvent actionEvent) {
    }

    @FXML
    public void onSaveBtn(ActionEvent actionEvent) {

    }

}
