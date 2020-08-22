package application;

import application.controller.delivery.DeliveryController;
import application.model.base.Prescription;
import application.model.delivery.Deliverer;
import application.model.doctor.Doctor;
import application.model.patient.Patient;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class DeliveryMain extends Application {
    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        stage.setScene(loadDelivery(genDeliverer()));
        stage.setTitle("Prescript.io - Deliverer");
        stage.getIcons().add(new Image(("file:src/resources/images/icons/icon.png")));
        stage.show();
    }

    private Deliverer genDeliverer() {
        Deliverer deliverer = new Deliverer("Mario,Blk 256,Super Mario Brothers District");
        Doctor doctor = Doctor.loadFromCsv("doctor.csv");
        deliverer.addDeliveries(doctor.getPrescriptions());
        return deliverer;
    }

    public Scene loadDelivery(Deliverer deliverer) throws IOException {
        DeliveryController.setSelf(deliverer);
        URL url = getClass().getResource("view/delivery/delivery.fxml");
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(DeliveryMain.class.getResource("view/delivery/style.css").toExternalForm());
        stage.initStyle(StageStyle.UNDECORATED);
        return scene;
    }

    public static void main(String ...args) { launch(args); }

}
