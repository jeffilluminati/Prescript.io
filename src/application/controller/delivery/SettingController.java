package application.controller.delivery;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingController implements Initializable {
    @FXML Button browse, save, cancel;
    @FXML TextField name;
    @FXML ImageView imageView;

    String URL = DeliveryController.IMAGE_URL;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void cancel(ActionEvent event) {
        DeliveryController.currentOccurence.setMain(event);
    }

    @FXML
    public void browse(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Browse Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        File file = fileChooser.showOpenDialog(Main.stage);
        if(file != null) imageView.setImage(new Image((URL = file.toURI().toURL().toExternalForm())));
    }

    @FXML
    public void saveDetails(ActionEvent event) {
        DeliveryController.currentOccurence.setName(name.getText());
        DeliveryController.currentOccurence.setImage(URL);
    }
}
