package application;

//import application.controller.delivery.DeliveryController;
import application.model.base.Prescription;
import application.model.delivery.Deliverer;
import application.model.doctor.Doctor;
import application.model.patient.Patient;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class PatientMain extends Application {
    public static Stage stage;


    @Override
    public void start(Stage primaryStage) throws IOException {
        Patient.setSelf(loadTempPatient());
        stage = primaryStage;
        stage.setScene(loadPatient(loadTempPatient()));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Prescript.io - Delivery");
        stage.show();
    }

    private Patient loadTempPatient() {
        Patient p = new Patient("lida","changi","t1234567h");
        Doctor d = new Doctor("hun");
        p.getPrescriptions().add(new Prescription(d,p,"water"));
        p.getPrescriptions().add(new Prescription(d,p,"cake"));
        return p;
    }

    public Scene loadPatient(Patient patient) throws IOException {
        URL url = getClass().getResource("view/patient.fxml");
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(Main.class.getResource("view/patient.fxml").toExternalForm());
        return scene;
    }

    public static void main(String ...args) { launch(args); }
}
