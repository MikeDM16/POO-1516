
/**
 * Escreva a descrição da classe Vendedor aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;

public class Vendedor {
    
    // variáveis de instância
    private String nome, email, password, morada, dataN;
    private ArrayList<Imoveis> portfolio, historico;
    
    /**
     * Construtor para objetos da classe Vendedor
     */
    public Vendedor() {
        this(null, null, null, null, null);
    }
    public Vendedor(String n, String e, String p, String m, String d) {
        ArrayList<Imoveis> i = new ArrayList<>();
        ArrayList<Imoveis> h = new ArrayList<>();
        this.nome = n;
        this.email = e;
        this.password = p;
        this.morada = m;
        this.dataN = d;
        this.portfolio = i;
        this.historico = h;
    }
    public Vendedor(Vendedor c){
        this.nome = c.getNome();
        this.email = c.getEmail();
        this.password = c.getPass(); 
        this.morada = c.getMorada();
        this.dataN = c.getDataN();
        this.portfolio = copiaArrayL(c.getPortf());
        this.historico = copiaArrayL(c.getHist());
    }
    
    /**
     * Métodos de instância da classe Vendedor
     */
       
    public String getNome() {
        return this.nome;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPass() {
        return this.password;
    }
    public String getMorada() {
        return this.morada;
    }
    public String getDataN() {
        return this.dataN;
    }
    public ArrayList<Imoveis> getPortf() {
        return (this.portfolio);
    }
    public ArrayList<Imoveis> getHist() {
        return (this.historico);
    }
    
    public void setNome(String n) {
        this.nome = n;
    }
    public void setEmail(String e) {
        this.email = e;
    }
    public void setPass(String p) {
        this.password = p;
    }
    public void setMorada(String m) {
        this.morada = m;
    }
    public void setDataN(String d) {
        this.dataN = d;
    }
    
    public Vendedor clone(Vendedor c) {
        Vendedor novo = new Vendedor(c.getNome(), c.getEmail(), c.getPass(), c.getMorada(), c.getDataN());
        novo.portfolio = copiaArrayL(c.getPortf());
        novo.historico = copiaArrayL(c.getHist());
        return novo;
        /*return (new Vendedor(c.getNome().clone(), c.getEmail().clone(), c.getPass().clone(), c.getMorada().clone(), c.getDataN().clone()));*/
    }

    /**
     * Copia ArrayList de Imóveis
     * 
     * @param  a   ArrayList a copiar
     * @return     a cópia do ArrayList
     */
    private static ArrayList<Imoveis> copiaArrayL(ArrayList<Imoveis> a) {
        ArrayList<Imoveis> novo = new ArrayList<>();
        Imoveis p = null;
        for (Iterator<Imoveis> it = a.iterator(); it.hasNext(); ) {
            p = it.next();
            novo.add(p);
        }
        return novo;
    }
}
