import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import Exceptions.*;

public class Comprador extends Utilizador { 
    // variáveis de instância
    private Set<String> favoritos;
    
    /**
     * Construtores para objetos da classe Comprador
     */
    public Comprador() {
        super();
        this.favoritos = new TreeSet<>();
    }
    public Comprador(String nome, String email, String password, String morada, String dataN) {
        super(nome, email, password, morada, dataN);
        this.favoritos = new TreeSet<>();
    }
    public Comprador(Comprador c) {
        super(c);
        this.favoritos = c.getFavoritos();
    }
    
    /**
     * Métodos de instância da classe Comprador
     */
    public Set<String> getFavoritos() {
        Set<String> copia = new TreeSet<>();
        for (String r: this.favoritos) copia.add(r);
        return copia;
    }
    
    public void setFavorito(String idImovel) throws ImovelInexistenteException, SemAutorizacaoException {
        if (!Imoobiliaria.existeImovel(idImovel)) throw new ImovelInexistenteException();
        if (!ImoobiliariaAPP.getAtualUser().getClass().getName().equals("Comprador")) throw new SemAutorizacaoException();
        favoritos.add(idImovel);
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
