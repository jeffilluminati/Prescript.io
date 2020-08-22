package application.controller.login;

import application.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LoginController {
    @FXML public void patient(ActionEvent event) { PatientMain.launch(); }
    @FXML public void doctor(ActionEvent event) { DoctorMain.launch(); }
    @FXML public void deliverer(ActionEvent event) { DeliveryMain.launch(); }
}
