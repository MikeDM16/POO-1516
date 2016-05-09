import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.Set;
import java.lang.Class;
import java.util.HashSet;
import java.util.stream.Collectors;
import Exceptions.*;
import java.lang.ClassNotFoundException;

public class Imoobiliaria {
    // variáveis de instância
    private Map<String, Utilizador> utilizadores;         /* Chave == email */
    private Map<String, Imovel> imoveis;                  /* Chave == referência */
    
    private Utilizador atualUser;
    private boolean online;
    private int count;
    private Vendedor admin;
    
    /**
     * Construtores para objetos da classe Imoobiliaria
     */
    public Imoobiliaria() {
        this.utilizadores = new TreeMap<>();
        this.imoveis = new TreeMap<String, Imovel>();
        this.count = 0;
        this.admin = new Vendedor("admin", "admin@email.com", "123", "n/a", "n/a");
        this.atualUser = admin;
        this.online = false;
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
    public Utilizador getUtilizador(String email) {
        return this.utilizadores.get(email);
    }
    public Imovel getImovel(String ref) {
        return this.imoveis.get(ref);
    }
    public int getCount() {
        return this.count;
    }
    public Utilizador getAdmin() {
        return this.admin;
    }
    /**
     * Método de aceder ao utilizador atual
     */
    public Utilizador getAtualUser() {
        return this.atualUser;
    }
    /**
     * Método que permite saber se o utilizador atual ainda está online
     */
    public boolean estaOnline() {
        return this.online;
    }
    public int getNConsultas(String ref) {
        return this.imoveis.get(ref).getConsultas();
    }
    
    public void setOnline(boolean e) {
        this.online = e;
    }
    public void setEstado(String idImovel, String estado) {
        Imovel i = this.imoveis.get(idImovel);
        i.setEstado(estado);
    }
    
    /**
     * Método que permite saber se o atual utilizador tem permissões de um dado tipo ("Vendedor" ou "Comprador")
     */
    public boolean temAutorizacao(String nomeClasse) {
        return (this.atualUser.getClass().getName().equals(nomeClasse));
    }
    
    public boolean existeUtilizador(Utilizador utilizador) {
        return (this.utilizadores.containsValue(utilizador));
    }
    public boolean existeUtilizador(String email) {
        return (this.utilizadores.containsKey(email));
    }
    
    public boolean existeImovel(Imovel imovel) {
        return (imoveis.containsValue(imovel));
    }
    public boolean existeImovel(String referencia) {
        return (imoveis.containsKey(referencia));
    }
    
    /**
     * Função que inicia a sessao de um utilizador (o email que recebe é válido)
     */
    public void iniciaSessao(String email, String password) throws SemAutorizacaoException {
        Utilizador aux = getUtilizadores().get(email);
        if (!aux.getPass().equals(password)) throw new SemAutorizacaoException();
        else {
            this.atualUser = aux;
            this.online = true;
        }
    }
    
    /**
     * Função responsável por fechar a sessão do utilizador atual
     */
    public void fechaSessao() {
        this.online = false;
    }
    
    public void registarConsulta (String ref) {
        Imovel i = this.getImovel(ref);
        i.incConsulta();
        Vendedor proprietario = (Vendedor)this.getUtilizador(i.getProprietario());
        if (this.estaOnline()) proprietario.adicionaConsulta(this.atualUser.getEmail(), ref);
        else proprietario.adicionaConsulta(ref);
    }
    
    public void registarUtilizador(Utilizador utilizador) throws UtilizadorExistenteException {
        if (existeUtilizador(utilizador)) throw new UtilizadorExistenteException();
        this.utilizadores.put(utilizador.getEmail(), utilizador);
        System.out.println(utilizador.getNome() + ", " + utilizador.getClass().getName() + " registado com sucesso!");
    }
    
    public void registarImovel(Imovel im) throws ImovelExisteException, SemAutorizacaoException {
        if (!this.temAutorizacao("Vendedor")) throw new SemAutorizacaoException();
        if (this.existeImovel(im)) throw new ImovelExisteException();
        this.imoveis.put(im.getReferencia(), im);
        Vendedor atual = (Vendedor)this.atualUser; 
        atual.adicionaImovelVenda(im.getReferencia());
        this.count++;
        System.out.println(im.getProprietario() + " registou com sucesso o/a " + im.getClass().getName() + ", com a referência " + im.getReferencia());
    }
    
    public List<Imovel> getImovel(String classe, int preco) throws ClassNotFoundException {
        List<Imovel> nova = new ArrayList<Imovel>();
        for (Map.Entry<String, Imovel> i: this.imoveis.entrySet()) {
            Imovel aux = i.getValue();
            if (Class.forName(classe).isInstance(aux) && aux.getPrecoPedido() <= preco) nova.add(aux.clone());
        }
        return nova;
    }
    
    public Set<String> getTopImoveis(int n) {
        Vendedor v = (Vendedor)this.atualUser;
        return v.getPortf().stream().filter(ref -> this.getNConsultas(ref) >= n).collect(Collectors.toSet());
    }
    
    public void setFavorito(String idImovel) throws ImovelInexistenteException, SemAutorizacaoException {
        if (!this.existeImovel(idImovel)) throw new ImovelInexistenteException();
        if (!temAutorizacao("Comprador")) throw new SemAutorizacaoException();
        Comprador c = (Comprador)this.atualUser;
        c.addFavorito(idImovel);
    }
}