package application.controller;

import application.model.doctor.Doctor;
import application.model.patient.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DoctorController implements Initializable {
    @FXML
    public Accordion leftAccordion;
    @FXML
    public TextField patientNameTF;
    @FXML
    public TextField addressTF;
    @FXML
    public TextField prescriptionNameTF;
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
    @FXML
    public TextField patientICTF;

    private Doctor doctor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            doctor = Doctor.loadFromCsv("doctor.csv");
        } catch (IOException e) {
            System.out.println("Error in reading from file: " + e.getMessage());
        }

        for (Patient p: doctor.getPatientList()) {
            TitledPane pane = new TitledPane(p.getName(), new Label(""));
            pane.setOnContextMenuRequested(e -> {
                patientNameTF.setText(p.getName());
                patientICTF.setText(p.getIC());
                addressTF.setText(p.getAddress());
                prescriptionNameTF.setText(p.getPrescriptionName());
                prescriptionDescriptionTF.setText(p.getPrescriptionDescription());
                errorLabel.setText("");
            });
            leftAccordion.getPanes().add(pane);
        }
    }

    @FXML
    private boolean isAddModeEngaged = false;
    public void onAddPatientBtn(ActionEvent actionEvent) {
        TitledPane pane = new TitledPane("", new Label(""));

        patientNameTF.setText(""); patientICTF.setText(""); addressTF.setText("");
        prescriptionNameTF.setText(""); prescriptionDescriptionTF.setText("");
        
        patientNameTF.setEditable(true); patientICTF.setEditable(true); addressTF.setEditable(true);
        prescriptionNameTF.setEditable(true); prescriptionDescriptionTF.setEditable(true);

        isAddModeEngaged = true;
        
       
        saveBtn.setOnAction(e -> {
            String patientName = patientNameTF.getText();
            String patientIC = patientICTF.getText();
            String address = addressTF.getText();
            String prescriptionName = prescriptionNameTF.getText();
            String prescriptionDescription = prescriptionDescriptionTF.getText();

            pane.setAccessibleText(patientName);
            pane.setOnContextMenuRequested(event -> {
                patientNameTF.setEditable(false); patientICTF.setEditable(false); addressTF.setEditable(false);
                prescriptionNameTF.setEditable(false); prescriptionDescriptionTF.setEditable(false);

                patientNameTF.setText(patientName);
                patientICTF.setText(patientIC);
                addressTF.setText(address);
                prescriptionNameTF.setText(prescriptionName);
                prescriptionDescriptionTF.setText(prescriptionDescription);
                errorLabel.setText("");
            });

            isAddModeEngaged = false;
        });

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
