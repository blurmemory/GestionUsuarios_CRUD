module com.rojas.ian {
    requires javafx.controls;
    requires javafx.fxml;
    exports com.rojas.ian;
    opens com.rojas.ian.controller to javafx.fxml;
    opens com.rojas.ian.model to javafx.base;
}
