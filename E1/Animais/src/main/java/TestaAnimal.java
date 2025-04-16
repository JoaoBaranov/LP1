import javax.swing.*;
import java.awt.*;

public class TestaAnimal {
    private JFrame frame;
    private JTextField nomeField, especieField, idadeField, porteField;
    private JButton cadastrarButton, mostrarButton, classificarButton, somButton;
    private Animal animal;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TestaAnimal().initialize());
    }

    public void initialize() {
        // Janela principal
        frame = new JFrame("Cadastro de Animal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 10));

        // Título no topo
        JLabel titulo = new JLabel("🐾 Cadastro de Animais", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(titulo, BorderLayout.NORTH);

        // Painel de campos
        JPanel camposPanel = new JPanel();
        camposPanel.setLayout(new GridLayout(4, 2, 10, 10));
        camposPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        nomeField = new JTextField();
        especieField = new JTextField();
        idadeField = new JTextField();
        porteField = new JTextField();

        camposPanel.add(new JLabel("Nome do Animal:"));
        camposPanel.add(nomeField);
        camposPanel.add(new JLabel("Espécie (ex: cachorro, gato):"));
        camposPanel.add(especieField);
        camposPanel.add(new JLabel("Idade (em anos):"));
        camposPanel.add(idadeField);
        camposPanel.add(new JLabel("Porte (pequeno, médio, grande):"));
        camposPanel.add(porteField);

        frame.add(camposPanel, BorderLayout.CENTER);

        // Painel de botões
        JPanel botoesPanel = new JPanel();
        botoesPanel.setLayout(new FlowLayout());

        cadastrarButton = new JButton("Cadastrar");
        mostrarButton = new JButton("Mostrar Dados");
        classificarButton = new JButton("Classificar Idade");
        somButton = new JButton("Emitir Som");

        cadastrarButton.addActionListener(e -> cadastrarAnimal());
        mostrarButton.addActionListener(e -> mostrarDados());
        classificarButton.addActionListener(e -> classificarIdade());
        somButton.addActionListener(e -> emitirSom());

        botoesPanel.add(cadastrarButton);
        botoesPanel.add(mostrarButton);
        botoesPanel.add(classificarButton);
        botoesPanel.add(somButton);

        frame.add(botoesPanel, BorderLayout.SOUTH);

        // Exibir a interface
        frame.setVisible(true);
    }

    private void cadastrarAnimal() {
        try {
            String nome = nomeField.getText();
            String especie = especieField.getText();
            int idade = Integer.parseInt(idadeField.getText());
            String porte = porteField.getText();

            animal = new Animal(nome, especie, idade, porte);
            JOptionPane.showMessageDialog(frame, "Animal cadastrado com sucesso!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Idade inválida. Insira um número inteiro.");
        }
    }

    private void mostrarDados() {
        if (animal != null) {
            JOptionPane.showMessageDialog(frame, animal.mostrarDados());
        } else {
            JOptionPane.showMessageDialog(frame, "Nenhum animal cadastrado.");
        }
    }

    private void classificarIdade() {
        if (animal != null) {
            JOptionPane.showMessageDialog(frame, animal.classificarIdade());
        } else {
            JOptionPane.showMessageDialog(frame, "Nenhum animal cadastrado.");
        }
    }

    private void emitirSom() {
        if (animal != null) {
            JOptionPane.showMessageDialog(frame, animal.emitirSom());
        } else {
            JOptionPane.showMessageDialog(frame, "Nenhum animal cadastrado.");
        }
    }
}
