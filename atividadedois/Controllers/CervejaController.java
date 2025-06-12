package atividadedois.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CervejaController {
    @FXML
    private Button botaoMenu;

    @FXML
    private TextField marcaTextField;

    @FXML
    private TextField origemTextField;

    @FXML
    private TextField teorTextField;

    @FXML
    private TableView<?> tabelaCalcados;

    @FXML
    private TableColumn<?, ?> colunaMarca;

    @FXML
    private TableColumn<?, ?> colunaModelo;

    @FXML
    private TableColumn<?, ?> colunaTamanho;

    @FXML
    private Button botaoAdicionar;

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoExcluir;

    @FXML
    private Button botaoBeber;

    @FXML
    private Button botaoJogar;

    @FXML
    private Button botaoGuti;


    @FXML
    public void voltarMenu() {
        try {
            Stage stage = (Stage) botaoMenu.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/atividadedois/menu.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
