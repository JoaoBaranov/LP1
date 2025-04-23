import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestaClasseGUI extends JFrame {

    private JTextField txtTipo, txtTamanho, txtCor, txtMarca;
    private JTextArea areaResultado;
    private Roupa roupa;

    public TestaClasseGUI() {
        setTitle("Cadastro de Roupa");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela
        setLayout(new BorderLayout());

        // Painel de entrada de dados
        JPanel painelForm = new JPanel(new GridLayout(5, 2, 5, 5));

        painelForm.add(new JLabel("Tipo:"));
        txtTipo = new JTextField();
        painelForm.add(txtTipo);

        painelForm.add(new JLabel("Tamanho:"));
        txtTamanho = new JTextField();
        painelForm.add(txtTamanho);

        painelForm.add(new JLabel("Cor:"));
        txtCor = new JTextField();
        painelForm.add(txtCor);

        painelForm.add(new JLabel("Marca:"));
        txtMarca = new JTextField();
        painelForm.add(txtMarca);

        JButton btnCadastrar = new JButton("Cadastrar");
        painelForm.add(btnCadastrar);

        JButton btnMostrar = new JButton("Mostrar Dados");
        painelForm.add(btnMostrar);

        add(painelForm, BorderLayout.NORTH);

        // Área de resultado
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        // Ações dos botões
        btnCadastrar.addActionListener(e -> {
            String tipo = txtTipo.getText();
            String tamanho = txtTamanho.getText();
            String cor = txtCor.getText();
            String marca = txtMarca.getText();

            roupa = new Roupa(tipo, tamanho, cor, marca);
            areaResultado.setText("Roupa cadastrada com sucesso!");
        });

        btnMostrar.addActionListener(e -> {
            if (roupa != null) {
                areaResultado.setText(roupa.getDescricao());
            } else {
                areaResultado.setText("Nenhuma roupa cadastrada ainda.");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new TestaClasseGUI();
    }
}
