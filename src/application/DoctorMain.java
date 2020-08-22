package application;

import application.model.doctor.Doctor;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class DoctorMain extends Application {

    public Scene loadDoctor(Doctor doctor) throws IOException {
        URL url = getClass().getResource("view/doctor.fxml");
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        return scene;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(loadDoctor(new Doctor("Dr. person")));
        stage.setTitle("Prescript.io - Doctor");
        stage.show();
    }
}
