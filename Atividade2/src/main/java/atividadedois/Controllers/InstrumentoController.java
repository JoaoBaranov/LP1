package atividadedois.Controllers;

import atividadedois.Classes.Instrumento;
import atividadedois.dao.InstrumentoDAO;
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

public class InstrumentoController {

    @FXML
    private TextField instrumentoTextFIeld;

    @FXML
    private TextField tipoTextFIeld;

    @FXML
    private TextField marcaTextField;

    @FXML
    private TableView<Instrumento> tabelaInstrumentos;

    @FXML
    private TableColumn<Instrumento, String>colInstrumento;

    @FXML
    private TableColumn<Instrumento, String> colTipo;

    @FXML
    private TableColumn<Instrumento, String> colMarca;

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
    private Button botaoAfinar;

    @FXML
    private Button botaoLimpar;

    @FXML
    private Button botaoTocar;

    private InstrumentoDAO instrumentoDAO = new InstrumentoDAO();

    private Instrumento instrumentoSelecionado = null;

    @FXML
    public void initialize(){
        colInstrumento.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));

        tabelaInstrumentos.setItems(FXCollections.observableArrayList());

        carregarInstrumento();

        tabelaInstrumentos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                instrumentoSelecionado = newSelection;
            }
        });
    }

    private void carregarInstrumento() {
        try{
            List<Instrumento> instrumentoList = instrumentoDAO.listar();
            ObservableList<Instrumento> instrumento = FXCollections.observableArrayList(instrumentoList);
            tabelaInstrumentos.setItems(instrumento);
            tabelaInstrumentos.refresh();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Não carrega o instrumento.");
            alertaErro.showAndWait();

        }
    }

    private void limparCampos(){

        instrumentoTextFIeld.clear();
        tipoTextFIeld.clear();
        marcaTextField.clear();

    }

    @FXML

    private void adicionarOn(ActionEvent event) {
        String nome = instrumentoTextFIeld.getText();
        String tipo = tipoTextFIeld.getText();
        String marca = marcaTextField.getText();

        if (nome.isEmpty() || tipo.isEmpty() || marca.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Preencha todos os campos.");
            alertaErro.showAndWait();
            return;

        }

        if (instrumentoSelecionado == null) {
            Instrumento instrumento = new Instrumento();
            instrumento.setNome(nome);
            instrumento.setTipo(tipo);
            instrumento.setMarca(marca);
            instrumentoDAO.adicionar(instrumento);
        } else {

            instrumentoSelecionado.setNome(nome);
            instrumentoSelecionado.setTipo(tipo);
            instrumentoSelecionado.setMarca(marca);
            instrumentoDAO.editar(instrumentoSelecionado);
            instrumentoSelecionado = null;
        }

        carregarInstrumento();
        limparCampos();
    }

    @FXML

    private void editarOn(ActionEvent event){
        instrumentoSelecionado = tabelaInstrumentos.getSelectionModel().getSelectedItem();

        if (instrumentoSelecionado != null) {
            instrumentoTextFIeld.setText(instrumentoSelecionado.getNome());
            tipoTextFIeld.setText(instrumentoSelecionado.getTipo());
            marcaTextField.setText(instrumentoSelecionado.getMarca());
        } else{
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione um instrumento para editar.");
            alertaErro.showAndWait();
        }

    }

    @FXML

    private void excluirOn(ActionEvent event) {

        if (instrumentoSelecionado != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("Deseja deletar esse instrumento?");

            confirmacao.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    instrumentoDAO.excluir(instrumentoSelecionado.getId());
                    carregarInstrumento();
                    limparCampos();
                }
            });
        } else {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione um instrumento para excluir.");
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
    private void afinarOn(ActionEvent event) {
        String nome = instrumentoTextFIeld.getText();
        String tipo = tipoTextFIeld.getText();
        String marca = marcaTextField.getText();
        if (nome == null || nome.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o nome do instrumento.");
            alertaErro.showAndWait();
        } else if(tipo == null || tipo.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a tipo do instrumento.");
            alertaErro.showAndWait();
        } else if(marca == null || marca.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a marca do instrumento.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " foi afinado!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }

    @FXML
    private void limparOn(ActionEvent event) {
        String nome = instrumentoTextFIeld.getText();
        String tipo = tipoTextFIeld.getText();
        String marca = marcaTextField.getText();
        if (nome == null || nome.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o nome do instrumento.");
            alertaErro.showAndWait();
        } else if(tipo == null || tipo.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a tipo do instrumento.");
            alertaErro.showAndWait();
        } else if(marca == null || marca.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a marca do instrumento.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " foi limpado!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }

    @FXML
    private void tocarOn(ActionEvent event) {
        String nome = instrumentoTextFIeld.getText();
        String tipo = tipoTextFIeld.getText();
        String marca = marcaTextField.getText();
        if (nome == null || nome.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o nome do instrumento.");
            alertaErro.showAndWait();
        } else if(tipo == null || tipo.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a tipo do instrumento.");
            alertaErro.showAndWait();
        } else if(marca == null || marca.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a marca do instrumento.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " foi tocado, tan tan!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }
}
