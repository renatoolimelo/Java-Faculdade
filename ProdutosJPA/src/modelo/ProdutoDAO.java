package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdutoDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public void conectar() {
        try {
            emf = Persistence.createEntityManagerFactory("ProdutosJPAPU");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            System.out.println("Conectado!");
        } catch (Exception e) {
            System.out.println("Erro ao conectar\n " + e);
        }
    }

    public void fechar() {
        try {
            em.close();
            System.out.println("Encerrado!");
        } catch (Exception e) {
            System.out.println("Erro ao encerrar!\n " + e);
        }
    }

    public void inserir(Produto pro) {
        try {
            em.persist(pro);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao inserir!\n " + e);
            em.getTransaction().rollback();
        }
    }  
    
    public Produto pesquisarID(int id){
        Produto prod=null;
        try {
            prod=em.find(Produto.class,id);
            System.out.println("ID: " + prod.getId());
            System.out.println("Nome: " + prod.getNomeProduto());
            System.out.println("Categoria: "+ prod.getCategoria());
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar!\n"+e);
        }
        return prod;
    }

  
}
