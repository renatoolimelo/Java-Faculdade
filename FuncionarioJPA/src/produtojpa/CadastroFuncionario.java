
package produtojpa;
import modelo.*;

public class CadastroFuncionario {

    
    public static void main(String[] args) {
        FuncionarioDAO p = new FuncionarioDAO();
       
        //p.Inserir(new Funcionario("aaa", "bbb", 123.45f));
        //p.Inserir(new Funcionario("cccc", "ddd", 23.45f));
        //p.Inserir(new Funcionario("eee", "ffff", 3.45f));
        
        //p.PesquisarID(2);
        
        //p.RemoverID(2);
        
        p.AtualizarID(new Funcionario(1,"AAA","BBB",1000));
        
    }
    
}
