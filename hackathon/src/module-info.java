module hackathon {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.web;
    requires javafx.swing;
    requires java.desktop;
    requires java.logging;
    opens application;
    opens application.controller;
    opens application.view;
}