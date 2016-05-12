import java.lang.*;
import java.util.*;
import java.io.*;
import Exceptions.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.joining;

public class Imoobiliaria implements Serializable {
    // variáveis de instância
    private Map<String, Utilizador> utilizadores;         // Chave == email
    private Map<String, Imovel> imoveis;                  // Chave == referência do imóvel
    private Map<String, Leilao> leiloes;                  // Chave == referência do imóvel
    
    private String atualUser;
    private boolean online;
    private int count;
    private Vendedor admin;
    
    /**
     * Construtores para objetos da classe Imoobiliaria
     */
    public Imoobiliaria() {
        this.utilizadores = new TreeMap<>();
        this.imoveis = new TreeMap<String, Imovel>();
        this.leiloes = new TreeMap<String, Leilao>();
        this.count = 0;
        this.admin = new Vendedor("admin", "admin@email.com", "123", "n/a", "n/a");
        this.atualUser = "admin@email.com";
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
    public Map<String, Leilao> getLeiloes() {
        Map<String, Leilao> copia = new TreeMap<>();
        for(Map.Entry<String, Leilao> e: leiloes.entrySet())
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
    public String getAtualUser() {
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
        return (this.utilizadores.get(atualUser).getClass().getName().equals(nomeClasse));
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
        if (password == null) throw new SemAutorizacaoException();
        Utilizador aux = getUtilizadores().get(email);
        if (!aux.getPassword().equals(password)) throw new SemAutorizacaoException();
        else {
            this.atualUser = email;
            this.online = true;
        }
    }
    
    /**
     * Função responsável por fechar a sessão do utilizador atual
     */
    public void fechaSessao() {
        this.online = false;
    }
    
    public void registarConsulta(String ref) {
        Imovel i = this.getImovel(ref);
        i.incConsulta();
        Vendedor proprietario = (Vendedor)this.getUtilizador(i.getProprietario());
        if (this.online == true) proprietario.adicionaConsulta(this.atualUser, ref);
        else proprietario.adicionaConsulta(ref);
    }
    
    public void registarUtilizador(Utilizador utilizador) throws UtilizadorExistenteException {
        if (existeUtilizador(utilizador)) throw new UtilizadorExistenteException();
        this.utilizadores.put(utilizador.getEmail(), utilizador);
        System.out.println(utilizador.getNome() + ", " + utilizador.getClass().getName() + " registado com sucesso!");
    }
    
    public void registaImovel(Imovel im) throws ImovelExisteException, SemAutorizacaoException {
        if (!this.temAutorizacao("Vendedor")) throw new SemAutorizacaoException();
        if (this.existeImovel(im)) throw new ImovelExisteException();
        this.imoveis.put(im.getId(), im);
        Vendedor atual = (Vendedor)this.utilizadores.get(this.atualUser); 
        atual.adicionaImovelVenda(im.getId());
        this.count++;
        System.out.println(im.getProprietario() + " registou com sucesso o/a " + im.getClass().getName() + ", com a referência " + im.getId());
    }
    
    public List<Consulta> getConsultas() {
        Vendedor v = (Vendedor)this.utilizadores.get(atualUser);
        return v.getConsultasVend();
    }
    
    public List<Imovel> getImovel(String classe, int preco) throws ClassNotFoundException {
        List<Imovel> nova = new ArrayList<Imovel>();
        for (Map.Entry<String, Imovel> i: this.imoveis.entrySet()) {
            Imovel aux = i.getValue();
            if (Class.forName(classe).isInstance(aux) && aux.getPrecoPedido() <= preco) {
                nova.add(aux.clone());
                if (aux.getEstado().equals("Em venda")) this.registarConsulta(aux.getId());
            }
        }
        return nova;
    }
        
    public Set<String> getTopImoveis(int n) {
        Vendedor v = (Vendedor)this.utilizadores.get(atualUser);
        return v.getPortf().stream().filter(ref -> this.getNConsultas(ref) >= n).collect(Collectors.toSet());
    }
    
    public List<Habitavel> getHabitaveis(int preco) {
        List<Habitavel> lista = new ArrayList<Habitavel>();
        for (Map.Entry<String, Imovel> i: this.imoveis.entrySet()) {
            Imovel aux = i.getValue();
            if ((aux instanceof Habitavel) && (aux.getPrecoPedido() <= preco)) {
                lista.add((Habitavel)aux.clone());
                if (aux.getEstado().equals("Em venda")) this.registarConsulta(aux.getId());
            }
        }
        return lista;
     }
    
    public Map<Imovel, Vendedor> getMapeamentoImoveis() {
        Map<Imovel, Vendedor> novo = new TreeMap<Imovel, Vendedor>(new ComparatorImovelRef());
        for (Map.Entry<String, Imovel> i: this.imoveis.entrySet()) {
            Imovel aux = (Imovel)i.getValue().clone();
            if (aux.getEstado().equals("Em venda")) this.registarConsulta(aux.getId());
            Vendedor v = (Vendedor)getUtilizador(aux.getProprietario()).clone();
            novo.put(aux, v);
        }
        return novo;
    }
     
    public void setFavorito(String idImovel) throws ImovelInexistenteException, SemAutorizacaoException {
        if (!this.existeImovel(idImovel)) throw new ImovelInexistenteException();
        if (!temAutorizacao("Comprador")) throw new SemAutorizacaoException();
        Comprador c = (Comprador)this.utilizadores.get(atualUser);
        c.addFavorito(idImovel);
    }
    
    public TreeSet<Imovel> getFavoritos() throws SemAutorizacaoException {
        if (!temAutorizacao("Comprador")) throw new SemAutorizacaoException();
        Comprador c = (Comprador)this.utilizadores.get(atualUser);
        TreeSet<Imovel> favImoveis = new TreeSet<Imovel>(new ComparatorImovelPreco());
        Set<String> favStrings = c.getFavoritos();
        for (String s: favStrings) favImoveis.add(getImovel(s).clone());
        return favImoveis;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder("--- Imóveis ---\n");
        sb.append(this.imoveis.values().stream().map(Imovel::toString).collect(joining("\n")));
        sb.append(this.utilizadores.values().stream().map(Utilizador::toString).collect(joining("\n")));
        sb.append(this.leiloes.values().stream().map(Leilao::toString).collect(joining("\n")));
        sb.append(this.count);
        return sb.toString();
    }
    
    public void gravaObj(String fich) throws IOException { 
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fich)); 
        oos.writeObject(this); 
        oos.flush(); 
        oos.close(); 
    } 

    public static Imoobiliaria leObj(String fich) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fich));
        Imoobiliaria te = (Imoobiliaria)ois.readObject();
        ois.close();
        return te;
    }

    public void log(String f, boolean ap) throws IOException {
        FileWriter fw = new FileWriter(f, ap);
        fw.write("\n----------- LOG - LOG - LOG - LOG - LOG ----------------\n");
        fw.write(this.toString());
        fw.write("\n----------- LOG - LOG - LOG - LOG - LOG ----------------\n");
        fw.flush();
        fw.close();
    }
    
    public void adicionaLeilao(String im, int horas) throws SemAutorizacaoException {
        if (!temAutorizacao("Vendedor")) throw new SemAutorizacaoException();
        Imovel i = imoveis.get(im);
        if (i.getProprietario().equals(this.atualUser)) throw new SemAutorizacaoException();
        Leilao novo = new Leilao();
        novo.iniciaLeilao(i, horas);
        this.leiloes.put(im, novo);
    }
    
    public void arrancaLeilaoAux(String im) throws LeilaoTerminadoException {
        Leilao l = this.leiloes.get(im);
        Imovel i = this.imoveis.get(im);
        l.arrancaLeilao();
        String idVencedor = l.encerraLeilao();
        Comprador vencedor = null;
        if (l.getMaiorLicitacao() >= i.getPrecoMin()) {
            vencedor = (Comprador)getUtilizador(idVencedor);
            i.setEstado("Reservado");
            System.out.println("O Vencedor é " + vencedor.getNome() + " com uma licitação de " + l.getMaiorLicitacao() + "€");
        }
        else System.out.println("A maior licitação foi " + l.getMaiorLicitacao() + "€, inferior ao preço mínimo pedido de " + i.getPrecoMin());
    }
    
    public void participaLeilao(String im, double limite, double incrementos, double minutos) throws LeilaoTerminadoException {
        Leilao l = this.leiloes.get(im);
        if (l == null) {
            System.out.println("Não existe leilão para esse imóvel");
            return;
        }
        l.adicionaComprador(this.atualUser, limite, incrementos, minutos);
    }
}