import java.util.*;
import Exceptions.*;

public class Leilao {
    // variáveis de instância
    private GregorianCalendar encerramento;
    private String referencia;
    private Map<String, Comprador> compradores;

    /**
     * Construtor para objetos da classe Leilao
     */
    public Leilao() {
        this.referencia = "n/a";
        this.compradores = new TreeMap<String, Comprador>();
    }
    
    public void iniciaLeilao(Imovel im, int horas) throws SemAutorizacaoException {
        GregorianCalendar agora = new GregorianCalendar();
        long a = agora.getTimeInMillis() + horas * 60 * 60 * 100;
        this.encerramento = new GregorianCalendar();
        this.encerramento.setTimeInMillis(a);
        this.referencia = im.getReferencia();
        this.compradores = new TreeMap<String, Comprador>();
    }
    
    public void adicionaComprador(String idComprador, double limite, double incrementos, double minutos) throws LeilaoTerminadoException {
        GregorianCalendar agora = new GregorianCalendar();
        if (agora.equals(encerramento)) throw new LeilaoTerminadoException();
    }
}
