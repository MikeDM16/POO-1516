import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import Exceptions.*;

public class Imoobiliaria {
    // variáveis de instância
    private Map<String, Utilizador> utilizadores;  /* Chave == email */
    private Map<Integer, Imovel> imoveis;          /* Chave == referência */
    int quantos;

    /**
     * Construtores para objetos da classe Imoobiliaria
     */
    public Imoobiliaria() {
        this.utilizadores = new TreeMap<>();
        this.imoveis = new TreeMap<>();
        this.quantos = 0;
    }
    
    /**
     * Métodos de instância da classe Imoobiliaria
     */
    public Map<String, Utilizador> getUtilizadores() {
        return (this.utilizadores);
    }
    
    public boolean existeUtilizador(Utilizador utilizador) {
        return (this.utilizadores.containsKey(utilizador.getEmail()));
    }
   
    public void registarUtilizador (Utilizador utilizador) throws UtilizadorExistenteException {
        if (existeUtilizador(utilizador)) throw new UtilizadorExistenteException();
        this.utilizadores.put(utilizador.getEmail(), utilizador);
    }
}
