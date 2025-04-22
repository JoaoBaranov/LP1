import javax.swing.JOptionPane;

public class TestaClasse {

    public static void main(String[] args) {
        Filme filme = null;
        int opcao = 0;

        do {
            String menu = "MENU:\n"
                    + "1. Cadastrar Filme\n"
                    + "2. Exibir Informações do Filme\n"
                    + "3. Atualizar Ano de Lançamento\n"
                    + "4. Atualizar Gênero\n"
                    + "5. Sair\n";
            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

                switch (opcao) {
                    case 1:
                        String titulo = JOptionPane.showInputDialog("Digite o título do filme:");
                        String diretor = JOptionPane.showInputDialog("Digite o nome do diretor:");
                        int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de lançamento:"));
                        String genero = JOptionPane.showInputDialog("Digite o gênero do filme:");
                        filme = new Filme(titulo, diretor, ano, genero);
                        JOptionPane.showMessageDialog(null, "Filme cadastrado com sucesso!");
                        break;
                    case 2:
                        if (filme != null) {
                            JOptionPane.showMessageDialog(null, filme.getDescricao());
                        } else {
                            JOptionPane.showMessageDialog(null, "Nenhum filme cadastrado ainda.");
                        }
                        break;
                    case 3:
                        if (filme != null) {
                            int novoAno = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo ano de lançamento:"));
                            filme.atualizarAno(novoAno);
                            JOptionPane.showMessageDialog(null, "Ano atualizado com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Cadastre um filme primeiro.");
                        }
                        break;
                    case 4:
                        if (filme != null) {
                            String novoGenero = JOptionPane.showInputDialog("Digite o novo gênero:");
                            filme.atualizarGenero(novoGenero);
                            JOptionPane.showMessageDialog(null, "Gênero atualizado com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Cadastre um filme primeiro.");
                        }
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Encerrando o programa.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Digite um número.");
            }
        } while (opcao != 5);
    }
}

