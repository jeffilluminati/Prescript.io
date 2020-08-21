module hackathon {
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.web;
    requires javafx.swing;
    requires javafx.controls;
    requires java.desktop;
    requires java.logging;
    opens application;
    opens application.controller;
    opens application.view;
}