import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.Set;
import java.lang.Class;
import Exceptions.*;
import java.lang.ClassNotFoundException;

public class Imoobiliaria {
    // variáveis de instância
    private static Map<String, Utilizador> utilizadores;         /* Chave == email */
    private static Map<String, Imovel> imoveis;           /* Chave == referência */
    private static int count;

    /**
     * Construtores para objetos da classe Imoobiliaria
     */
    public Imoobiliaria() {
        this.utilizadores = new TreeMap<>();
        this.imoveis = new TreeMap<String, Imovel>();
        this.count = 0;
    }
    
    /**
     * Métodos de instância da classe Imoobiliaria
     */
    public Map<String, Utilizador> getUtilizadores() {
        Map<String, Utilizador> copia = new TreeMap<>();
        for (Map.Entry<String, Utilizador> e: utilizadores.entrySet())
            copia.put(e.getKey(), e.getValue().clone()); 
        return copia;
    }
    public Map<String, Imovel> getImoveis() {
        Map<String, Imovel> copia = new TreeMap<>();
        for(Map.Entry<String, Imovel> e: imoveis.entrySet())
            copia.put(e.getKey(), e.getValue().clone()); 
        return copia;
    }
    public static int getCount() {
        return count;
    }
    
    public Utilizador getUtilizador(String email) {
        return (this.utilizadores.get(email));
    }
    public Imovel getImovel(String ref) {
        return (this.imoveis.get(ref));
    }
    
    public boolean existeUtilizador(Utilizador utilizador) {
        return (this.utilizadores.containsValue(utilizador));
    }
    public boolean existeUtilizador(String email) {
        return (this.utilizadores.containsKey(email));
    }
    
    public static boolean existeImovel(Imovel imovel) {
        return (imoveis.containsValue(imovel));
    }
    public static boolean existeImovel(String referencia) {
        return (imoveis.containsKey(referencia));
    }
    
    public void registarUtilizador(Utilizador utilizador) throws UtilizadorExistenteException {
        if (existeUtilizador(utilizador)) throw new UtilizadorExistenteException();
        this.utilizadores.put(utilizador.getEmail(), utilizador);
        System.out.println(utilizador.getNome() + ", " + utilizador.getClass().getName() + " registado com sucesso!");
    }
    
    public void registarImovel(Imovel im) throws ImovelExisteException, SemAutorizacaoException {
        if (!ImoobiliariaAPP.temAutorizacao("Vendedor")) throw new SemAutorizacaoException();
        if (existeImovel(im)) throw new ImovelExisteException();
        this.imoveis.put(im.getReferencia(), im);
        Vendedor atual = (Vendedor)ImoobiliariaAPP.getAtualUser(); 
        atual.adicionaImovelVenda(im.getReferencia());
        this.count++;
        System.out.println(im.getProprietario() + " registou com sucesso o/a " + im.getClass().getName() + ", com a referência " + im.getReferencia());
    }
    
    public List<Imovel> getImovel(String classe, int preco) throws ClassNotFoundException {
        List<Imovel> nova = new ArrayList<Imovel>();
        for (Map.Entry<String, Imovel> i: imoveis.entrySet()) {
            Imovel aux = i.getValue();
            if (Class.forName(classe).isInstance(aux) && aux.getPrecoPedido() <= preco) nova.add(aux.clone());
        }
        return nova;
    }
}