package application;

import application.controller.delivery.DeliveryController;
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

public class Main extends Application {
    public static Stage stage;



    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        stage.setScene(loadDelivery(genDeliverer()));
        // stage.setScene(loadDoctor(new Doctor("Mayukh")));
        stage.setTitle("Prescript.io - Doctor");
        stage.show();

        Prescription prescription;
    }

    private Deliverer genDeliverer() {
        Deliverer deliverer = new Deliverer("Mario,Blk 256, Super Mario Brothers District");
        Patient patient = new Patient("Ho Shing Tat, Nicholas", "Rosyth School", "5768G");
        Patient[] arr = {patient};
        Doctor doctor = new Doctor("Dr. Rajesh Koothrapaali");
        doctor.setPatientList(new ArrayList<Patient>(Arrays.asList(arr)));
        deliverer.addDeliveries(new Prescription(doctor, patient, "12 tablets of Paracetamol"), new Prescription(doctor, patient, "6 tablets of Cetrizine: To be taken every morning."));
        return deliverer;
    }

    public Scene loadDelivery(Deliverer deliverer) throws IOException {
        DeliveryController.setSelf(deliverer);
        URL url = getClass().getResource("view/delivery/delivery.fxml");
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Main.class.getResource("view/delivery/style.css").toExternalForm());
        stage.initStyle(StageStyle.UNDECORATED);
        return scene;
    }

    public Scene loadDoctor(Doctor doctor) throws IOException {
        URL url = getClass().getResource("view/doctor.fxml");
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        return scene;
    }
}
