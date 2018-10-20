package crudaluno;

import aluno.Aluno;
import aluno.AlunoDAO;
import java.util.List;
import java.util.Scanner;

public class CRUDAluno {

    public static void main(String[] args) {

        int opcao;
        char escolha = 'S';

        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno aluno = new Aluno();
        Scanner entrada = new Scanner(System.in);

        alunoDAO.conectar();

        while (escolha == 's' || escolha == 'S') {

            System.out.println("Escolha uma opção: \n");
            System.out.println("1 - Inserir aluno\n");
            System.out.println("2 - Consultar aluno pelo RA\n");
            System.out.println("3 - Listar todos os alunos\n");
            System.out.println("4 - Deletar um aluno\n");
            System.out.println("5 - Atualizar curso de um aluno cadastrado\n");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    entrada.nextLine();
                    aluno.setNome(entrada.nextLine());
                    System.out.print("Curso: ");
                    aluno.setCurso(entrada.nextLine());
                    alunoDAO.inserir(aluno);
                    break;

                case 2:
                    System.out.print("Digite o RA do aluno: ");
                    aluno.setRa(entrada.nextLong());
                    entrada.nextLine();
                    alunoDAO.consultar(aluno.getRa());
                    break;

                case 3:
                    try {
                        List<Aluno> lista = alunoDAO.listar();
                        for (int i = 0; i < lista.size(); i++) {
                            System.out.println("RA: " + lista.get(i).getRa());
                            System.out.println("Nome: " + lista.get(i).getNome());
                            System.out.println("Curso: " + lista.get(i).getCurso());
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Tabela vazia: " + e);
                    }
                    entrada.nextLine();
                    break;

                case 4:
                    System.out.print("Informe o RA do aluno:");
                    aluno.setRa(entrada.nextLong());
                    alunoDAO.deletar(aluno.getRa());
                    entrada.nextLine();
                    break;

                case 5:
                    System.out.print("Informe o RA do aluno: ");
                    aluno.setRa(entrada.nextLong());
                    System.out.print("Informe o curso atualizado: ");
                    entrada.nextLine();
                    aluno.setCurso(entrada.nextLine());
                    alunoDAO.atualizar(aluno.getRa(), aluno.getCurso());
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println("\n\nDeseja realizar outra função: \n");
            System.out.println("S - Sim ou N - Não\n\n");
            escolha = entrada.nextLine().charAt(0);
        }
        alunoDAO.desconectar();
    }

}
