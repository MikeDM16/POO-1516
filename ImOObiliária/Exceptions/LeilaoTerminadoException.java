package Exceptions;

public class LeilaoTerminadoException extends Exception {
    /**
     * Construtores
     */
    public LeilaoTerminadoException(){
        super();
    }
    public LeilaoTerminadoException(String mensagem){
        super(mensagem);
    }
    public String getMensagem() {
        return "Leilão terminado!\n";
    }
}