module com.example.supplysystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.supplysystem to javafx.fxml;
    exports com.example.supplysystem;
}