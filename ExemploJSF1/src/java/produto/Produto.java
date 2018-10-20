package produto;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "produto")
@RequestScoped
public class Produto {
    
    private String Nomeproduto, categoria;
    private float preco;

    public Produto() {
    }

    public String getNomeproduto() {
        return Nomeproduto;
    }

    public void setNomeproduto(String Nomeproduto) {
        this.Nomeproduto = Nomeproduto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    
    
}
