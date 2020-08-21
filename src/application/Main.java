package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

import java.io.IOException;

public class Main extends Application {
    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        stage.setScene(loadDelivery());
        stage.show();
    }

    public Scene loadDelivery() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/delivery/delivery.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Main.class.getResource("view/delivery/deliveryStyle.css").toExternalForm());
        return scene;
    }
}
