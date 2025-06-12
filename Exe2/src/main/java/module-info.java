module atividadedois {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;

    opens atividadedois to javafx.fxml;
    opens atividadedois.Controllers to javafx.fxml;
    opens atividadedois.Classes to javafx.fxml, javafx.base;
    exports atividadedois;
}
