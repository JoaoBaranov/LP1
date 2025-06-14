package atividadedois.Controllers;


import atividadedois.Classes.Carro;
import atividadedois.dao.CarroDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


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
    private TableView<Carro> tabelaCarros;

    @FXML
    private TableColumn<Carro, String> colMarca;

    @FXML
    private TableColumn<Carro, String> colNome;

    @FXML
    private TableColumn<Carro, Integer> colAno;

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

    private CarroDAO carroDAO = new CarroDAO();

    private Carro carroSelecionado = null;

    @FXML
    public void initialize(){
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        tabelaCarros.setItems(FXCollections.observableArrayList());

        carregarCarro();
    }

    private void carregarCarro() {
        try{
            List<Carro> carroList = carroDAO.listar();
            ObservableList<Carro> carro = FXCollections.observableArrayList(carroList);
            tabelaCarros.setItems(carro);
            tabelaCarros.refresh();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Não carrega os carros.");
            alertaErro.showAndWait();

        }
    }

    private void limparCampos(){

        nomeTextField.clear();
        marcaTextField.clear();
        anoTextField.clear();

    }

    @FXML

    private void adicionarOn(ActionEvent event) {
        String nome = nomeTextField.getText();
        String marca = marcaTextField.getText();
        String ano = anoTextField.getText();

        if (nome.isEmpty() || marca.isEmpty() || ano.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Preencha todos os campos.");
            alertaErro.showAndWait();
            return;

        }

        if (carroSelecionado == null) {
            Carro carro = new Carro();
            carro.setNome(nome);
            carro.setMarca(marca);
            carro.setAno(Integer.parseInt(ano));
            carroDAO.adicionar(carro);
        } else {

            carroSelecionado.setNome(nome);
            carroSelecionado.setMarca(marca);
            carroSelecionado.setAno(Integer.parseInt(ano));
            carroDAO.editar(carroSelecionado);
            carroSelecionado = null;
        }

        carregarCarro();
        limparCampos();
    }

    @FXML

    private void editarOn(ActionEvent event){
        carroSelecionado = tabelaCarros.getSelectionModel().getSelectedItem();

        if (carroSelecionado != null) {
            nomeTextField.setText(carroSelecionado.getNome());
            marcaTextField.setText(carroSelecionado.getMarca());
            anoTextField.setText(String.valueOf(carroSelecionado.getAno()));
        } else{
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione um carro para editar.");
            alertaErro.showAndWait();
        }

    }

    @FXML

    private void excluirOn(ActionEvent event) {

        if (carroSelecionado != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("Deseja deletar esse carro?");

            confirmacao.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    carroDAO.excluir(carroSelecionado.getId());
                    carregarCarro();
                    limparCampos();
                }
            });
        } else {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione um carro para excluir.");
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

