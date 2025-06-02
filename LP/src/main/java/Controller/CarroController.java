package Controller;

import Models.Carro;
import java.util.ArrayList;
import java.util.List;

public class CarroController {

    private List<Carro> carros = new ArrayList<>();

    // Adiciona um novo carro
    public void adicionarCarro(Carro carro) {
        carros.add(carro);
    }

    // Lista todos os carros
    public List<Carro> listarCarros() {
        return carros;
    }

    // Busca um carro pelo nome
    public Carro buscarCarroPorNome(String nome) {
        for (Carro carro : carros) {
            if (carro.getNome().equalsIgnoreCase(nome)) {
                return carro;
            }
        }
        return null;
    }

    // Atualiza informações de um carro existente
    public boolean atualizarCarro(String nome, Carro novoCarro) {
        for (int i = 0; i < carros.size(); i++) {
            if (carros.get(i).getNome().equalsIgnoreCase(nome)) {
                carros.set(i, novoCarro);
                return true;
            }
        }
        return false;
    }

    // Remove um carro pelo nome
    public boolean removerCarro(String nome) {
        return carros.removeIf(carro -> carro.getNome().equalsIgnoreCase(nome));
    }
}
