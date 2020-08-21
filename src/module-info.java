module NUSHHackathonProject {
    opens application.controller;
    opens application.view;
    opens application;

    requires javafx.controls;
    requires javafx.fxml;
}