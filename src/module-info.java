module NUSHHackathonProject {
    opens application.controller;
    opens application.controller.delivery;
    opens application.view;
    opens application;

    requires javafx.controls;
    requires javafx.fxml;

    exports application;
}