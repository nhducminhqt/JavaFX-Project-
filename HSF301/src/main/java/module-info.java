module org.example.hsf301 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.hsf301 to javafx.fxml;
    exports org.example.hsf301;
}