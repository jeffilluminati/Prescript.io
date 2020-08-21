module NUSHHackathonProject {
    opens application.controller;
    opens application.controller.delivery;
    opens application.view;
    opens application.model.base;
    opens application;

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    exports application;
}