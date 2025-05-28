import javax.swing.*;
import java.awt.*;

public class TestaClasseTimeDeFutebol {
    private JFrame frame;
    private JTextField nomeField, cidadeField, titulosField;
    private JButton cadastrarButton, mostrarButton, verificarButton, torcidaButton;
    private TimeDeFutebol time;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TestaClasseTimeDeFutebol().initialize());
    }

    public void initialize() {
        frame = new JFrame("Cadastro de Time de Futebol");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2, 10, 10));

        // Campos
        frame.add(new JLabel("Nome do Time:"));
        nomeField = new JTextField();
        frame.add(nomeField);

        frame.add(new JLabel("Cidade:"));
        cidadeField = new JTextField();
        frame.add(cidadeField);

        frame.add(new JLabel("Número de Títulos:"));
        titulosField = new JTextField();
        frame.add(titulosField);

        // Botões
        cadastrarButton = new JButton("Cadastrar Time");
        cadastrarButton.addActionListener(e -> cadastrarTime());
        frame.add(cadastrarButton);

        mostrarButton = new JButton("Mostrar Dados");
        mostrarButton.addActionListener(e -> mostrarDados());
        frame.add(mostrarButton);

        verificarButton = new JButton("Verificar Time Vencedor");
        verificarButton.addActionListener(e -> verificarTimeVencedor());
        frame.add(verificarButton);

        torcidaButton = new JButton("Apresentar Torcida");
        torcidaButton.addActionListener(e -> apresentarTorcida());
        frame.add(torcidaButton);

        // Espaços extras para alinhar o grid
        for (int i = 0; i < 2; i++) {
            frame.add(new JLabel(""));
        }

        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void cadastrarTime() {
        try {
            String nome = nomeField.getText();
            String cidade = cidadeField.getText();
            int titulos = Integer.parseInt(titulosField.getText());

            time = new TimeDeFutebol(nome, cidade, titulos);
            JOptionPane.showMessageDialog(frame, "Time cadastrado com sucesso!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Número de títulos inválido.");
        }
    }

    private void mostrarDados() {
        if (time != null) {
            JOptionPane.showMessageDialog(frame, time.mostrarDados());
        } else {
            JOptionPane.showMessageDialog(frame, "Nenhum time cadastrado.");
        }
    }

    private void verificarTimeVencedor() {
        if (time != null) {
            JOptionPane.showMessageDialog(frame, time.verificarTimeVencedor());
        } else {
            JOptionPane.showMessageDialog(frame, "Nenhum time cadastrado.");
        }
    }

    private void apresentarTorcida() {
        if (time != null) {
            JOptionPane.showMessageDialog(frame, time.apresentarTorcida());
        } else {
            JOptionPane.showMessageDialog(frame, "Nenhum time cadastrado.");
        }
    }
}
    