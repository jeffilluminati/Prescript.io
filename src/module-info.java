module NUSHHackathonProject {
    opens application.controller;
    opens application.controller.delivery;
    opens application.view;
    opens application.model.base;
    opens application;
    opens application.controller.delivery.maps;

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    exports application;
}