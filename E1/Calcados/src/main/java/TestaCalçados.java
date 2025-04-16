import javax.swing.*;
import java.awt.*;

public class TestaCalçados {
    private JFrame frame;
    private JTextField tipoField, tamanhoField, marcaField;
    private JButton cadastrarButton, mostrarButton, verificarButton, estiloButton;
    private Calçados calcado;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TestaCalçados().initialize());
    }

    public void initialize() {
        frame = new JFrame("Cadastro de Calçados");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2, 10, 10));

        // Campos de entrada
        frame.add(new JLabel("Tipo do Calçado:"));
        tipoField = new JTextField();
        frame.add(tipoField);

        frame.add(new JLabel("Tamanho:"));
        tamanhoField = new JTextField();
        frame.add(tamanhoField);

        frame.add(new JLabel("Marca:"));
        marcaField = new JTextField();
        frame.add(marcaField);

        // Botão: Cadastrar Calçado
        cadastrarButton = new JButton("Cadastrar Calçado");
        cadastrarButton.addActionListener(e -> cadastrarCalcado());
        frame.add(cadastrarButton);

        // Botão: Mostrar Dados
        mostrarButton = new JButton("Mostrar Dados");
        mostrarButton.addActionListener(e -> mostrarDados());
        frame.add(mostrarButton);

        // Botão: Verificar Disponibilidade
        verificarButton = new JButton("Verificar Disponibilidade");
        verificarButton.addActionListener(e -> verificarDisponibilidade());
        frame.add(verificarButton);

        // Botão: Sugerir Estilo
        estiloButton = new JButton("Sugerir Estilo");
        estiloButton.addActionListener(e -> sugerirEstilo());
        frame.add(estiloButton);

        // Preencher espaço
        for (int i = 0; i < 2; i++) {
            frame.add(new JLabel(""));
        }

        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void cadastrarCalcado() {
        try {
            String tipo = tipoField.getText();
            int tamanho = Integer.parseInt(tamanhoField.getText());
            String marca = marcaField.getText();

            calcado = new Calçados(tipo, tamanho, marca);
            JOptionPane.showMessageDialog(frame, "Calçado cadastrado com sucesso!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Tamanho inválido. Digite um número inteiro.");
        }
    }

    private void mostrarDados() {
        if (calcado != null) {
            JOptionPane.showMessageDialog(frame, calcado.mostrarDados());
        } else {
            JOptionPane.showMessageDialog(frame, "Nenhum calçado cadastrado.");
        }
    }

    private void verificarDisponibilidade() {
        if (calcado != null) {
            String resultado = calcado.verificarDisponibilidade();
            JOptionPane.showMessageDialog(frame, resultado);
        } else {
            JOptionPane.showMessageDialog(frame, "Nenhum calçado cadastrado.");
        }
    }

    private void sugerirEstilo() {
        if (calcado != null) {
            String estilo = calcado.sugerirEstilo();
            JOptionPane.showMessageDialog(frame, estilo);
        } else {
            JOptionPane.showMessageDialog(frame, "Nenhum calçado cadastrado.");
        }
    }
}
