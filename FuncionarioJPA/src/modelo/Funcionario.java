
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomeFuncionario;
    private String Cargo;
    private float salario;

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public Funcionario(int id, String nomeFuncionario, String Cargo, float salario) {
        this.id = id;
        this.nomeFuncionario = nomeFuncionario;
        this.Cargo = Cargo;
        this.salario = salario;
    }
    
    

    public Funcionario(String nomeProduto, String categoria, float salario) {
        this.nomeFuncionario = nomeProduto;
        this.Cargo = categoria;
        this.salario = salario;
    }

    public Funcionario() {
        
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "modelo.Produto[ id=" + id + " ]";
    }

}
