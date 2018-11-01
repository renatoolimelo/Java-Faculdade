package produtosjpa;

import java.util.Scanner;
import modelo.*;

public class CadastroProduto {

    public static void main(String[] args) {

        ProdutoDAO proDAO = new ProdutoDAO();

        Produto pro = new Produto();

        Scanner entrada = new Scanner(System.in);

        System.out.print("Informe o nome do produto: ");
        pro.setNomeProduto(entrada.nextLine());
        
        System.out.print("Informe a Categoria do produto: ");
        pro.setCategoria(entrada.nextLine());
        
        System.out.print("ID a consultar na tabela: ");
        int id = entrada.nextInt();

        System.out.println("Iniciando...");
        proDAO.conectar();
        proDAO.inserir(pro);
        proDAO.pesquisarID(id);
        proDAO.fechar();
        System.out.println("Finalizando...");

    }

}
