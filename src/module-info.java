module NUSHHackathonProject {
    opens application.controller;
    opens application.controller.delivery;
    opens application.view;
    opens application;

    requires javafx.controls;
    requires javafx.fxml;

    requires fontawesomefx;
    requires jfoenix;
    requires java.logging;

    exports application;
}