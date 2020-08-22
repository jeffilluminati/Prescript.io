package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.base.Prescription;
import application.model.doctor.Doctor;
import application.model.patient.Patient;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
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
    @FXML
    public TableView doctorsTable;
    @FXML
    public TableColumn<String, String> doctorsLeft;
    @FXML
    public Button accountButton;
    @FXML
    public Label usernameLabel;
    @FXML
    public Label bigUsernameLabel;
    @FXML
    public Label addressLabel;


    public void displayPrescriptions(ActionEvent event) {
        Patient patient = Patient.getSelf();
        if (!patient.getPrescriptions().equals(prescriptionTable.getItems())) {
            Prescription p;
            for (int i = 0; i < patient.getPrescriptions().size(); i++) {
                p = patient.getPrescriptions().get(i);
                prescriptionTable.getItems().add(p);
            }
        }

    }

    public void doctorsButtonAction(ActionEvent event) {


        if (!Patient.getSelf().getPrescriptions().equals(doctorsTable.getItems())) {
            ObservableList<String> nameList = FXCollections.observableArrayList();
            for (int i = 0; i < Patient.getSelf().getDoctors().size(); i++) {
                if (!nameList.contains(Patient.getSelf().getDoctors().get(i).getName())) {
                    nameList.add(Patient.getSelf().getDoctors().get(i).getName());
                }
                doctorsTable.setItems(nameList);
            }
        }
        for (var x:doctorsTable.getItems()) {
            System.out.println(x);
        }
        prescriptionButton.setStyle("-fx-background-color: #555566");
        doctorsButton.setStyle("-fx-background-color:  #BB9955;");
        prescriptionTable.setVisible(false);
        updateButton.setVisible(false);
        doctorsTable.setVisible(true);
        bigUsernameLabel.setVisible(false);
        addressLabel.setVisible(false);
    }

    public void prescriptionButtonAction(ActionEvent event) {
        prescriptionButton.setStyle("-fx-background-color:  #BB9955;");
        doctorsButton.setStyle("-fx-background-color: #555566");
        prescriptionTable.setVisible(true);
        updateButton.setVisible(true);
        doctorsTable.setVisible(false);
        bigUsernameLabel.setVisible(false);
        addressLabel.setVisible(false);
        displayPrescriptions(event);
    }

    public void accountButtonAction(ActionEvent actionEvent) {
        prescriptionTable.setVisible(false);
        updateButton.setVisible(false);
        doctorsTable.setVisible(false);
        doctorsButton.setStyle("-fx-background-color: #555566");
        prescriptionButton.setStyle("-fx-background-color: #555566");
        bigUsernameLabel.setVisible(true);
        addressLabel.setVisible(true);
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        accountButton.setOpacity(0);
        bigUsernameLabel.setVisible(false);
        addressLabel.setVisible(false);
        usernameLabel.setText(Patient.getSelf().getName());
        addressLabel.setText(Patient.getSelf().getAddress());
        bigUsernameLabel.setText(Patient.getSelf().getName());

        updateButton.setVisible(true);
        prescriptionTable.setVisible(true);
        doctorsTable.setVisible(false);
        doctorsLeft.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()));

        prescriptionLeft.setCellValueFactory(new PropertyValueFactory<>("prescription"));
        prescriptionRight.setCellValueFactory(new PropertyValueFactory<>("docName"));
        //doctorsLeft.setCellValueFactory(new PropertyValueFactory<>("name"));
        displayPrescriptions(new ActionEvent());

        prescriptionButton.setOnAction(actionEvent -> prescriptionButtonAction(actionEvent));
        updateButton.setOnAction(actionEvent -> displayPrescriptions(actionEvent));
        doctorsButton.setOnAction(actionEvent -> doctorsButtonAction(actionEvent));
        accountButton.setOnAction(actionEvent -> accountButtonAction(actionEvent));
        Patient.self.setDoctorsList();

        accountButton.setVisible(true);
    }
}
