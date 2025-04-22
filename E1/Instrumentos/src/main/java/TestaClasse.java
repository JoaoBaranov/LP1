import javax.swing.JOptionPane;

public class TestaClasse {

    public static void main(String[] args) {
        InstrumentoMusical instrumento = null;
        int opcao = 0;

        do {
            String menu = "MENU - INSTRUMENTO MUSICAL:\n"
                    + "1. Cadastrar Instrumento\n"
                    + "2. Exibir Informações do Instrumento\n"
                    + "3. Atualizar Tipo do Instrumento\n"
                    + "4. Atualizar Ano de Fabricação\n"
                    + "5. Sair\n";
            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

                switch (opcao) {
                    case 1:
                        String nome = JOptionPane.showInputDialog("Digite o nome do instrumento:");
                        String tipo = JOptionPane.showInputDialog("Digite o tipo (cordas, sopro, percussão etc.):");
                        String marca = JOptionPane.showInputDialog("Digite a marca do instrumento:");
                        int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de fabricação:"));
                        instrumento = new InstrumentoMusical(nome, tipo, marca, ano);
                        JOptionPane.showMessageDialog(null, "Instrumento cadastrado com sucesso!");
                        break;
                    case 2:
                        if (instrumento != null) {
                            JOptionPane.showMessageDialog(null, instrumento.getDescricao());
                        } else {
                            JOptionPane.showMessageDialog(null, "Nenhum instrumento cadastrado ainda.");
                        }
                        break;
                    case 3:
                        if (instrumento != null) {
                            String novoTipo = JOptionPane.showInputDialog("Digite o novo tipo do instrumento:");
                            instrumento.atualizarTipo(novoTipo);
                            JOptionPane.showMessageDialog(null, "Tipo atualizado com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Cadastre um instrumento primeiro.");
                        }
                        break;
                    case 4:
                        if (instrumento != null) {
                            int novoAno = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo ano de fabricação:"));
                            instrumento.atualizarAno(novoAno);
                            JOptionPane.showMessageDialog(null, "Ano atualizado com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Cadastre um instrumento primeiro.");
                        }
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Encerrando o programa.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Digite um número válido.");
            }
        } while (opcao != 5);
    }
}
