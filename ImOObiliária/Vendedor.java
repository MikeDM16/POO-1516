import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;

public class Vendedor extends Atores {
    
    // variáveis de instância
    private ArrayList<Imoveis> portfolio, historico;
    
    /**
     * Construtor para objetos da classe Vendedor
     */
    public Vendedor(String n, String e, String p, String m, String d) {
        super(n,e,p,m,d);
        this.portfolio = new ArrayList<>();
        this.historico = new ArrayList<>();
    }
    public Vendedor(Atores c){
        super(c);
        this.portfolio = new ArrayList<>();
        this.historico = new ArrayList<>();
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
    
    public Vendedor clone(Vendedor c) {
        Atores novoAtor = new Atores(c.getNome(), c.getEmail(), c.getPass(), c.getMorada(), c.getDataN());
        Vendedor novo = new Vendedor(novoAtor);
        novo.portfolio = copiaArrayL(c.getPortf());
        novo.historico = copiaArrayL(c.getHist());
        return novo;
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
