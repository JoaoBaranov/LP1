public class Calçados {
    private String tipo;
    private int tamanho;
    private String marca;

    public Calçados(String tipo, int tamanho, String marca) {
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.marca = marca;
    }

    public String mostrarDados() {
        return "Tipo: " + tipo + "\nTamanho: " + tamanho + "\nMarca: " + marca;
    }

    public String verificarDisponibilidade() {
        // Simulação: disponível se tamanho for entre 34 e 44
        if (tamanho >= 34 && tamanho <= 44) {
            return "Tamanho disponível em estoque.";
        } else {
            return "Tamanho indisponível no momento.";
        }
    }

    public String sugerirEstilo() {
        switch (tipo.toLowerCase()) {
            case "tênis":
                return "Estilo recomendado: Casual/Esportivo";
            case "sapato":
                return "Estilo recomendado: Social/Formal";
            case "sandália":
                return "Estilo recomendado: Verão/Despojado";
            default:
                return "Estilo não identificado. Use como preferir!";
        }
    }
}

