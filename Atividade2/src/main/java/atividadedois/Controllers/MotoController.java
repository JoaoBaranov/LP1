package atividadedois.Controllers;

import atividadedois.Classes.Moto;
import atividadedois.dao.MotoDAO;
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

public class MotoController {

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField marcaTextField;

    @FXML
    private TextField cilTextField;

    @FXML
    private TableView<Moto> tabelaMotos;

    @FXML
    private TableColumn<Moto, String>colNome;

    @FXML
    private TableColumn<Moto, String> colMarca;

    @FXML
    private TableColumn<Moto, Integer> colCil;

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
    private Button botaoAcelerar;

    @FXML
    private Button botaoFrear;

    @FXML
    private Button botaoEmpinar;

    private MotoDAO motoDAO = new MotoDAO();

    private Moto motoSelecionado = null;

    @FXML
    public void initialize(){
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colCil.setCellValueFactory(new PropertyValueFactory<>("cilindrada"));

        tabelaMotos.setItems(FXCollections.observableArrayList());

        carregarMoto();

        tabelaMotos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                motoSelecionado = newSelection;
            }
        });
    }

    private void carregarMoto() {
        try{
            List<Moto> motoList = motoDAO.listar();
            ObservableList<Moto> moto = FXCollections.observableArrayList(motoList);
            tabelaMotos.setItems(moto);
            tabelaMotos.refresh();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Não carrega as motos.");
            alertaErro.showAndWait();

        }
    }

    private void limparCampos(){

        nomeTextField.clear();
        marcaTextField.clear();
        cilTextField.clear();

    }

    @FXML

    private void adicionarOn(ActionEvent event) {
        String nome = nomeTextField.getText();
        String marca = marcaTextField.getText();
        String cilindrada = cilTextField.getText();

        if (nome.isEmpty() || marca.isEmpty() || cilindrada.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Preencha todos os campos.");
            alertaErro.showAndWait();
            return;

        }

        if (motoSelecionado == null) {
            Moto moto = new Moto();
            moto.setNome(nome);
            moto.setMarca(marca);
            moto.setCilindrada(Integer.parseInt(cilindrada));
            motoDAO.adicionar(moto);
        } else {

            motoSelecionado.setNome(nome);
            motoSelecionado.setMarca(marca);
            motoSelecionado.setCilindrada(Integer.parseInt(cilindrada));
            motoDAO.editar(motoSelecionado);
            motoSelecionado = null;
        }

        carregarMoto();
        limparCampos();
    }

    @FXML

    private void editarOn(ActionEvent event){
        motoSelecionado = tabelaMotos.getSelectionModel().getSelectedItem();

        if (motoSelecionado != null) {
            nomeTextField.setText(motoSelecionado.getNome());
            marcaTextField.setText(motoSelecionado.getMarca());
            cilTextField.setText(String.valueOf(motoSelecionado.getCilindrada()));
        } else{
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione uma moto para editar.");
            alertaErro.showAndWait();
        }

    }

    @FXML

    private void excluirOn(ActionEvent event) {

        if (motoSelecionado != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("Deseja deletar essa moto?");

            confirmacao.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    motoDAO.excluir(motoSelecionado.getId());
                    carregarMoto();
                    limparCampos();
                }
            });
        } else {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione uma moto para excluir.");
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
        String cilindrada = cilTextField.getText();
        if (nome == null || nome.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o nome da moto.");
            alertaErro.showAndWait();
        } else if(marca == null || marca.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a marca da moto.");
            alertaErro.showAndWait();
        } else if(cilindrada == null || cilindrada.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a cilindrada da moto.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "voce acelerou a " + nome;
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
        String cilindrada = cilTextField.getText();
        if (nome == null || nome.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o nome da moto.");
            alertaErro.showAndWait();
        } else if(marca == null || marca.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a marca da moto.");
            alertaErro.showAndWait();
        } else if(cilindrada == null || cilindrada.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a cilindrada da moto.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " derrapou, mas conseguiu frear a tempo!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }

    @FXML
    private void empinarOn(ActionEvent event) {
        String nome = nomeTextField.getText();
        String marca = nomeTextField.getText();
        String cilindrada = cilTextField.getText();
        if (nome == null || nome.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o nome da moto.");
            alertaErro.showAndWait();
        } else if(marca == null || marca.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a marca da moto.");
            alertaErro.showAndWait();
        } else if(cilindrada == null || cilindrada.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a cilindrada da moto.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "Voce chamou a " + nome + " no grau, ran dam dam";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }
}
