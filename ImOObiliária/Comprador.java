import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Set;

@SuppressWarnings("unchecked")
public class Comprador extends Atores { 
    
    // variáveis de instância
    private TreeSet<Imoveis> favoritos;
    
    /**
     * Construtores para objetos da classe Comprador
     */
    public Comprador() {
        super();
        this.favoritos = new TreeSet<>();
    }
    public Comprador(String nome, String email, String password, String morada, String dataN) {
        super(nome, email, password, morada, dataN, "Comprador");
        this.favoritos = new TreeSet<>();
    }
    public Comprador(Comprador c) {
        super(c);
        this.favoritos = (TreeSet<Imoveis>)c.favoritos.clone();
    }
    
    /**
     * Métodos de instância da classe Comprador
     */
    public TreeSet<Imoveis> getFav() {
        return this.favoritos;
    }
    public String getTipo() {
        return "Comprador";
    }
    
    public Comprador clone() {
        return new Comprador(this);
    }
    
    public boolean equals (Object obj) {
        boolean result = super.equals(obj);
        if (result == false) return false;
        Comprador c = (Comprador)obj;
        return (this.favoritos.equals(c.favoritos));
    }
}
