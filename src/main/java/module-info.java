module com.iiitd.stickhero {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires junit;
    opens com.iiitd.stickhero to javafx.fxml;
    exports com.iiitd.stickhero;
}