module org.example.hsf301 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires static lombok;
    requires javax.persistence;
    requires java.sql;

    opens org.example.hsf301 to javafx.fxml;

    opens hsf301.pojo to org.hibernate.orm.core;
    opens hsf301.dao to org.hibernate.orm.core;

    exports org.example.hsf301;
}