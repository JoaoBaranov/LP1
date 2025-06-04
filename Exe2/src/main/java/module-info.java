module atividadedois {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens atividadedois to javafx.fxml;
    opens atividadedois.Controllers to javafx.fxml;
    opens atividadedois.Classes to javafx.fxml;
    exports atividadedois;
}
