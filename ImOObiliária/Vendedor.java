import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Vendedor extends Utilizador {
    // variáveis de instância
    private Set<String> portfolio, historico;
    private static List<Consulta> consultas;
    
    /**
     * Construtores para objetos da classe Vendedor
     */
    public Vendedor() {
        super();
        this.portfolio = new TreeSet<>();
        this.historico = new TreeSet<>();
    }
    public Vendedor(String nome, String email, String password, String morada, String dataN) {
        super(nome, email, password, morada, dataN);
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
    public Set<String> getPortf() {
        Set<String> copia = new TreeSet<>();
        for (String r: this.portfolio) copia.add(r);
        return copia;
    }
    public Set<String> getHist() {
        Set<String> copia = new TreeSet<>();
        for (String r: this.historico) copia.add(r);
        return copia;
    }
    
    public void adicionaImovelVenda(String ref) {
        this.portfolio.add(ref);
    }
    
    public static void adicionaConsulta(String ref) {
        Consulta nova = new Consulta(ref);
        consultas.add(nova);
    }
    public static void adicionaConsulta(String email, String ref) {
        Consulta nova = new Consulta(email, ref);
        consultas.add(nova);
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
