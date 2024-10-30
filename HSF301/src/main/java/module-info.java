module org.example.hsf301 {
    requires javafx.controls;
    requires javafx.fxml;

//    requires com.dlsc.formsfx;
    requires java.naming;  // Java Naming and Directory Interface (JNDI) API.
    requires org.kordamp.bootstrapfx.core;
    requires static lombok;
    requires javax.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires java.net.http;
    requires java.desktop;
    requires javax.mail.api;
    requires org.slf4j;
    requires thymeleaf;
    requires io.github.cdimascio.dotenv.java;

    opens org.example.hsf301 to javafx.fxml;
    exports org.example.hsf301;

    opens org.example.hsf301.views to javafx.graphics;
    exports org.example.hsf301.views;

    opens org.example.hsf301.service to org.hibernate.orm.core;
    exports org.example.hsf301.service;

    opens org.example.hsf301.pojo to org.hibernate.orm.core;
    opens org.example.hsf301.dao to org.hibernate.orm.core;
    exports org.example.hsf301.controllers;
    opens org.example.hsf301.controllers to javafx.fxml;
    exports org.example.hsf301.constants;
    opens org.example.hsf301.constants to javafx.fxml;
    exports org.example.hsf301.styles;
    opens org.example.hsf301.styles to javafx.fxml;
    exports org.example.hsf301.utils;
    opens org.example.hsf301.utils to javafx.fxml;
    exports org.example.hsf301.views.base;
    opens org.example.hsf301.views.base to javafx.fxml;
    exports org.example.hsf301.layouts;
    opens org.example.hsf301.layouts to javafx.fxml;
}