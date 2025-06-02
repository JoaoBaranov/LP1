package application;

import Controller.AnimalController;
import Controller.CarroController;
import Models.Animal;
import Models.Carro;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {

    private CarroController carroController = new CarroController();
    private AnimalController animalController = new AnimalController();

    @FXML private TextField carroNome, carroModelo, carroAno, carroMarca, carroKm;
    @FXML private ListView<String> listaCarros;

    @FXML private TextField animalNome, animalIdade, animalEspecie, animalPorte;
    @FXML private ListView<String> listaAnimais;

    @FXML
    private void adicionarCarro() {
        String nome = carroNome.getText();
        String modelo = carroModelo.getText();
        int ano = Integer.parseInt(carroAno.getText());
        String marca = carroMarca.getText();
        int km = Integer.parseInt(carroKm.getText());

        Carro carro = new Carro(nome, modelo, ano, marca, km);
        carroController.adicionarCarro(carro);

        listaCarros.getItems().add(nome + " - " + modelo + " (" + ano + ")");
        limparCamposCarro();
    }

    private void limparCamposCarro() {
        carroNome.clear();
        carroModelo.clear();
        carroAno.clear();
        carroMarca.clear();
        carroKm.clear();
    }

    @FXML
    private void adicionarAnimal() {
        String nome = animalNome.getText();
        int idade = Integer.parseInt(animalIdade.getText());
        String especie = animalEspecie.getText();
        String porte = animalPorte.getText();

        Animal animal = new Animal(nome, idade, especie, porte);
        animalController.adicionarAnimal(animal);

        listaAnimais.getItems().add(nome + " - " + especie + " (" + idade + " anos)");
        limparCamposAnimal();
    }

    private void limparCamposAnimal() {
        animalNome.clear();
        animalIdade.clear();
        animalEspecie.clear();
        animalPorte.clear();
    }
}
