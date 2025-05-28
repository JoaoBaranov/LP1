import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::criarInterface);
    }

    private static void criarInterface() {
        JFrame frame = new JFrame("Interface Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new GridLayout(0, 1));

        // Botões que chamam as janelas de teste de cada categoria
        frame.add(criarBotao("Animais", () -> animais.TestaClasseAnimal.main(null)));
        frame.add(criarBotao("Calçados", () -> calcados.TestaClasseCalçados.main(null)));
        frame.add(criarBotao("Carros", () -> carros.TestaClasseCarros.main(null)));
        frame.add(criarBotao("Filmes", () -> filmes.TestaClasseFilmes.main(null)));
        // Adicione mais aqui...

        frame.setVisible(true);
    }

    private static JButton criarBotao(String nome, Runnable acao) {
        JButton botao = new JButton(nome);
        botao.addActionListener((ActionEvent e) -> acao.run());
        return botao;
    }
}
