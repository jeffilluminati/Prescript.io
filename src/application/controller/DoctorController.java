package application.controller;

import application.model.base.Prescription;
import application.model.doctor.Doctor;
import application.model.patient.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DoctorController implements Initializable {
    @FXML
    public ListView listView;
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
    private ToggleGroup group = new ToggleGroup();
    private ArrayList<RadioButton> radioButtons = new ArrayList<>();
    public static final ObservableList patientNames = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        doctor = Doctor.loadFromCsv("doctor.csv");

        listView.setEditable(true);
        for (Patient p: doctor.getPatientList()) {
            patientNames.add(p.getName());
        }
        listView.setItems(patientNames);

        listView.setCellFactory(param -> new RadioListCell());
    }

    @FXML
    private boolean isAddModeEngaged = false;
    public void onAddPatientBtn() {
        if (checkIfOtherButtonIsEngaged())
            return;

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

            patientNames.add(patientName);
            listView.setItems(patientNames);

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

        patientNames.remove(this.currentIndexOfPatient);
        doctor.getPatientList().remove(this.currentIndexOfPatient);
        doctor.getPrescriptions().remove(this.currentIndexOfPatient);

        patientNameTF.setText(""); patientICTF.setText(""); addressTF.setText("");
        prescriptionNameTF.setText(""); prescriptionDescriptionTF.setText("");

        doctor.saveToCsv("doctor.csv");

    }


    private boolean checkIfOtherButtonIsEngaged() {
        boolean isEngaged = isAddModeEngaged || isEditModeEngaged;
        if (isEngaged)
            errorLabel.setText("Please save your changes before making another change");
        else
            errorLabel.setText("");

        return isEngaged;
    }

    private void dispSelectedPatient(ActionEvent e) {
        int index = patientNames.indexOf(((RadioButton) e.getSource()).getText());
        Patient p = doctor.getPatientList().get(index);
        Prescription pp = doctor.getPrescriptions().get(index);
        patientNameTF.setText(p.getName());
        patientICTF.setText(p.getIC());
        addressTF.setText(p.getAddress());
        prescriptionNameTF.setText(pp.getPrescription().split("\\s:\\s")[0]);
        prescriptionDescriptionTF.setText(pp.getPrescription().split("\\s:\\s")[1]);
        errorLabel.setText("");
    }


    private class RadioListCell extends ListCell<String> {
        private int index = -1;
        @Override
        public void updateItem(String obj, boolean empty) {
            super.updateItem(obj, empty);
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                RadioButton radioButton = new RadioButton();
                radioButton.setText(obj);
                radioButton.setToggleGroup(group);
                radioButtons.add(new RadioButton(obj));
                index++;
                radioButton.setOnAction(e -> dispSelectedPatient(e));
                setGraphic(radioButton);
            }
        }
    }
}
