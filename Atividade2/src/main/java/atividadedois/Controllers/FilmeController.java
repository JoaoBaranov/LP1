package atividadedois.Controllers;

import atividadedois.Classes.Filme;
import atividadedois.dao.FilmeDAO;
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

public class FilmeController {

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField generoTextField;

    @FXML
    private TextField lancaTextField;

    @FXML
    private TableView<Filme> tabelaFilmes;

    @FXML
    private TableColumn<Filme, String>colNome;

    @FXML
    private TableColumn<Filme, String> colGenero;

    @FXML
    private TableColumn<Filme, Integer> colLanca;

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
    private Button botaoPipoca;

    @FXML
    private Button botaoCoca;

    @FXML
    private Button botaoAssistir;

    private FilmeDAO filmeDAO = new FilmeDAO();

    private Filme filmeSelecionado = null;

    @FXML
    public void initialize(){
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colLanca.setCellValueFactory(new PropertyValueFactory<>("ano"));

        tabelaFilmes.setItems(FXCollections.observableArrayList());

        carregarFilme();

        tabelaFilmes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                filmeSelecionado = newSelection;
            }
        });
    }

    private void carregarFilme() {
        try{
            List<Filme> filmeList = filmeDAO.listar();
            ObservableList<Filme> filme = FXCollections.observableArrayList(filmeList);
            tabelaFilmes.setItems(filme);
            tabelaFilmes.refresh();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Não carrega o filme.");
            alertaErro.showAndWait();

        }
    }

    private void limparCampos(){

        nomeTextField.clear();
        generoTextField.clear();
        lancaTextField.clear();

    }

    @FXML

    private void adicionarOn(ActionEvent event) {
        String nome = nomeTextField.getText();
        String genero = generoTextField.getText();
        String ano = lancaTextField.getText();

        if (nome.isEmpty() || genero.isEmpty() || ano.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Preencha todos os campos.");
            alertaErro.showAndWait();
            return;

        }

        if (filmeSelecionado == null) {
            Filme filme = new Filme();
            filme.setNome(nome);
            filme.setGenero(genero);
            filme.setAno(Integer.parseInt(ano));
            filmeDAO.adicionar(filme);
        } else {

            filmeSelecionado.setNome(nome);
            filmeSelecionado.setGenero(genero);
            filmeSelecionado.setAno(Integer.parseInt(ano));
            filmeDAO.editar(filmeSelecionado);
            filmeSelecionado = null;
        }

        carregarFilme();
        limparCampos();
    }

    @FXML

    private void editarOn(ActionEvent event){
        filmeSelecionado = tabelaFilmes.getSelectionModel().getSelectedItem();

        if (filmeSelecionado != null) {
            nomeTextField.setText(filmeSelecionado.getNome());
            generoTextField.setText(filmeSelecionado.getGenero());
            lancaTextField.setText(String.valueOf(filmeSelecionado.getAno()));
        } else{
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione um filme para editar.");
            alertaErro.showAndWait();
        }

    }

    @FXML

    private void excluirOn(ActionEvent event) {

        if (filmeSelecionado != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("Deseja deletar esse filme?");

            confirmacao.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    filmeDAO.excluir(filmeSelecionado.getId());
                    carregarFilme();
                    limparCampos();
                }
            });
        } else {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione um filme para excluir.");
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
    private void pipocaOn(ActionEvent event) {
        filmeSelecionado = tabelaFilmes.getSelectionModel().getSelectedItem();
        if (filmeSelecionado == null) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione um filme.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "voce pegou pipoca, nham nham.";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }

    @FXML
    private void cocaOn(ActionEvent event) {
        filmeSelecionado = tabelaFilmes.getSelectionModel().getSelectedItem();
        if (filmeSelecionado == null) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione um filme.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "voce comprou coquinha gelada, hummm";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }

    @FXML
    private void assistirOn(ActionEvent event) {
        filmeSelecionado = tabelaFilmes.getSelectionModel().getSelectedItem();
        if (filmeSelecionado == null) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione um filme.");
            alertaErro.showAndWait();
        } else {
            String mensagem ="voce irá assistir " + filmeSelecionado.getNome();
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }
}
