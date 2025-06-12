package atividadedois.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


public class CarroController {
    @FXML
    private Button botaoMenu;

    @FXML
    private TextField marcaTextField;

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField anoTextField;

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
    private Button botaoAcelerar;

    @FXML
    private Button botaoFrear;

    @FXML
    private Button botaoBuzinar;


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
    private void acelerarOn(ActionEvent event) {
        String nome = nomeTextField.getText();
        String marca = marcaTextField.getText();
        String ano = anoTextField.getText();
        if (nome == null || nome.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o nome do carro.");
            alertaErro.showAndWait();
        } else if(marca == null || marca.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a marca do carro.");
            alertaErro.showAndWait();
        } else if(ano == null || ano.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o ano do carro.");
            alertaErro.showAndWait();
        } else {
            String mensagem = " Você acelerou o " + nome;
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }

    @FXML
    private void frearOn(ActionEvent event) {
        String nome = nomeTextField.getText();
        String marca = marcaTextField.getText();
        String ano = anoTextField.getText();
        if (nome == null || nome.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o nome do carro.");
            alertaErro.showAndWait();
        } else if(marca == null || marca.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a marca do carro.");
            alertaErro.showAndWait();
        } else if(ano == null || ano.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o ano do carro.");
            alertaErro.showAndWait();
        } else {
            String mensagem = " Você freou o " + nome;
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }

    @FXML
    private void buzinarOn(ActionEvent event) {
        String nome = nomeTextField.getText();
        String marca = marcaTextField.getText();
        String ano = anoTextField.getText();
        if (nome == null || nome.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o nome do carro.");
            alertaErro.showAndWait();
        } else if(marca == null || marca.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a marca do carro.");
            alertaErro.showAndWait();
        } else if(ano == null || ano.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o ano do carro.");
            alertaErro.showAndWait();
        } else {
            String mensagem = " Bi bi bi!!! Sai da frente tartaruga";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }
}

