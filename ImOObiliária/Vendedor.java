import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Vendedor extends Utilizador {
    // variáveis de instância
    private Set<Integer> portfolio, historico;
    
    /**
     * Construtores para objetos da classe Vendedor
     */
    public Vendedor() {
        super();
        this.portfolio = new TreeSet<>();
        this.historico = new TreeSet<>();
    }
    public Vendedor(String nome, String email, String password, String morada, String dataN) {
        super(nome, email, password, morada, dataN, "Vendedor");
        this.portfolio = new TreeSet<>();
        this.historico = new TreeSet<>();
    }
    public Vendedor(Vendedor v){
        super(v);
        this.portfolio = v.getPortf();
        this.historico = v.getHist();
    }
    
    /**
     * Métodos de instância da classe Vendedor
     */
    public Set<Integer> getPortf() {
        Set<Integer> copia = new TreeSet<>();
        for (int i: this.portfolio) copia.add(i);
        return copia;
    }
    public Set<Integer> getHist() {
        Set<Integer> copia = new TreeSet<>();
        for (int i: this.historico) copia.add(i);
        return copia;
    }
    public String getTipo() {
        return "Vendedor";
    }
    
    public Vendedor clone() {
        return new Vendedor(this);
    }
    
    public boolean equals (Object obj) {
        boolean result = super.equals(obj);
        if (result == false) return false;
        Vendedor v = (Vendedor)obj;
        return (this.portfolio.equals(v.portfolio) && this.historico.equals(v.historico));
    }
}
