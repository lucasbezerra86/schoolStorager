module storager {
    requires javafx.controls;
    requires javafx.fxml;

    opens storager to javafx.fxml;
    exports storager;
}