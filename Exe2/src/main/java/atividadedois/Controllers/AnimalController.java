package atividadedois.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AnimalController {

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField especieTextField;

    @FXML
    private TextField idadeTextField;

    @FXML
    private TableView<?> tabelaAnimais;

    @FXML
    private TableColumn<?, ?> colunaNome;

    @FXML
    private TableColumn<?, ?> colunaEspecie;

    @FXML
    private TableColumn<?, ?> colunaIdade;

    @FXML
    private ImageView imageView;

    @FXML
    private Button botaoMenu;

    @FXML
    private Button botaoAdicionar;

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoExcluir;

    @FXML
    private Button botaoCarinho;

    @FXML
    private Button botaoBrincar;

    @FXML
    private Button botaoAlimentar;


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
    private void carinhoOn(ActionEvent event) {
        String nome = nomeTextField.getText();
        String especie = especieTextField.getText();
        String idade = idadeTextField.getText();
        if (nome == null || nome.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o nome do animal.");
            alertaErro.showAndWait();
        } else if(especie == null || especie.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a especie do animal.");
            alertaErro.showAndWait();
        } else if(idade == null || idade.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a idade do animal.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " recebeu carinho, que fofura!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }

    @FXML
    private void brincarOn(ActionEvent event) {
        String nome = nomeTextField.getText();
        String especie = especieTextField.getText();
        String idade = idadeTextField.getText();
        if (nome == null || nome.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o nome do animal.");
            alertaErro.showAndWait();
        } else if(especie == null || especie.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a especie do animal.");
            alertaErro.showAndWait();
        } else if(idade == null || idade.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a idade do animal.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " recebeu carinho, que fofura!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }

    @FXML
    private void alimentarOn(ActionEvent event) {
        String nome = nomeTextField.getText();
        String especie = especieTextField.getText();
        String idade = idadeTextField.getText();
        if (nome == null || nome.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o nome do animal.");
            alertaErro.showAndWait();
        } else if(especie == null || especie.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a especie do animal.");
            alertaErro.showAndWait();
        } else if(idade == null || idade.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a idade do animal.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " recebeu carinho, que fofura!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }
}