package application.controller;

import application.Main;
import javafx.collections.ModifiableObservableListBase;
import javafx.fxml.*;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class DeliveryController implements Initializable {
    private double xOffset = 0;
    private double yOffset = 0;

    @FXML AnchorPane win;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void winPress(MouseEvent event) {
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }

    @FXML
    public void winDrag(MouseEvent event) {
        Main.stage.setX(event.getScreenX() - xOffset);
        Main.stage.setY(event.getScreenY() - yOffset);
        Main.stage.setOpacity(0.7f);

    }

    @FXML
    public void winDragDone(DragEvent event) {
        Main.stage.setOpacity(1.0f);
    }

    @FXML
    public void winMouseReleased(MouseEvent event) {
        Main.stage.setOpacity(1.0f);
    }


}
