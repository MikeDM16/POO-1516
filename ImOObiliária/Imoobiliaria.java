import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;

public class Imoobiliaria {
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
    
    public static void initApp() {
        Vendedor v1 = new Vendedor("Esmeralda Fernandes", "esmeralda@email.com", "esmeralda", "Rua da Universidade, N.º 1", "01-02-1996");
        Vendedor v2 = new Vendedor("Diogo Machado", "diogo@email.com", "diogo", "Rua do Paraíso, N.º 2", "03-04-1996");
        Vendedor v3 = new Vendedor("Miguel Miranda", "miguel@email.com", "miguel", "Travessa dos Machados, N.º 3", "05-06-1996");
        Vendedor v4 = new Vendedor("Rui Leite", "rui@email.com", "rui", "Rua dos Peões, N.º4", "07-08-1996");
        Comprador c1 = new Comprador("Maria", "maria@email.com", "maria", "Rua das Árvores, N.º5", "01-01-1981");
    }
    
    public void registarUtilizador(Utilizador utilizador) {
    }
}
