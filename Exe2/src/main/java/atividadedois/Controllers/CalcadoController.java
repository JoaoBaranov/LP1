package atividadedois.Controllers;

import java.io.IOException;
import atividadedois.Classes.Animal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;


public class CalcadoController {

    @FXML
    private TextField marcaTextField;

    @FXML
    private TextField modeloTextField;

    @FXML
    private TextField tamanhoTextField;

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
    private Button botaoBotar;

    @FXML
    private Button botaoTestar;

    @FXML
    private Button botaoEspelho;

    @FXML
    private Button botaoMenu;


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

    @FXML
    private void botarOn(ActionEvent event) {
        String marca = marcaTextField.getText();
        String modelo = modeloTextField.getText();
        String tamanho = tamanhoTextField.getText();
        if (marca == null || marca.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a marca do calçado.");
            alertaErro.showAndWait();
        } else if(modelo == null || modelo.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o modelo do calçado.");
            alertaErro.showAndWait();
        } else if(tamanho == null || tamanho.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o tamanho do calçado.");
            alertaErro.showAndWait();
        } else {
            String mensagem = " Você colocou o(a) " + modelo;
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }

    @FXML
    private void testarOn(ActionEvent event) {
        String marca = marcaTextField.getText();
        String modelo = modeloTextField.getText();
        String tamanho = tamanhoTextField.getText();
        if (marca == null || marca.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a marca do calçado.");
            alertaErro.showAndWait();
        } else if(modelo == null || modelo.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o modelo do calçado.");
            alertaErro.showAndWait();
        } else if(tamanho == null || tamanho.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o tamanho do calçado.");
            alertaErro.showAndWait();
        } else {
            String mensagem = " É FUGAAAA, você correu da loja com o(a) " + modelo;
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }
    @FXML
    private void espelhoOn(ActionEvent event) {
        String marca = marcaTextField.getText();
        String modelo = modeloTextField.getText();
        String tamanho = tamanhoTextField.getText();
        if (marca == null || marca.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a marca do calçado.");
            alertaErro.showAndWait();
        } else if(modelo == null || modelo.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o modelo do calçado.");
            alertaErro.showAndWait();
        } else if(tamanho == null || tamanho.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o tamanho do calçado.");
            alertaErro.showAndWait();
        } else {
            String mensagem = " Você experimentou o(a) " + modelo + ", agora está na moda!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }

    }



