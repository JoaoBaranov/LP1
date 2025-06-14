package atividadedois.Controllers;

import atividadedois.Classes.Calcado;
import atividadedois.dao.CalcadoDAO;
import java.io.IOException;
import java.util.List;


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



public class CalcadoController {

    @FXML
    private TextField marcaTextField;

    @FXML
    private TextField modeloTextField;

    @FXML
    private TextField tamanhoTextField;

    @FXML
    private TableView<Calcado> tabelaCalcados;

    @FXML
    private TableColumn<Calcado, String> colMarca;

    @FXML
    private TableColumn<?, ?> colModelo;

    @FXML
    private TableColumn<?, ?> colTamanho;

    @FXML
    private Button botaoAdicionar;

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoExcluir;

    @FXML
    private Button botaoBotar;

    @FXML
    private Button botaoTestar;

    @FXML
    private Button botaoEspelho;

    @FXML
    private Button botaoMenu;

    private Calcado calcadoSelecionado = null;

    private CalcadoDAO calcadoDAO = new CalcadoDAO();

    @FXML
    public void initialize(){
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colTamanho.setCellValueFactory(new PropertyValueFactory<>("tamanho"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));

        tabelaCalcados.setItems(FXCollections.observableArrayList());

        carregarCalcado();
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

    private void carregarCalcado() {
        try{
            List<Calcado> calcadoList = calcadoDAO.listar();
            ObservableList<Calcado> calcado = FXCollections.observableArrayList(calcadoList);
            tabelaCalcados.setItems(calcado);
            tabelaCalcados.refresh();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Não carrega os calçados.");
            alertaErro.showAndWait();

        }
    }

    private void limparCampos(){

        marcaTextField.clear();
        modeloTextField.clear();
        tamanhoTextField.clear();

    }

    @FXML

    private void adicionarOn(ActionEvent event) {
        String marca = marcaTextField.getText();
        String modelo = modeloTextField.getText();
        String tamanho = tamanhoTextField.getText();

        if (marca.isEmpty() || modelo.isEmpty() || tamanho.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Preencha todos os campos.");
            alertaErro.showAndWait();
            return;

        }

        if (calcadoSelecionado == null) {
            Calcado calcado = new Calcado();
            calcado.setMarca(marca);
            calcado.setModelo(modelo);
            calcado.setTamanho(Integer.parseInt(tamanho));
            calcadoDAO.adicionar(calcado);
        } else {

            calcadoSelecionado.setMarca(marca);
            calcadoSelecionado.setModelo(modelo);
            calcadoSelecionado.setTamanho(Integer.parseInt(tamanho));
            calcadoDAO.editar(calcadoSelecionado);
            calcadoSelecionado = null;
        }

        carregarCalcado();
        limparCampos();
    }

    @FXML

    private void editarOn(ActionEvent event){
        calcadoSelecionado = tabelaCalcados.getSelectionModel().getSelectedItem();

        if (calcadoSelecionado != null) {
            marcaTextField.setText(calcadoSelecionado.getMarca());
            modeloTextField.setText(calcadoSelecionado.getModelo());
            tamanhoTextField.setText(String.valueOf(calcadoSelecionado.getTamanho()));
        } else{
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione um calçado para editar.");
            alertaErro.showAndWait();
        }

    }

    @FXML

    private void excluirOn(ActionEvent event) {

        if (calcadoSelecionado != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("Deseja deletar esse calçado?");

            confirmacao.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    calcadoDAO.excluir(calcadoSelecionado.getId());
                    carregarCalcado();
                    limparCampos();
                }
            });
        } else {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione um calçado para excluir.");
            alertaErro.showAndWait();


        }
    }

    @FXML
    private void botarOn(ActionEvent event) {
        String marca = marcaTextField.getText();
        String modelo = modeloTextField.getText();
        String tamanho = tamanhoTextField.getText();
        if (marca == null || marca.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a marca do calçado.");
            alertaErro.showAndWait();
        } else if(modelo == null || modelo.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o modelo do calçado.");
            alertaErro.showAndWait();
        } else if(tamanho == null || tamanho.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o tamanho do calçado.");
            alertaErro.showAndWait();
        } else {
            String mensagem = " Você colocou o(a) " + modelo;
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }

    @FXML
    private void testarOn(ActionEvent event) {
        String marca = marcaTextField.getText();
        String modelo = modeloTextField.getText();
        String tamanho = tamanhoTextField.getText();
        if (marca == null || marca.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a marca do calçado.");
            alertaErro.showAndWait();
        } else if(modelo == null || modelo.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o modelo do calçado.");
            alertaErro.showAndWait();
        } else if(tamanho == null || tamanho.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o tamanho do calçado.");
            alertaErro.showAndWait();
        } else {
            String mensagem = " É FUGAAAA, você correu da loja com o(a) " + modelo;
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }
    @FXML
    private void espelhoOn(ActionEvent event) {
        String marca = marcaTextField.getText();
        String modelo = modeloTextField.getText();
        String tamanho = tamanhoTextField.getText();
        if (marca == null || marca.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe a marca do calçado.");
            alertaErro.showAndWait();
        } else if(modelo == null || modelo.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o modelo do calçado.");
            alertaErro.showAndWait();
        } else if(tamanho == null || tamanho.trim().isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Informe o tamanho do calçado.");
            alertaErro.showAndWait();
        } else {
            String mensagem = " Você experimentou o(a) " + modelo + ", agora está na moda!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }

    }

    }



