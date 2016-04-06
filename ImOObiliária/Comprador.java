
/**
 * Escreva a descrição da classe Comprador aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;

public class Comprador {
    
    // variáveis de instância
    private String nome, email, password, morada, dataN;
    private ArrayList<Imoveis> favoritos;
    
    /**
     * Construtor para objetos da classe Comprador
     */
    public Comprador() {
        this(null, null, null, null, null); 
    }
    public Comprador(String n, String e, String p, String m, String d) {
        this.nome = n;
        this.email = e;
        this.password = p;
        this.morada = m;
        this.dataN = d;
        this.favoritos = new ArrayList<>();
    }
    public Comprador(Comprador c){
        this.nome = c.getNome();
        this.email = c.getEmail();
        this.password = c.getPass(); 
        this.morada = c.getMorada();
        this.dataN = c.getDataN();
        this.favoritos = copiaArrayL(c.getFav());
    }
    
    /**
     * Métodos de instância da classe Comprador
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
    public ArrayList<Imoveis> getFav() {
        return this.favoritos;
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
    
    public Comprador clone(Comprador c) {
        Comprador novo = new Comprador(c.getNome(), c.getEmail(), c.getPass(), c.getMorada(), c.getDataN());
        novo.favoritos = copiaArrayL(c.getFav());
        return novo;        
        /*return (new Comprador(c.getNome().clone(), c.getEmail().clone(), c.getPass().clone(), c.getMorada().clone(), c.getDataN().clone()));*/
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
