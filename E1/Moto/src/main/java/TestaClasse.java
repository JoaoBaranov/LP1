import javax.swing.JOptionPane;

public class TestaClasse {

    public static void main(String[] args) {
        Moto moto = null;
        int opcao = 0;

        do {
            String menu = "MENU - MOTO:\n"
                    + "1. Cadastrar Moto\n"
                    + "2. Exibir Informações da Moto\n"
                    + "3. Atualizar Cilindrada\n"
                    + "4. Atualizar Ano\n"
                    + "5. Sair\n";

            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

                switch (opcao) {
                    case 1:
                        String modelo = JOptionPane.showInputDialog("Digite o modelo da moto:");
                        String marca = JOptionPane.showInputDialog("Digite a marca da moto:");
                        int cilindrada = Integer.parseInt(JOptionPane.showInputDialog("Digite a cilindrada (ex: 150):"));
                        int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano da moto:"));
                        moto = new Moto(modelo, marca, cilindrada, ano);
                        JOptionPane.showMessageDialog(null, "Moto cadastrada com sucesso!");
                        break;
                    case 2:
                        if (moto != null) {
                            JOptionPane.showMessageDialog(null, moto.getDescricao());
                        } else {
                            JOptionPane.showMessageDialog(null, "Nenhuma moto cadastrada ainda.");
                        }
                        break;
                    case 3:
                        if (moto != null) {
                            int novaCilindrada = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova cilindrada:"));
                            moto.atualizarCilindrada(novaCilindrada);
                            JOptionPane.showMessageDialog(null, "Cilindrada atualizada com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Cadastre uma moto primeiro.");
                        }
                        break;
                    case 4:
                        if (moto != null) {
                            int novoAno = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo ano:"));
                            moto.atualizarAno(novoAno);
                            JOptionPane.showMessageDialog(null, "Ano atualizado com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Cadastre uma moto primeiro.");
                        }
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Saindo do programa. Até mais!");
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
