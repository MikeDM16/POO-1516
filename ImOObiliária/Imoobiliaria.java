import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import Exceptions.*;

public class Imoobiliaria {
    // variáveis de instância
    private Map<String, Utilizador> utilizadores;         /* Chave == email */
    private static Map<String, Imovel> imoveis;           /* Chave == referência */

    /**
     * Construtores para objetos da classe Imoobiliaria
     */
    public Imoobiliaria() {
        this.utilizadores = new TreeMap<>();
        this.imoveis = new TreeMap<>();
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
    
    public boolean existeImovel(Imovel imovel) {
        return (this.imoveis.containsKey(imovel.getReferencia()));
    }
    public static boolean existeImovel(String referencia) {
        return (imoveis.containsKey(referencia));
    }
    
    public String geraReferencia(String tipoImovel, String rua, int caract) {
        StringBuilder sb = new StringBuilder(tipoImovel);
        sb.append(rua.hashCode());
        sb.append(caract);
        return sb.toString();
    }
    
    private static void consultarImovel(String ref) {
        imoveis.get(ref).addConsulta();
        if (ImoobiliariaAPP.estaOnline()) Vendedor.adicionaConsulta(ImoobiliariaAPP.getAtualUser().getEmail(), ref);
        else Vendedor.adicionaConsulta(ref);
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
        System.out.println("Registado com sucesso o/a " + im.getClass().getName() + ", com a referência " + im.getReferencia());
    }
}
