module com.mycompany.clock {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;

    opens com.mycompany.clock to javafx.fxml;
    exports com.mycompany.clock;
}
