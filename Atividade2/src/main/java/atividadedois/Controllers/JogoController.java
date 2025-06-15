package atividadedois.Controllers;

import atividadedois.Classes.Jogo;
import atividadedois.dao.JogoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

public class JogoController {

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField generoTextField;

    @FXML
    private TextField lancaTextField;

    @FXML
    private TableView<Jogo> tabelaJogos;

    @FXML
    private TableColumn<Jogo, String>colNome;

    @FXML
    private TableColumn<Jogo, String> colGenero;

    @FXML
    private TableColumn<Jogo, Integer> colLanca;

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
    private Button botaoJogar;

    @FXML
    private Button botaoReclamar;

    @FXML
    private Button botaoParar;

    private JogoDAO jogoDAO = new JogoDAO();

    private Jogo jogoSelecionado = null;

    @FXML
    public void initialize(){
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colLanca.setCellValueFactory(new PropertyValueFactory<>("ano"));

        tabelaJogos.setItems(FXCollections.observableArrayList());

        carregarJogos();

        tabelaJogos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                jogoSelecionado = newSelection;
            }
        });
    }

    private void carregarJogos() {
        try{
            List<Jogo> jogoList = jogoDAO.listar();
            ObservableList<Jogo> jogo = FXCollections.observableArrayList(jogoList);
            tabelaJogos.setItems(jogo);
            tabelaJogos.refresh();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Não carrega os jogos.");
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

        if (jogoSelecionado == null) {
            Jogo jogo = new Jogo();
            jogo.setNome(nome);
            jogo.setGenero(genero);
            jogo.setAno(Integer.parseInt(ano));
            jogoDAO.adicionar(jogo);
        } else {

            jogoSelecionado.setNome(nome);
            jogoSelecionado.setGenero(genero);
            jogoSelecionado.setAno(Integer.parseInt(ano));
            jogoDAO.editar(jogoSelecionado);
            jogoSelecionado = null;
        }

        carregarJogos();
        limparCampos();
    }

    @FXML

    private void editarOn(ActionEvent event){
        jogoSelecionado = tabelaJogos.getSelectionModel().getSelectedItem();

        if (jogoSelecionado != null) {
            nomeTextField.setText(jogoSelecionado.getNome());
            generoTextField.setText(jogoSelecionado.getGenero());
            lancaTextField.setText(String.valueOf(jogoSelecionado.getAno()));
        } else{
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione um jogo para editar.");
            alertaErro.showAndWait();
        }

    }

    @FXML

    private void excluirOn(ActionEvent event) {

        if (jogoSelecionado != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("Deseja deletar esse jogo?");

            confirmacao.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    jogoDAO.excluir(jogoSelecionado.getId());
                    carregarJogos();
                    limparCampos();
                }
            });
        } else {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione um jogo para excluir.");
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
    private void jogarOn(ActionEvent event) {
        String nome = nomeTextField.getText();
        String genero = generoTextField.getText();
        String ano = lancaTextField.getText();
        if (nome == null || nome.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o nome do jogo.");
            alertaErro.showAndWait();
        } else if(genero == null || genero.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a genero do jogo.");
            alertaErro.showAndWait();
        } else if(ano == null || ano.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a ano do jogo.");
            alertaErro.showAndWait();
        } else {
            String mensagem ="voce jogou " + nome;
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }

    @FXML
    private void reclamarOn(ActionEvent event) {
        String nome = nomeTextField.getText();
        String genero = generoTextField.getText();
        String ano = lancaTextField.getText();
        if (nome == null || nome.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o nome do jogo.");
            alertaErro.showAndWait();
        } else if(genero == null || genero.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a genero do jogo.");
            alertaErro.showAndWait();
        } else if(ano == null || ano.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a ano do jogo.");
            alertaErro.showAndWait();
        } else {
            String mensagem = " esse jogo é &*@&$@(($@* ";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }

    @FXML
    private void pararOn(ActionEvent event) {
        String nome = nomeTextField.getText();
        String genero = generoTextField.getText();
        String ano = lancaTextField.getText();
        if (nome == null || nome.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o nome do jogo.");
            alertaErro.showAndWait();
        } else if(genero == null || genero.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a genero do jogo.");
            alertaErro.showAndWait();
        } else if(ano == null || ano.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a ano do jogo.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "voce parou de jogar!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }
}
