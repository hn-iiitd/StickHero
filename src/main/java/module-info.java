module com.iiitd.stickhero {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.almasb.fxgl.all;

    opens com.iiitd.stickhero to javafx.fxml;
    exports com.iiitd.stickhero;
}