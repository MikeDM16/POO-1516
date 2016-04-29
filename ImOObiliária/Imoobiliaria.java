import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;

public class Imoobiliaria {
    private Map<String, Atores> utilizadores;  /* Chave == email */
    private Map<Integer, Imoveis> imoveis;     /* Chave == referência */
    int quantos;

    /**
     * Construtores para objetos da classe Imoobiliaria
     */
    public Imoobiliaria() {
        this.utilizadores = new TreeMap<>();
        this.imoveis = new TreeMap<>();
        this.quantos = 0;
    }
}
