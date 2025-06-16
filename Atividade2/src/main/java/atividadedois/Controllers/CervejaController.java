package atividadedois.Controllers;

import atividadedois.Classes.Cerveja;
import atividadedois.dao.CervejaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

public class CervejaController {
    @FXML
    private Button botaoMenu;

    @FXML
    private TextField marcaTextField;

    @FXML
    private TextField origemTextField;

    @FXML
    private TextField teorTextField;

    @FXML
    private TableView<Cerveja> tabelaCervejas;

    @FXML
    private TableColumn<Cerveja, String> colOrigem;

    @FXML
    private TableColumn<Cerveja, String> colMarca;

    @FXML
    private TableColumn<Cerveja, Integer> colTeor;

    @FXML
    private Button botaoAdicionar;

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoExcluir;

    @FXML
    private Button botaoBeber;

    @FXML
    private Button botaoJogar;

    @FXML
    private Button botaoGuti;

    private CervejaDAO cervejaDAO = new CervejaDAO();

    private Cerveja cervejaSelecionado = null;

    @FXML
    public void initialize(){
        colOrigem.setCellValueFactory(new PropertyValueFactory<>("origem"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colTeor.setCellValueFactory(new PropertyValueFactory<>("teor"));

        tabelaCervejas.setItems(FXCollections.observableArrayList());

        carregarCerveja();

        tabelaCervejas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                cervejaSelecionado = newSelection;
            }
        });
    }

    private void carregarCerveja() {
        try{
            List<Cerveja> cervejaList = cervejaDAO.listar();
            ObservableList<Cerveja> cerveja = FXCollections.observableArrayList(cervejaList);
            tabelaCervejas.setItems(cerveja);
            tabelaCervejas.refresh();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Não carrega as cervejas.");
            alertaErro.showAndWait();

        }
    }

    private void limparCampos(){

        origemTextField.clear();
        marcaTextField.clear();
        teorTextField.clear();

    }

    @FXML

    private void adicionarOn(ActionEvent event) {
        String origem = origemTextField.getText();
        String marca = marcaTextField.getText();
        String teor = teorTextField.getText();

        if (origem.isEmpty() || marca.isEmpty() || teor.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Preencha todos os campos.");
            alertaErro.showAndWait();
            return;

        }

        if (cervejaSelecionado == null) {
            Cerveja cerveja = new Cerveja();
            cerveja.setOrigem(origem);
            cerveja.setMarca(marca);
            cerveja.setTeor(Integer.parseInt(teor));
            cervejaDAO.adicionar(cerveja);
        } else {

            cervejaSelecionado.setOrigem(origem);
            cervejaSelecionado.setMarca(marca);
            cervejaSelecionado.setTeor(Integer.parseInt(teor));
            cervejaDAO.editar(cervejaSelecionado);
            cervejaSelecionado = null;
        }

        carregarCerveja();
        limparCampos();
    }

    @FXML

    private void editarOn(ActionEvent event){
        cervejaSelecionado = tabelaCervejas.getSelectionModel().getSelectedItem();

        if (cervejaSelecionado != null) {
            origemTextField.setText(cervejaSelecionado.getOrigem());
            marcaTextField.setText(cervejaSelecionado.getMarca());
            teorTextField.setText(String.valueOf(cervejaSelecionado.getTeor()));
        } else{
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione uma cerveja para editar.");
            alertaErro.showAndWait();
        }

    }

    @FXML

    private void excluirOn(ActionEvent event) {

        if (cervejaSelecionado != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("Deseja deletar essa cerveja?");

            confirmacao.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    cervejaDAO.excluir(cervejaSelecionado.getId());
                    carregarCerveja();
                    limparCampos();
                }
            });
        } else {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione uma cerveja para excluir.");
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
    private void beberOn(ActionEvent event) {
        cervejaSelecionado = tabelaCervejas.getSelectionModel().getSelectedItem();

        if (cervejaSelecionado == null) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione uma cerveja.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "voce bebeu a cerveja geladinha!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }

    @FXML
    private void jogarOn(ActionEvent event) {
        cervejaSelecionado = tabelaCervejas.getSelectionModel().getSelectedItem();
        if (cervejaSelecionado == null) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione uma cerveja.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "que errado, jogou a brejinha fora...";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }

    @FXML
    private void gutiOn(ActionEvent event) {
        cervejaSelecionado = tabelaCervejas.getSelectionModel().getSelectedItem();
        if (cervejaSelecionado == null) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione uma cerveja.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "eita rapaz, ta tudo bem? voce parece meio beudo.";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }

}

