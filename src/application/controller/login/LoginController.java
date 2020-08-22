package application.controller.login;

import application.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class LoginController {
    @FXML public void patient(ActionEvent event) throws Exception {
        Application patient = new PatientMain();
        Stage stage = new Stage();
        patient.start(stage);
    }
    @FXML public void doctor(ActionEvent event) throws Exception {
        Application patient = new DoctorMain();
        Stage stage = new Stage();
        patient.start(stage);
    }
    @FXML public void deliverer(ActionEvent event) throws Exception {
        Application patient = new DeliveryMain();
        Stage stage = new Stage();
        patient.start(stage);
    }


}
