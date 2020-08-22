package application.controller.delivery;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    @FXML private Label name, address;
    @FXML private ImageView imageView;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setText(DeliveryController.getSelf().getName());
        address.setText(address.getText()+DeliveryController.getSelf().getAddress());
        imageView.setImage(DeliveryController.currentOccurence.image.getImage());
    }

    @FXML
    public void cancel(ActionEvent event) {
        DeliveryController.currentOccurence.setMain(event);
    }
}
