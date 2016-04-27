import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;

public class Comprador extends Atores {
    // variáveis de instância
    private ArrayList<Imoveis> favoritos;
    
    /**
     * Construtores para objetos da classe Comprador
     */
    public Comprador() {
        super();
        this.favoritos = new ArrayList<>();
    }
    public Comprador(String nome, String email, String password, String morada, String dataN) {
        super(nome, email, password, morada, dataN, "Comprador");
        this.favoritos = new ArrayList<>();
    }
    public Comprador(Comprador c) {
        super(c);
        this.favoritos = new ArrayList<>();
    }
    
    /**
     * Métodos de instância da classe Comprador
     */
    public ArrayList<Imoveis> getFav() {
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
