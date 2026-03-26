module com.dslengine.dslui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.dslengine.dslui to javafx.fxml;
    exports com.dslengine.dslui;
}