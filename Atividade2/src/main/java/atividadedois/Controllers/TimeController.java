package atividadedois.Controllers;

import atividadedois.Classes.Time;
import atividadedois.dao.TimeDAO;
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

public class TimeController {

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField paisTextField;

    @FXML
    private TextField titulosTextField;

    @FXML
    private TableView<Time> tabelaTimes;

    @FXML
    private TableColumn<Time, String>colNome;

    @FXML
    private TableColumn<Time, String> colPais;

    @FXML
    private TableColumn<Time, Integer> colTitulos;

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
    private Button botaoTorcer;

    @FXML
    private Button botaoComemorar;

    @FXML
    private Button botaoReclamar;

    private TimeDAO timeDAO = new TimeDAO();

    private Time timeSelecionado = null;

    @FXML
    public void initialize(){
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colPais.setCellValueFactory(new PropertyValueFactory<>("pais"));
        colTitulos.setCellValueFactory(new PropertyValueFactory<>("titulos"));

        tabelaTimes.setItems(FXCollections.observableArrayList());

        carregarTime();

        tabelaTimes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                timeSelecionado = newSelection;
            }
        });
    }

    private void carregarTime() {
        try{
            List<Time> timeList = timeDAO.listar();
            ObservableList<Time> time = FXCollections.observableArrayList(timeList);
            tabelaTimes.setItems(time);
            tabelaTimes.refresh();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Não carrega os animais.");
            alertaErro.showAndWait();

        }
    }

    private void limparCampos(){

        nomeTextField.clear();
        paisTextField.clear();
        titulosTextField.clear();

    }

    @FXML

    private void adicionarOn(ActionEvent event) {
        String nome = nomeTextField.getText();
        String pais = paisTextField.getText();
        String titulos = titulosTextField.getText();

        if (nome.isEmpty() || pais.isEmpty() || titulos.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Preencha todos os campos.");
            alertaErro.showAndWait();
            return;

        }

        if (timeSelecionado == null) {
            Time time = new Time();
            time.setNome(nome);
            time.setPais(pais);
            time.setTitulos(Integer.parseInt(titulos));
            timeDAO.adicionar(time);
        } else {

            timeSelecionado.setNome(nome);
            timeSelecionado.setPais(pais);
            timeSelecionado.setTitulos(Integer.parseInt(titulos));
            timeDAO.editar(timeSelecionado);
            timeSelecionado = null;
        }

        carregarTime();
        limparCampos();
    }

    @FXML

    private void editarOn(ActionEvent event){
        timeSelecionado = tabelaTimes.getSelectionModel().getSelectedItem();

        if (timeSelecionado != null) {
            nomeTextField.setText(timeSelecionado.getNome());
            paisTextField.setText(timeSelecionado.getPais());
            titulosTextField.setText(String.valueOf(timeSelecionado.getTitulos()));
        } else{
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione um time para editar.");
            alertaErro.showAndWait();
        }

    }

    @FXML

    private void excluirOn(ActionEvent event) {

        if (timeSelecionado != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("Deseja deletar esse time?");

            confirmacao.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    timeDAO.excluir(timeSelecionado.getId());
                    carregarTime();
                    limparCampos();
                }
            });
        } else {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione um time para excluir.");
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
    private void torcerOn(ActionEvent event) {
        timeSelecionado = tabelaTimes.getSelectionModel().getSelectedItem();

        if (timeSelecionado == null) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione um animal.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "VAMO, VAMO MEU " + timeSelecionado.getNome() + " QUERIDO, SEMPRE ESTAREI CONTIGO, PARA SEMPRE VOU TE AMAR!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }

    @FXML
    private void comemorarOn(ActionEvent event) {
        timeSelecionado = tabelaTimes.getSelectionModel().getSelectedItem();

        if (timeSelecionado == null) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione um animal.");
            alertaErro.showAndWait();
        } else {
            String mensagem ="NA BATIDA...GUUUUUUUUUUUOOOOOOOOOOOOLLLLLLLLLLLLLLLLLLL, DUUUUUUU " + timeSelecionado.getNome();
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }

    @FXML
    private void reclamarOn(ActionEvent event) {
        timeSelecionado = tabelaTimes.getSelectionModel().getSelectedItem();

        if (timeSelecionado == null) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione um animal.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "ta doido, odeio futebol, não sei nem porque assisto esse " + timeSelecionado.getNome() + " ainda...";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }
}
