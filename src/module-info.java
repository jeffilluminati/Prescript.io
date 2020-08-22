module NUSHHackathonProject {
    opens application;
    opens application.controller;
    opens application.controller.delivery;
    opens application.model.base;
    opens application.view;

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    exports application;
}