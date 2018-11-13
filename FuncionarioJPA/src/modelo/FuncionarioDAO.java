package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FuncionarioDAO {

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

    public void Inserir(Funcionario func) {
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

    public Funcionario PesquisarID(int id) {
        Funcionario func = null;
        try {
            Conectar();
            func = em.find(Funcionario.class, id);
            System.out.println("ID "+func.getId());
            System.out.println("Nome "+func.getNomeFuncionario());
            System.out.println("Categoria "+func.getCargo());
            System.out.println("Salario "+func.getSalario());
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar!\n" + e);
        } finally {
            Fechar();
        }
        return func;
    }
    
    public Funcionario RemoverID(int id){
        Funcionario func = null;
        try {
            Conectar();
            func = em.find(Funcionario.class, id);
            em.remove(func);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao remover!\n" + e);
        } finally {
            Fechar();
        }
        return func;
    }
    
    public Funcionario AtualizarID(Funcionario novoFuncionario){
        Funcionario func = null;
        try {
            Conectar();
            func = em.find(Funcionario.class, novoFuncionario.getId());
            func.setCargo(novoFuncionario.getCargo());
            func.setNomeFuncionario(novoFuncionario.getNomeFuncionario());
            func.setSalario(novoFuncionario.getSalario());
            em.getTransaction().commit();
                  } catch (Exception e) {
            System.out.println("Erro ao atualizar!\n" + e);
        } finally {
            Fechar();
        }
        return func;
    }
}
