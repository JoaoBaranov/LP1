package Controller;

import Models.Animal;
import java.util.ArrayList;
import java.util.List;

public class AnimalController {

    private List<Animal> animais = new ArrayList<>();

    // Adiciona um novo animal (subclasse de Animal)
    public void adicionarAnimal(Animal animal) {
        animais.add(animal);
    }

    // Lista todos os animais
    public List<Animal> listarAnimais() {
        return animais;
    }

    // Busca um animal pelo nome
    public Animal buscarAnimalPorNome(String nome) {
        for (Animal animal : animais) {
            if (animal.getNome().equalsIgnoreCase(nome)) {
                return animal;
            }
        }
        return null;
    }

    // Atualiza os dados de um animal existente
    public boolean atualizarAnimal(String nome, Animal novoAnimal) {
        for (int i = 0; i < animais.size(); i++) {
            if (animais.get(i).getNome().equalsIgnoreCase(nome)) {
                animais.set(i, novoAnimal);
                return true;
            }
        }
        return false;
    }

    // Remove um animal pelo nome
    public boolean removerAnimal(String nome) {
        return animais.removeIf(animal -> animal.getNome().equalsIgnoreCase(nome));
    }
}
