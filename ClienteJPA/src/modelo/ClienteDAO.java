package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClienteDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public void conectar() {
        try {
            emf = Persistence.createEntityManagerFactory("ClienteJPAPU");
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

    public void inserir(Cliente cli) {
        try {
            em.persist(cli);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao inserir!\n " + e);
            em.getTransaction().rollback();
        }
    }
}
