package atividadedois.Controllers;

import atividadedois.Classes.Animal;
import atividadedois.dao.AnimalDAO;
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

public class AnimalController {

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField especieTextField;

    @FXML
    private TextField idadeTextField;

    @FXML
    private TableView<Animal> tabelaAnimal;

    @FXML
    private TableColumn<Animal, String>colNome;

    @FXML
    private TableColumn<Animal, String> colEspecie;

    @FXML
    private TableColumn<Animal, Integer> colIdade;

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

    private AnimalDAO animalDAO = new AnimalDAO();

    private Animal animalSelecionado = null;

    @FXML
    public void initialize(){
    colEspecie.setCellValueFactory(new PropertyValueFactory<>("especie"));
            colIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));
            colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

            tabelaAnimal.setItems(FXCollections.observableArrayList());

            carregarAnimal();
    }

    private void carregarAnimal() {
        try{
            List<Animal> animalList = animalDAO.listar();
            ObservableList<Animal> animal = FXCollections.observableArrayList(animalList);
            tabelaAnimal.setItems(animal);
            tabelaAnimal.refresh();
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
        especieTextField.clear();
        idadeTextField.clear();

    }

    @FXML

    private void adicionarOn(ActionEvent event) {
        String nome = nomeTextField.getText();
        String especie = especieTextField.getText();
        String idade = idadeTextField.getText();

        if (nome.isEmpty() || especie.isEmpty() || idade.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Preencha todos os campos.");
            alertaErro.showAndWait();
            return;

        }

        if (animalSelecionado == null) {
            Animal animal = new Animal();
            animal.setNome(nome);
            animal.setEspecie(especie);
            animal.setIdade(Integer.parseInt(idade));
            animalDAO.adicionar(animal);
        } else {

            animalSelecionado.setNome(nome);
            animalSelecionado.setEspecie(especie);
            animalSelecionado.setIdade(Integer.parseInt(idade));
            animalDAO.editar(animalSelecionado);
            animalSelecionado = null;
        }

        carregarAnimal();
        limparCampos();
    }

    @FXML

    private void editarOn(ActionEvent event){
        animalSelecionado = tabelaAnimal.getSelectionModel().getSelectedItem();

        if (animalSelecionado != null) {
            nomeTextField.setText(animalSelecionado.getNome());
            especieTextField.setText(animalSelecionado.getEspecie());
            idadeTextField.setText(String.valueOf(animalSelecionado.getIdade()));
        } else{
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione um animal para editar.");
            alertaErro.showAndWait();
        }

    }

    @FXML

    private void excluirOn(ActionEvent event) {

        if (animalSelecionado != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("Deseja deletar esse animal?");

            confirmacao.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    animalDAO.excluir(animalSelecionado.getId());
                    carregarAnimal();
                    limparCampos();
                }
            });
        } else {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Selecione um animal para excluir.");
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