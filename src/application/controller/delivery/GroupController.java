package application.controller.delivery;

import application.model.base.Prescription;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class GroupController implements Initializable {
    @FXML VBox box;


    static ArrayList<Prescription> arr = new ArrayList<>(DeliveryController.getSelf().getDeliveries());
    static {
        Collections.sort(arr, new SortByRegion());
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<ArrayList<Prescription>> array = new ArrayList<>();
        array.add(new ArrayList<>());
        String currentRegion = arr.get(0).getTarget();
        for(int i = 0, index = 0; i < arr.size(); i++) {
            if(!(arr.get(i).getTarget().equals(currentRegion))) {array.add(new ArrayList<>()); index++; currentRegion = arr.get(i).getTarget(); }
            array.get(index).add(arr.get(i));
        }

        for(ArrayList<Prescription> prescriptions: array) {
            Label label = new Label(prescriptions.get(0).getTarget());
            label.setStyle("-fx-text-fill: black;");
            label.setFont(new Font("Quicksand",24));
            TableView<Prescription> table = new TableView<>();
            TableColumn<Prescription, String> doctors = new TableColumn<>(), patients = new TableColumn<>(),
                    details = new TableColumn<>();
            table.getColumns().addAll(doctors, patients, details);
            doctors.setCellValueFactory(new PropertyValueFactory<Prescription, String>("docName"));
            patients.setCellValueFactory(new PropertyValueFactory<Prescription, String>("patientName"));
            details.setCellValueFactory(new PropertyValueFactory<Prescription, String>("prescription"));
            table.setItems(FXCollections.observableList(prescriptions));
            table.getSortOrder().add(details);
            table.setFixedCellSize(25);
            table.prefHeightProperty().bind(table.fixedCellSizeProperty().multiply(Bindings.size(table.getItems()).add(1.01)));
            table.minHeightProperty().bind(table.prefHeightProperty());
            table.maxHeightProperty().bind(table.prefHeightProperty());

            box.getChildren().addAll(label, table, new Separator());
            VBox.setVgrow(table, Priority.ALWAYS);
        }
    }
    private static class SortByRegion implements Comparator<Prescription> {

        @Override
        public int compare(Prescription o1, Prescription o2) {
            return o1.getTarget().compareTo(o2.getTarget());
        }
    }
}


