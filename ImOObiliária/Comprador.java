import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;

public class Comprador extends Atores {
    // variáveis de instância
    private ArrayList<Imoveis> favoritos;
    
    /**
     * Construtor para objetos da classe Comprador
     */
    public Comprador(String n, String e, String p, String m, String d) {
        super(n,e,p,m,d);
        this.favoritos = new ArrayList<>();
    }
    public Comprador(Atores a) {
        super(a);
        this.favoritos = new ArrayList<>();
    }
    
    /**
     * Métodos de instância da classe Comprador
     */
    public ArrayList<Imoveis> getFav() {
        return this.favoritos;
    }
    public Comprador clone(Comprador c) {
        Atores novoAtor = new Atores(c.getNome(), c.getEmail(), c.getPass(), c.getMorada(), c.getDataN());
        Comprador novo = new Comprador(novoAtor);
        novo.favoritos = copiaArrayL(c.getFav());
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
