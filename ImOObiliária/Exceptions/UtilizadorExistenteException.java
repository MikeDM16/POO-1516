package Exceptions;

public class UtilizadorExistenteException extends Exception {
    /**
     * Construtores
     */
    public UtilizadorExistenteException(){
        super();
    }
    public UtilizadorExistenteException(String mensagem){
        super(mensagem);
    }
    public String getMensagem() {
        return "Esse utilizador já existe!\n";
    }
}
