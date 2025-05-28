public class Animal {
    private String nome;
    private String especie;
    private int idade;
    private String porte;

    public Animal(String nome, String especie, int idade, String porte) {
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.porte = porte;
    }

    public String mostrarDados() {
        return "Nome: " + nome +
                "\nEspécie: " + especie +
                "\nIdade: " + idade + " anos" +
                "\nPorte: " + porte;
    }

    public String classificarIdade() {
        if (idade <= 1) {
            return nome + " é um filhote.";
        } else if (idade <= 7) {
            return nome + " é um animal adulto.";
        } else {
            return nome + " é um animal idoso.";
        }
    }

    public String emitirSom() {
        switch (especie.toLowerCase()) {
            case "cachorro":
                return nome + " diz: Au Au!";
            case "gato":
                return nome + " diz: Miau!";
            case "pássaro":
                return nome + " diz: Piu piu!";
            case "vaca":
                return nome + " diz: Muuuu!";
            default:
                return nome + " emite um som desconhecido.";
        }
    }
}
