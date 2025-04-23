import javax.swing.*;
import java.awt.*;

public class CervejaDashboard extends JFrame {
    private Cerveja cerveja;

    private JTextField txtNome, txtTipo, txtTeor, txtPais;
    private JTextArea areaResultado;
    private JButton btnCadastrar, btnMostrar, btnAtualizar, btnBeber;

    public CervejaDashboard() {
        setTitle("Painel de Cerveja 🍺");
        setSize(550, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Painel de entrada
        JPanel painelEntrada = new JPanel(new GridLayout(4, 2, 5, 5));
        txtNome = new JTextField();
        txtTipo = new JTextField();
        txtTeor = new JTextField();
        txtPais = new JTextField();

        painelEntrada.add(new JLabel("Nome:"));
        painelEntrada.add(txtNome);

        painelEntrada.add(new JLabel("Tipo:"));
        painelEntrada.add(txtTipo);

        painelEntrada.add(new JLabel("Teor Alcoólico (%):"));
        painelEntrada.add(txtTeor);

        painelEntrada.add(new JLabel("País de Origem:"));
        painelEntrada.add(txtPais);

        add(painelEntrada, BorderLayout.NORTH);

        // Painel de botões
        JPanel painelBotoes = new JPanel(new GridLayout(1, 4, 10, 10));
        btnCadastrar = new JButton("Cadastrar");
        btnMostrar = new JButton("Mostrar");
        btnAtualizar = new JButton("Atualizar");
        btnBeber = new JButton("Beber 🍻");

        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnMostrar);
        painelBotoes.add(btnAtualizar);
        painelBotoes.add(btnBeber);

        add(painelBotoes, BorderLayout.CENTER);

        // Área de saída
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(areaResultado), BorderLayout.SOUTH);

        // Ações dos botões
        btnCadastrar.addActionListener(e -> {
            try {
                String nome = txtNome.getText();
                String tipo = txtTipo.getText();
                double teor = Double.parseDouble(txtTeor.getText());
                String pais = txtPais.getText();

                cerveja = new Cerveja(nome, tipo, teor, pais);
                areaResultado.setText("🍺 Cerveja cadastrada com sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Teor alcoólico inválido. Use ponto como separador.");
            }
        });

        btnMostrar.addActionListener(e -> {
            if (cerveja != null) {
                areaResultado.setText(cerveja.getDescricao());
            } else {
                areaResultado.setText("Nenhuma cerveja cadastrada ainda.");
            }
        });

        btnAtualizar.addActionListener(e -> {
            if (cerveja != null) {
                try {
                    double novoTeor = Double.parseDouble(JOptionPane.showInputDialog(this, "Novo teor alcoólico (%):"));
                    String novoPais = JOptionPane.showInputDialog(this, "Novo país de origem:");
                    cerveja.atualizarTeorAlcoolico(novoTeor);
                    cerveja.atualizarPais(novoPais);
                    areaResultado.setText("✅ Cerveja atualizada com sucesso!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Teor inválido.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nenhuma cerveja cadastrada.");
            }
        });

        btnBeber.addActionListener(e -> {
            if (cerveja != null) {
                areaResultado.setText(cerveja.beber());
            } else {
                JOptionPane.showMessageDialog(this, "Cadastre uma cerveja antes de beber!");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new CervejaDashboard();
    }
}
