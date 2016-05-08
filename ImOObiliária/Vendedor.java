import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import Exceptions.*;

public class Vendedor extends Utilizador {
    // variáveis de instância
    private Set<String> portfolio, historico;
    private List<Consulta> consultas;
    
    /**
     * Construtores para objetos da classe Vendedor
     */
    public Vendedor() {
        super();
        this.portfolio = new TreeSet<>();
        this.historico = new TreeSet<>();
        this.consultas = new ArrayList<>();
    }
    public Vendedor(String nome, String email, String password, String morada, String dataN) {
        super(nome, email, password, morada, dataN);
        this.portfolio = new TreeSet<>();
        this.historico = new TreeSet<>();
        this.consultas = new ArrayList<>();
    }
    public Vendedor(Vendedor v) {
        super(v);
        this.portfolio = v.getPortf();
        this.historico = v.getHist();
        this.consultas = v.getConsulta();
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
    public List<Consulta> getConsulta() {
        List<Consulta> copia = new ArrayList<>();
        for (Consulta i: this.consultas) copia.add(i);
        return copia;
    }
    
    public void imprimeImoveis() {
        for (String i: this.portfolio) {
            System.out.println(i);
        }
    }
    
    public void imprimeConsultas() {
        for (Consulta i: this.consultas) {
            System.out.println(i.toString());
        }
    }
    
    public List<Consulta> getConsultas() throws SemAutorizacaoException {
        List<Consulta> copia = new ArrayList<>();
        for (Consulta i: this.consultas) copia.add(i);
        return copia;
    }
    
    public void adicionaImovelVenda(String ref) {
        this.portfolio.add(ref);
    }
    
    public void adicionaConsulta(String ref) {
        Consulta nova = new Consulta(ref);
        this.consultas.add(nova);
    }
    public void adicionaConsulta(String email, String ref) {
        Consulta nova = new Consulta(email, ref);
        this.consultas.add(nova);
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
