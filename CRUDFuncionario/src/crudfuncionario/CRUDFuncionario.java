package crudfuncionario;

import funcionario.Funcionario;
import funcionario.FuncionarioDAO;
import java.util.List;
import java.util.Scanner;

public class CRUDFuncionario {

    public static void main(String[] args) {

        int opcao;
        char escolha = 'S';

        FuncionarioDAO funcDAO = new FuncionarioDAO();
        Funcionario func = new Funcionario();
        Scanner entrada = new Scanner(System.in);

        funcDAO.conectar();

        while (escolha == 's' || escolha == 'S') {

            System.out.println("Escolha uma opção: \n");
            System.out.println("1 - Inserir funcionário\n");
            System.out.println("2 - Consultar funcionáro pelo ID\n");
            System.out.println("3 - Listar todos os funcionários\n");
            System.out.println("4 - Deletar um funcionário\n");
            System.out.println("5 - Atualizar salário de um funcionário cadastrado\n");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    entrada.nextLine();
                    func.setNome(entrada.nextLine());
                    System.out.print("Cargo: ");
                    func.setCargo(entrada.nextLine());
                    System.out.print("Salário: ");
                    func.setSalario(entrada.nextFloat());
                    funcDAO.inserir(func);
                    break;

                case 2:
                    System.out.print("Digite o ID do funcionário: ");
                    func.setID(entrada.nextInt());
                    funcDAO.consultar(func.getID());
                    break;

                case 3:
                    try {
                        List<Funcionario> lista = funcDAO.listar();
                        for (int i = 0; i < lista.size(); i++) {
                            System.out.println("ID: " + lista.get(i).getID());
                            System.out.println("Nome: " + lista.get(i).getNome());
                            System.out.println("Cargo: " + lista.get(i).getCargo());
                            System.out.println("Salario: " + lista.get(i).getSalario() + "\n\n");
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Tabela vazia: " + e);
                    }
                    break;

                case 4:
                    System.out.print("Informe o ID do funcionário:");
                    func.setID(entrada.nextInt());
                    funcDAO.deletar(func.getID());
                    break;

                case 5:
                    System.out.print("Informe o ID do funcionário: ");
                    func.setID(entrada.nextInt());
                    System.out.print("Informe o valor do salário atualizado: ");
                    func.setSalario(entrada.nextFloat());
                    funcDAO.atualizar(func.getID(), func.getSalario());
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println("\n\nDeseja realizar outra função: \n");
            System.out.println("S - Sim ou N - Não\n\n");
            entrada.nextLine();
            escolha = entrada.nextLine().charAt(0);
        }
        funcDAO.desconectar();
    }

}
