import java.util.*;
import java.lang.*;
import java.io.*;

public class Licitador implements Serializable {
    // variáveis de instância
    private String idLicitador;
    private double limite, incrementos, minutos;
    private double licitacao;
    private GregorianCalendar ultLicitacao;
    
    /**
     * Construtor para objetos da classe Licitador
     */
    public Licitador(String idComprador, double limite, double incrementos, double minutos) {
        this.idLicitador = idComprador;
        this.limite = limite;
        this.incrementos = incrementos;
        this.minutos = minutos;
        this.licitacao = 0;
    }
    
    /**
     * Métodos de instância
     */
    public double getLimite() {
        return this.limite;
    }
    public String getIdLicitador() {
        return this.idLicitador;
    }
    public double getLicitacao() {
        return this.licitacao;
    }
    
    public void setUltimaLicitacao() {
        this.ultLicitacao = new GregorianCalendar();
    }
    
    public int Licitar(double licitacaoMaior, String idVencedor) {
        GregorianCalendar agora = new GregorianCalendar();
        long difInMilis = agora.getTimeInMillis() - (this.ultLicitacao.getTimeInMillis());
        if (difInMilis < this.minutos * 1000) return (-2); // Não é hora de licitar
        if (this.idLicitador.equals(idVencedor)) return (-1); // Não vale a pena licitar
        if (this.licitacao + this.incrementos > this.limite) { // Atingi o limite
            this.licitacao = this.limite;
            ultLicitacao = agora;
            return 0;
        }
        if (this.licitacao + this.incrementos <= licitacaoMaior) { // Tenho que incrementar várias vezes para atingir o vencedor
            while (this.licitacao <= licitacaoMaior) {
                if (this.licitacao + this.incrementos < this.limite) this.licitacao += this.incrementos;
                else {
                    this.licitacao = this.limite;
                    return 0;
                }
            }
            ultLicitacao = agora;
        }
        else { // Licitação normal
            ultLicitacao = agora;
            this.licitacao += this.incrementos;
        }
        return 1;
    }
}
