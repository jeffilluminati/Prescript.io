package application.controller.delivery;

import application.model.delivery.Deliverer;
import application.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DeliveryController implements Initializable {
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML private BorderPane border_pane;
    @FXML private VBox content_area;
    @FXML private HBox menubar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeStageDrageable();

    }

    private void makeStageDrageable() {
        border_pane.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        border_pane.setOnMouseDragged(event -> {
            Main.stage.setX(event.getScreenX() - xOffset);
            Main.stage.setY(event.getScreenY() - yOffset);
            Main.stage.setOpacity(0.7f);
        });
        border_pane.setOnDragDone((e) -> {
            Main.stage.setOpacity(1.0f);
        });
        border_pane.setOnMouseReleased((e) -> {
            Main.stage.setOpacity(1.0f);
        });

    }
}
