public class TimeDeFutebol {
    private String nome;
    private String cidade;
    private int titulos;

    public TimeDeFutebol(String nome, String cidade, int titulos) {
        this.nome = nome;
        this.cidade = cidade;
        this.titulos = titulos;
    }

    public String mostrarDados() {
        return "Nome: " + nome + "\nCidade: " + cidade + "\nTítulos: " + titulos;
    }

    public String verificarTimeVencedor() {
        if (titulos >= 10) {
            return nome + " é um time vencedor!";
        } else {
            return nome + " ainda está construindo sua história!";
        }
    }

    public String apresentarTorcida() {
        return "A torcida do " + nome + " é apaixonada e vibrante!";
    }
}
