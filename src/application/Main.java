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

public class Main extends Application {
    public static Stage stage;


    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        stage.setScene(loadDelivery(genDeliverer()));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Prescript.io - Delivery");
        stage.show();
    }

    private Deliverer genDeliverer() {
        Deliverer deliverer = new Deliverer("Mario,Blk 256,Simei Street 1");
        Doctor doctor = new Doctor(); Patient patient = new Patient("Bobby", "Rosyth School");
        deliverer.addDeliveries(new Prescription(doctor, patient, "12 tablets of Paracetamol"), new Prescription(doctor, patient, "6 tablets of Cetrizine to be taken every morning."));
        return deliverer;
    }

    public Scene loadDelivery(Deliverer deliverer) throws IOException {
        DeliveryController.setSelf(deliverer);
        URL url = getClass().getResource("view/delivery/delivery.fxml");
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Main.class.getResource("view/delivery/style.css").toExternalForm());
        return scene;
    }
}
