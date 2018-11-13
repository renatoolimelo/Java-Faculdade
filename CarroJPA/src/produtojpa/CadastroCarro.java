package produtojpa;

import java.util.Scanner;
import modelo.*;

public class CadastroCarro {

    public static void main(String[] args) {
        CarroDAO carroDAO = new CarroDAO();

        Scanner entrada = new Scanner(System.in);
        int opcao;
        do {

            String marca;
            String modelo;
            float preco;
            int ano;
            int id;
            System.out.println("Selecione uma das oplçoes abaixo");
            System.out.println("1 - Novo carro");
            System.out.println("2 - Lista de carros");
            System.out.println("3 - Atualizar carro");
            System.out.println("4 - Deletar Carro");
            System.out.println("0 - Sair");
            opcao = entrada.nextInt();
            switch (opcao) {
                case 0:

                    return;
                case 1:

                    System.out.println("Informe a Marca: ");
                    marca = entrada.next();
                    System.out.println("Informe a Modelo: ");
                    modelo = entrada.next();
                    System.out.println("Informe a Preco: ");
                    preco = entrada.nextFloat();
                    System.out.println("Informe a Ano: ");
                    ano = entrada.nextInt();
                    carroDAO.Inserir(new Carro(marca, modelo, preco, ano));
                    break;

                case 2:

                    System.out.println("Informe o ID : ");
                    id = entrada.nextInt();
                    carroDAO.PesquisarID(id);
                    break;

                case 3:
                    System.out.println("Informe o id: ");
                    id = entrada.nextInt();
                    System.out.println("Informe a Marca: ");
                    marca = entrada.next();
                    System.out.println("Informe a Modelo: ");
                    modelo = entrada.next();
                    System.out.println("Informe a Preco: ");
                    preco = entrada.nextFloat();
                    System.out.println("Informe a Ano: ");
                    ano = entrada.nextInt();
                    carroDAO.AtualizarID(new Carro(id, marca, modelo, preco, ano));
                    break;

                case 4:
                    System.out.println("Informe o ID : ");
                    id = entrada.nextInt();
                    carroDAO.RemoverID(id);
                    break;

            }
        } while (opcao != 0);

    }

}
