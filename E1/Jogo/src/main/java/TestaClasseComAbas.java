import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestaClasseComAbas extends JFrame {
    private Jogo jogo;

    private JTextField txtNome, txtGenero, txtPlataforma, txtAno;
    private JTextArea areaDescricao;
    private JTextField txtNovaPlataforma, txtNovoAno;

    public TestaClasseComAbas() {
        setTitle("Sistema de Jogos");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane abas = new JTabbedPane();

        // Aba 1: Cadastro
        JPanel abaCadastro = new JPanel(new GridLayout(5, 2, 5, 5));
        txtNome = new JTextField();
        txtGenero = new JTextField();
        txtPlataforma = new JTextField();
        txtAno = new JTextField();

        abaCadastro.add(new JLabel("Nome do jogo:"));
        abaCadastro.add(txtNome);

        abaCadastro.add(new JLabel("Gênero:"));
        abaCadastro.add(txtGenero);

        abaCadastro.add(new JLabel("Plataforma:"));
        abaCadastro.add(txtPlataforma);

        abaCadastro.add(new JLabel("Ano de lançamento:"));
        abaCadastro.add(txtAno);

        JButton btnCadastrar = new JButton("Cadastrar");
        abaCadastro.add(btnCadastrar);

        // Aba 2: Visualizar
        JPanel abaVisualizar = new JPanel(new BorderLayout());
        areaDescricao = new JTextArea();
        areaDescricao.setEditable(false);
        abaVisualizar.add(new JScrollPane(areaDescricao), BorderLayout.CENTER);

        JButton btnMostrar = new JButton("Mostrar Jogo");
        abaVisualizar.add(btnMostrar, BorderLayout.SOUTH);

        // Aba 3: Atualizar
        JPanel abaAtualizar = new JPanel(new GridLayout(3, 2, 5, 5));
        txtNovaPlataforma = new JTextField();
        txtNovoAno = new JTextField();
        JButton btnAtualizar = new JButton("Atualizar");

        abaAtualizar.add(new JLabel("Nova Plataforma:"));
        abaAtualizar.add(txtNovaPlataforma);

        abaAtualizar.add(new JLabel("Novo Ano:"));
        abaAtualizar.add(txtNovoAno);

        abaAtualizar.add(new JLabel(""));
        abaAtualizar.add(btnAtualizar);

        // Adiciona abas ao painel de abas
        abas.addTab("Cadastro", abaCadastro);
        abas.addTab("Visualizar", abaVisualizar);
        abas.addTab("Atualizar", abaAtualizar);

        add(abas);

        // Eventos
        btnCadastrar.addActionListener(e -> {
            String nome = txtNome.getText();
            String genero = txtGenero.getText();
            String plataforma = txtPlataforma.getText();
            int ano = Integer.parseInt(txtAno.getText());

            jogo = new Jogo(nome, genero, plataforma, ano);
            JOptionPane.showMessageDialog(this, "Jogo cadastrado com sucesso!");
        });

        btnMostrar.addActionListener(e -> {
            if (jogo != null) {
                areaDescricao.setText(jogo.getDescricao());
            } else {
                areaDescricao.setText("Nenhum jogo cadastrado.");
            }
        });

        btnAtualizar.addActionListener(e -> {
            if (jogo != null) {
                String novaPlataforma = txtNovaPlataforma.getText();
                int novoAno = Integer.parseInt(txtNovoAno.getText());
                jogo.atualizarPlataforma(novaPlataforma);
                jogo.atualizarAno(novoAno);
                JOptionPane.showMessageDialog(this, "Jogo atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum jogo cadastrado.");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new TestaClasseComAbas();
    }
}
