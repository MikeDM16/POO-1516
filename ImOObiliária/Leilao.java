import java.util.*;
import java.io.*;
import Exceptions.*;

public class Leilao implements Serializable {
    // variáveis de instância
    private GregorianCalendar encerramento;
    private String referencia;
    private String idVencedor;
    private int horas;
    private double maiorLicitacao;
    private Map<String, Licitador> licitadores;

    /**
     * Construtor para objetos da classe Leilao
     */
    public Leilao() {
        this.referencia = "n/a";
        this.idVencedor = "n/a";
        this.licitadores = new TreeMap<String, Licitador>();
    }
    
    public Leilao(Leilao l) {
        this.encerramento = l.getEncerramento();
        this.referencia = l.getReferencia();
        this.idVencedor = l.getIdVencedor();
        this.horas = l.getHoras();
        this.maiorLicitacao = l.getMaiorLicitacao();
        this.licitadores = l.getLicitadores();
    }
    
    /**
     * Métodos de instância
     */
    public double getMaiorLicitacao() {
        return this.maiorLicitacao;
    }
    public String getReferencia() {
        return this.referencia;
    }
    public GregorianCalendar getEncerramento() {
        return this.encerramento;
    }
    public String getIdVencedor() {
        return this.idVencedor;
    }
    public int getHoras(){
        return this.horas;
    }
    public Map<String, Licitador> getLicitadores() {
        Map<String, Licitador> novo = new TreeMap<String, Licitador>();
        for (Map.Entry<String, Licitador> v: this.licitadores.entrySet()) {
            novo.put(v.getKey(), v.getValue());
        }
        return novo;
    }
    
    public void iniciaLeilao(Imovel im, int horas) throws SemAutorizacaoException {
        GregorianCalendar agora = new GregorianCalendar();
        this.horas = horas;
        this.referencia = im.getId();
        this.maiorLicitacao = 0;
    }
    
    public void adicionaComprador(String idComprador, double limite, double incrementos, double minutos) throws LeilaoTerminadoException {
        GregorianCalendar agora = new GregorianCalendar();
        if (agora.equals(encerramento)) throw new LeilaoTerminadoException();
        Licitador novo = new Licitador(idComprador, limite, incrementos, minutos);
        licitadores.put(idComprador, novo);
    }
    
    public void arrancaLeilao() throws LeilaoTerminadoException {
        GregorianCalendar agora = new GregorianCalendar();
        long a = agora.getTimeInMillis() + this.horas * 60 * 1000;
        this.encerramento = new GregorianCalendar();
        this.encerramento.setTimeInMillis(a);
        if (this.encerramento.getTimeInMillis() < agora.getTimeInMillis()) throw new LeilaoTerminadoException();
        for (Map.Entry<String, Licitador> v: this.licitadores.entrySet()) {
            Licitador l = (Licitador)v.getValue();
            l.setUltimaLicitacao();
        }
        System.out.println("O leilão iniciou e terminará a " + encerramento.getTime().toString() + "!\n");
        int tentativas = 0, res = 0;
        Licitador l = null;
        while (this.encerramento.getTimeInMillis() > (agora = new GregorianCalendar()).getTimeInMillis()) {
            for (Map.Entry<String, Licitador> v: this.licitadores.entrySet()) {
                l = (Licitador)v.getValue();
                if (l.getLimite() != l.getLicitacao()) {
                    res = l.Licitar(this.maiorLicitacao, this.idVencedor);
                    switch (res) {
                        case 0:
                            System.out.println("O licitador " + l.getIdLicitador() + " atingiu o seu limite de " + l.getLimite() + "€");
                            if (l.getLicitacao() > this.maiorLicitacao) {
                                this.maiorLicitacao = l.getLicitacao();
                                this.idVencedor = l.getIdLicitador();
                            }
                            break;
                        case 1:
                            System.out.println("O licitador " + l.getIdLicitador() + " apostou " + l.getLicitacao() + "€");
                            if (l.getLicitacao() > this.maiorLicitacao) {
                                this.maiorLicitacao = l.getLicitacao();
                                this.idVencedor = l.getIdLicitador();
                            }
                            break;
                    }
                }
            }
            tentativas++;
        }
        System.out.println("O leilão terminou!");
    }
    
    public String encerraLeilao() {
        return this.idVencedor;
    }
    
    public Leilao clone() {
        return new Leilao(this);
    }
    
    public String toString() {
        return new StringBuilder(this.referencia + "\t\t\t" + this.horas).toString();
    }
}
