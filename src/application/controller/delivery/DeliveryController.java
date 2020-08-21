package application.controller.delivery;

import application.model.base.Prescription;
import application.model.delivery.Deliverer;
import application.Main;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.doctor.Doctor;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DeliveryController implements Initializable {
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML private BorderPane border_pane;
    @FXML private VBox content_area, sidebar;
    @FXML private HBox menubar;
    @FXML private Label name;
    @FXML private TableView<Prescription> table;
    @FXML private TableColumn<Prescription, String> doctors;
    @FXML private TableColumn<Prescription, String> patients;
    @FXML private TableColumn<Prescription, String> details;
    @FXML private TableColumn<Prescription, String> locations;

    final ObservableList<Prescription> data = FXCollections.observableArrayList(
            self.getDeliveries()
    );

    private static Deliverer self = new Deliverer();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeStageDrageable();
        name.setText(self.getName());
        doctors.setCellValueFactory(new PropertyValueFactory<Prescription, String>("docName"));
        patients.setCellValueFactory(new PropertyValueFactory<Prescription, String>("patientName"));
        details.setCellValueFactory(new PropertyValueFactory<Prescription, String>("prescription"));
        locations.setCellValueFactory(new PropertyValueFactory<Prescription, String>("target"));
        table.setItems(data);
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

    public static Deliverer getSelf() {
        return self;
    }

    public static void setSelf(Deliverer newSelf) {
        self = newSelf;
    }
}
