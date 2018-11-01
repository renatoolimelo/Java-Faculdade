package clientejpa;
import modelo.*;

public class CadastroCliente {

    public static void main(String[] args) {
        
        ClienteDAO cliDAO = new ClienteDAO();
        
        Cliente cli = new Cliente();
        cli.setNome("Maria");
        
        System.out.println("Iniciando...");
        cliDAO.conectar();
        cliDAO.inserir(cli);
        cliDAO.fechar();
        System.out.println("Finalizando...");
        
    }
    
}
