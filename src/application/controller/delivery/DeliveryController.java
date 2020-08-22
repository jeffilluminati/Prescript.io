package application.controller.delivery;

import application.model.base.Prescription;
import application.model.delivery.Deliverer;
import application.DeliveryMain;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DeliveryController implements Initializable {
    private double xOffset = 0, yOffset = 0;
    static String IMAGE_URL = "src/resources/images/pics/icons8_Person_32px.png";

    static DeliveryController currentOccurence;


    @FXML private BorderPane border_pane;
    @FXML private VBox content_area, sidebar;
    @FXML private HBox menubar;
    @FXML private Label name;
    @FXML private TableView<Prescription> table;
    @FXML private TableColumn<Prescription, String> doctors;
    @FXML private TableColumn<Prescription, String> patients;
    @FXML private TableColumn<Prescription, String> details;
    @FXML private TableColumn<Prescription, String> locations;
    @FXML public ImageView image;

    private Node main;

    final ObservableList<Prescription> data = FXCollections.observableArrayList(
            self.getDeliveries()
    );

    private static Deliverer self = new Deliverer();

    public void setName(String newname) {
        name.setText(newname);
        self.setName(name.getText());
    }

    @FXML
    public void setMain(ActionEvent e) {
        border_pane.setCenter(main);
    }

    @FXML
    public void setAdmin(ActionEvent e) throws IOException {
        border_pane.setCenter(FXMLLoader.load(DeliveryMain.class.getResource("/application/view/delivery/admin.fxml")));
    }

    @FXML
    public void setSettings(ActionEvent e) throws IOException {
        border_pane.setCenter(FXMLLoader.load(DeliveryMain.class.getResource("/application/view/delivery/setting.fxml")));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeStageDrageable();
        name.setText(self.getName());
        doctors.setCellValueFactory(new PropertyValueFactory<Prescription, String>("docName"));
        patients.setCellValueFactory(new PropertyValueFactory<Prescription, String>("patientName"));
        details.setCellValueFactory(new PropertyValueFactory<Prescription, String>("prescription"));
        locations.setCellValueFactory(new PropertyValueFactory<Prescription, String>("target"));
        table.setItems(data);
        table.getSortOrder().add(locations);
        main = content_area;
        currentOccurence = this;
    }

    public void setImage(String IMAGE_URL) {
        image.setImage(new Image(IMAGE_URL));
    }



    @FXML
    public void closeWin(ActionEvent event) {
        Stage stage = (Stage)((Hyperlink)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void minimizeWin(ActionEvent event) {
        Stage stage = (Stage)((Hyperlink)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    private void makeStageDrageable() {
        border_pane.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        border_pane.setOnMouseDragged(event -> {
            DeliveryMain.stage.setX(event.getScreenX() - xOffset);
            DeliveryMain.stage.setY(event.getScreenY() - yOffset);
            DeliveryMain.stage.setOpacity(0.7f);
        });
        border_pane.setOnDragDone((e) -> {
            DeliveryMain.stage.setOpacity(1.0f);
        });
        border_pane.setOnMouseReleased((e) -> {
            DeliveryMain.stage.setOpacity(1.0f);
        });

    }

    @FXML
    public void markComplete(ActionEvent e) {
        try {
            data.remove(table.getSelectionModel().getSelectedIndex());
            table.setItems(data);
        } catch (IndexOutOfBoundsException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No row selected!");
            alert.setContentText("Please select a row before you attempt to mark complete");
            alert.showAndWait();
            return;
        }
    }

    public static Deliverer getSelf() {
        return self;
    }

    public static void setSelf(Deliverer newSelf) {
        self = newSelf;
    }
}
