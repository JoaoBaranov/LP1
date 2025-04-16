import javax.swing.*;
import java.awt.*;

public class TestaClasse {
    private JFrame frame;
    private JTextField modeloField, corField, anoField;
    private JButton cadastrarButton, mostrarButton, calcularButton;
    private Carros carro;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TestaClasse().initialize());
    }

    public void initialize() {
        // Criando a janela principal
        frame = new JFrame("Cadastro de Carros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2, 10, 10));

        // Campos de entrada
        frame.add(new JLabel("Modelo do Carro:"));
        modeloField = new JTextField();
        frame.add(modeloField);

        frame.add(new JLabel("Cor do Carro:"));
        corField = new JTextField();
        frame.add(corField);

        frame.add(new JLabel("Ano de Fabricação:"));
        anoField = new JTextField();
        frame.add(anoField);

        // Botão: Cadastrar Carro
        cadastrarButton = new JButton("Cadastrar Carro");
        cadastrarButton.addActionListener(e -> cadastrarCarro());
        frame.add(cadastrarButton);

        // Botão: Mostrar Dados
        mostrarButton = new JButton("Mostrar Dados");
        mostrarButton.addActionListener(e -> mostrarDados());
        frame.add(mostrarButton);

        // Botão: Calcular Idade
        calcularButton = new JButton("Calcular Idade");
        calcularButton.addActionListener(e -> calcularIdade());
        frame.add(calcularButton);

        // Preenchendo o restante do grid
        for (int i = 0; i < 3; i++) {
            frame.add(new JLabel(""));
        }

        // Configurações finais da janela
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null); // Centraliza a janela
        frame.setVisible(true);
    }

    private void cadastrarCarro() {
        try {
            String modelo = modeloField.getText();
            String cor = corField.getText();
            int ano = Integer.parseInt(anoField.getText());

            carro = new Carros(modelo, cor, ano);
            JOptionPane.showMessageDialog(frame, "Carro cadastrado com sucesso!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Ano inválido. Digite um número inteiro.");
        }
    }

    private void mostrarDados() {
        if (carro != null) {
            JOptionPane.showMessageDialog(frame, carro.mostrarDados());
        } else {
            JOptionPane.showMessageDialog(frame, "Nenhum carro cadastrado.");
        }
    }

    private void calcularIdade() {
        if (carro != null) {
            int anoAtual = 2025;
            int idade = carro.calcularIdade(anoAtual);
            JOptionPane.showMessageDialog(frame, "A idade do carro é: " + idade + " anos.");
        } else {
            JOptionPane.showMessageDialog(frame, "Nenhum carro cadastrado.");
        }
    }
}
