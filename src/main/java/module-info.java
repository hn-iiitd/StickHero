module com.iiitd.stickhero {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens com.iiitd.stickhero to javafx.fxml;
    exports com.iiitd.stickhero;
}