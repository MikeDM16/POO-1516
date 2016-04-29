import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class Comprador extends Atores { 
    
    // variáveis de instância
    private Set<Integer> favoritos;
    
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
        this.favoritos = c.getFavoritos();
    }
    
    /**
     * Métodos de instância da classe Comprador
     */
    public Set<Integer> getFavoritos() {
        Set<Integer> copia = new TreeSet<>();
        for (int i: this.favoritos) copia.add(i);
        return copia;
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
