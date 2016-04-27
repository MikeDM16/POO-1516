import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;

public class Vendedor extends Atores {
    // variáveis de instância
    private ArrayList<Imoveis> portfolio, historico;
    
    /**
     * Construtores para objetos da classe Vendedor
     */
    public Vendedor() {
        super();
        this.portfolio = new ArrayList<>();
        this.historico = new ArrayList<>();
    }
    public Vendedor(String nome, String email, String password, String morada, String dataN) {
        super(nome, email, password, morada, dataN, "Vendedor");
        this.portfolio = new ArrayList<>();
        this.historico = new ArrayList<>();
    }
    public Vendedor(Vendedor v){
        super(v);
        this.portfolio = copiaArrayL(v.portfolio);
        this.historico = copiaArrayL(v.historico);
    }
    
    /**
     * Métodos de instância da classe Vendedor
     */
    public ArrayList<Imoveis> getPortf() {
        return (this.portfolio);
    }
    public ArrayList<Imoveis> getHist() {
        return (this.historico);
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
