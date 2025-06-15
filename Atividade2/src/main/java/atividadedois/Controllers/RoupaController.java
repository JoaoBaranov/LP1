package atividadedois.Controllers;

import atividadedois.Classes.Roupa;
import atividadedois.dao.RoupaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

public class RoupaController {

    @FXML
    private TextField tipoTextField;

    @FXML
    private TextField corTextField;

    @FXML
    private TextField tamanhoTextField;

    @FXML
    private TableView<Roupa> tabelaRoupas;

    @FXML
    private TableColumn<Roupa, String>colTipo;

    @FXML
    private TableColumn<Roupa, String> colCor;

    @FXML
    private TableColumn<Roupa, Integer> colTamanho;

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
    private Button botaoVestir;

    @FXML
    private Button botaoTrocar;

    @FXML
    private Button botaoComprar;

    private RoupaDAO roupaDao = new RoupaDAO();

    private Roupa roupaSelecionado = null;

    @FXML
    public void initialize(){
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        colTamanho.setCellValueFactory(new PropertyValueFactory<>("tamanho"));

        tabelaRoupas.setItems(FXCollections.observableArrayList());

        carregarRoupa();

        tabelaRoupas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                roupaSelecionado = newSelection;
            }
        });
    }

    private void carregarRoupa() {
        try{
            List<Roupa> roupaList = roupaDao.listar();
            ObservableList<Roupa> roupa = FXCollections.observableArrayList(roupaList);
            tabelaRoupas.setItems(roupa);
            tabelaRoupas.refresh();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Não carrega as roupas.");
            alertaErro.showAndWait();

        }
    }

    private void limparCampos(){

        tipoTextField.clear();
        corTextField.clear();
        tamanhoTextField.clear();

    }

    @FXML

    private void adicionarOn(ActionEvent event) {
        String tipo = tipoTextField.getText();
        String cor = corTextField.getText();
        String tamanho = tamanhoTextField.getText();

        if (tipo.isEmpty() || cor.isEmpty() || tamanho.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Preencha todos os campos.");
            alertaErro.showAndWait();
            return;

        }

        if (roupaSelecionado == null) {
            Roupa roupa = new Roupa();
            roupa.setTipo(tipo);
            roupa.setCor(cor);
            roupa.setTamanho(Integer.parseInt(tamanho));
            roupaDao.adicionar(roupa);
        } else {

            roupaSelecionado.setTipo(tipo);
            roupaSelecionado.setCor(cor);
            roupaSelecionado.setTamanho(Integer.parseInt(tamanho));
            roupaDao.editar(roupaSelecionado);
            roupaSelecionado = null;
        }

        carregarRoupa();
        limparCampos();
    }

    @FXML

    private void editarOn(ActionEvent event){
        roupaSelecionado = tabelaRoupas.getSelectionModel().getSelectedItem();

        if (roupaSelecionado != null) {
            tipoTextField.setText(roupaSelecionado.getTipo());
            corTextField.setText(roupaSelecionado.getCor());
            tamanhoTextField.setText(String.valueOf(roupaSelecionado.getTamanho()));
        } else{
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione uma roupa para editar.");
            alertaErro.showAndWait();
        }

    }

    @FXML

    private void excluirOn(ActionEvent event) {

        if (roupaSelecionado != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("Deseja deletar essa roupa?");

            confirmacao.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    roupaDao.excluir(roupaSelecionado.getId());
                    carregarRoupa();
                    limparCampos();
                }
            });
        } else {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione uma roupa para excluir.");
            alertaErro.showAndWait();


        }
    }
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
    private void vestirOn(ActionEvent event) {
        String tipo = tipoTextField.getText();
        String cor = corTextField.getText();
        String tamanho = tamanhoTextField.getText();
        if (tipo == null || tipo.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o tipo da roupa.");
            alertaErro.showAndWait();
        } else if(cor == null || cor.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a cor da roupa.");
            alertaErro.showAndWait();
        } else if(tamanho == null || tamanho.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a tamanho da roupa.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "voce vestiu " + tipo + cor;
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }

    @FXML
    private void trocarOn(ActionEvent event) {
        String tipo = tipoTextField.getText();
        String cor = corTextField.getText();
        String tamanho = tamanhoTextField.getText();
        if (tipo == null || tipo.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o tipo da roupa.");
            alertaErro.showAndWait();
        } else if(cor == null || cor.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a cor da roupa.");
            alertaErro.showAndWait();
        } else if(tamanho == null || tamanho.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a tamanho da roupa.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "procure outro modelo do seu gosto.";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }

    @FXML
    private void comprarOn(ActionEvent event) {
        String tipo = tipoTextField.getText();
        String cor = corTextField.getText();
        String tamanho = tamanhoTextField.getText();
        if (tipo == null || tipo.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o tipo da roupa.");
            alertaErro.showAndWait();
        } else if(cor == null || cor.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a cor da roupa.");
            alertaErro.showAndWait();
        } else if(tamanho == null || tamanho.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a tamanho da roupa.");
            alertaErro.showAndWait();
        } else {
            String mensagem = tipo + cor + " foi comprada, curta sua compra!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }
}
