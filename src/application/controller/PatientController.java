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
    @FXML
    public TableView doctorsTable;
    @FXML
    public TableColumn<String, String> doctorsLeft;





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
    }

    public void prescriptionButtonAction(ActionEvent event) {
        prescriptionButton.setStyle("-fx-background-color:  #BB9955;");
        doctorsButton.setStyle("-fx-background-color: #555566");
        prescriptionTable.setVisible(true);
        updateButton.setVisible(true);
        doctorsTable.setVisible(false);
        displayPrescriptions(event);
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Patient.self.setDoctorsList();
        doctorsTable.setVisible(false);
        doctorsLeft.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()));

        prescriptionLeft.setCellValueFactory(new PropertyValueFactory<>("prescription"));
        prescriptionRight.setCellValueFactory(new PropertyValueFactory<>("docName"));
        //doctorsLeft.setCellValueFactory(new PropertyValueFactory<>("name"));
        displayPrescriptions(new ActionEvent());

        prescriptionButton.setOnAction(actionEvent -> prescriptionButtonAction(actionEvent));
        updateButton.setOnAction(actionEvent -> displayPrescriptions(actionEvent));
        doctorsButton.setOnAction(actionEvent -> doctorsButtonAction(actionEvent));
    }
}
