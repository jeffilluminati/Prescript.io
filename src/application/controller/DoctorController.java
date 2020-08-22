package application.controller;

import application.model.base.Prescription;
import application.model.doctor.Doctor;
import application.model.patient.Patient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
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
    public Button saveBtn;
    @FXML
    public TextField patientICTF;

    private Doctor doctor;
    private int currentIndexOfPatient;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        leftAccordion.expandedPaneProperty()
        doctor = Doctor.loadFromCsv("doctor.csv");

        for (Patient p: doctor.getPatientList()) {
            TitledPane pane = new TitledPane(p.getName(), new Label(""));
            pane.setOnContextMenuRequested(e -> {
                patientNameTF.setText(p.getName());
                patientICTF.setText(p.getIC());
                addressTF.setText(p.getAddress());
                errorLabel.setText("");
                currentIndexOfPatient = leftAccordion.getPanes().indexOf(pane);
            });
            leftAccordion.getPanes().add(pane);
        }
    }

    @FXML
    private boolean isAddModeEngaged = false;
    public void onAddPatientBtn() {
        checkIfOtherButtonIsEngaged();


        patientNameTF.setText(""); patientICTF.setText(""); addressTF.setText("");
        prescriptionNameTF.setText(""); prescriptionDescriptionTF.setText("");
        
        patientNameTF.setEditable(true); patientICTF.setEditable(true); addressTF.setEditable(true);
        prescriptionNameTF.setEditable(true); prescriptionDescriptionTF.setEditable(true);

        isAddModeEngaged = true;
        
       
        saveBtn.setOnAction(e -> {



            patientNameTF.setEditable(false); patientICTF.setEditable(false); addressTF.setEditable(false);
            prescriptionNameTF.setEditable(false); prescriptionDescriptionTF.setEditable(false);

            String patientName = patientNameTF.getText();
            String patientIC = patientICTF.getText();
            String address = addressTF.getText();
            String prescriptionName = prescriptionNameTF.getText();
            String prescriptionDescription = prescriptionDescriptionTF.getText();

            TitledPane pane = new TitledPane(patientName, new Label(""));
            leftAccordion.getPanes().add(pane);
            pane.setOnContextMenuRequested(event -> {
                int index = leftAccordion.getPanes().indexOf(pane);
                Patient p = doctor.getPatientList().get(index);
                Prescription pp = doctor.getPrescriptions().get(index);
                patientNameTF.setText(p.getName());
                patientICTF.setText(p.getIC());
                addressTF.setText(p.getAddress());
                prescriptionNameTF.setText(pp.getPrescription().split("\\s:\\s")[0]);
                prescriptionDescriptionTF.setText(pp.getPrescription().split("\\s:\\s")[1]);
                errorLabel.setText("");

                currentIndexOfPatient = leftAccordion.getPanes().indexOf(pane);
            });

            Patient p = new Patient(patientName, address, patientIC);
            Prescription pp = new Prescription(doctor, p, prescriptionName + " : " + prescriptionDescription);
            doctor.getPatientList().add(p);
            doctor.getPrescriptions().add(pp);

            doctor.saveToCsv("doctor.csv");
            isAddModeEngaged = false;
        });

    }

    private boolean isEditModeEngaged = false;
    @FXML
    public void onEditPatientBtn() {
        if (checkIfOtherButtonIsEngaged())
            return;
        isEditModeEngaged = true;

        patientNameTF.setEditable(true); patientICTF.setEditable(true); addressTF.setEditable(true);
        prescriptionNameTF.setEditable(true); prescriptionDescriptionTF.setEditable(true);

        saveBtn.setOnAction(e -> {

            patientNameTF.setEditable(false); patientICTF.setEditable(false); addressTF.setEditable(false);
            prescriptionNameTF.setEditable(false); prescriptionDescriptionTF.setEditable(false);

            String patientName = patientNameTF.getText();
            String patientIC = patientICTF.getText();
            String address = addressTF.getText();
            String prescriptionName = prescriptionNameTF.getText();
            String prescriptionDescription = prescriptionDescriptionTF.getText();

            doctor.getPatientList().get(this.currentIndexOfPatient).setName(patientName);
            doctor.getPatientList().get(this.currentIndexOfPatient).setIC(patientIC);
            doctor.getPatientList().get(this.currentIndexOfPatient).setAddress(address);
            doctor.getPrescriptions().get(this.currentIndexOfPatient).setPrescription(
                    prescriptionName + " : " + prescriptionDescription);

            isEditModeEngaged = false;

            doctor.saveToCsv("doctor.csv");

        });
    }

    @FXML
    public void onDeletePatientBtn() {
        if (checkIfOtherButtonIsEngaged())
            return;

        leftAccordion.getPanes().remove(this.currentIndexOfPatient);
        doctor.getPatientList().remove(this.currentIndexOfPatient);
        doctor.getPrescriptions().remove(this.currentIndexOfPatient);

        patientNameTF.setText(""); patientICTF.setText(""); addressTF.setText("");
        prescriptionNameTF.setText(""); prescriptionDescriptionTF.setText("");

        errorLabel.setText("Please Select a Patient using the menu on the left or add a new patient");

    }


    private boolean checkIfOtherButtonIsEngaged() {
        boolean isEngaged = isAddModeEngaged || isEditModeEngaged;
        if (isEngaged)
            errorLabel.setText("Please save your changes before making another change");
        else
            errorLabel.setText("");

        return isEngaged;
    }
}
