package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CarroDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public void Conectar() {

        try {
            emf = Persistence.createEntityManagerFactory("ProdutoJPAPU");
            em = emf.createEntityManager();
            em.getTransaction().begin();

        } catch (Exception e) {
            System.out.println("Erro ao conectar !\n" + e);
        }
    }

    public void Fechar() {
        try {
            em.close();

        } catch (Exception e) {
            System.out.println("Erro ao desconectar !\n" + e);
        }
    }

    public void Inserir(Carro func) {
        try {
            Conectar();
            em.persist(func);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao inserir !!" + e);
            em.getTransaction().rollback();
        } finally {
            Fechar();
        }
    }

    public Carro PesquisarID(int id) {
        Carro func = null;
        try {
            Conectar();
            func = em.find(Carro.class, id);
            System.out.println("ID "+func.getId());
            System.out.println("Nome "+func.getMarca());
            System.out.println("Categoria "+func.getModelo());
            System.out.println("Salario "+func.getPreco());
            System.out.println("Salario "+func.getAno());
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar!\n" + e);
        } finally {
            Fechar();
        }
        return func;
    }
    
    public Carro RemoverID(int id){
        Carro func = null;
        try {
            Conectar();
            func = em.find(Carro.class, id);
            em.remove(func);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao remover!\n" + e);
        } finally {
            Fechar();
        }
        return func;
    }
    
    public Carro AtualizarID(Carro novoFuncionario){
        Carro func = null;
        try {
            Conectar();
            func = em.find(Carro.class, novoFuncionario.getId());
            func.setModelo(novoFuncionario.getModelo());
            func.setMarca(novoFuncionario.getMarca());
            func.setPreco(novoFuncionario.getPreco());
            func.setAno(novoFuncionario.getAno());
            em.getTransaction().commit();
                  } catch (Exception e) {
            System.out.println("Erro ao atualizar!\n" + e);
        } finally {
            Fechar();
        }
        return func;
    }
}
