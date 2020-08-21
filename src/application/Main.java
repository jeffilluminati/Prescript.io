package application;

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
        stage.setScene(loadDelivery());
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public Scene loadDelivery() throws IOException {
        URL url = getClass().getResource("view/delivery/delivery.fxml");
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Main.class.getResource("view/delivery/style.css").toExternalForm());
        return scene;
    }
}
