package Exceptions;

public class SemAutorizacaoException extends Exception {
    /**
     * Construtores
     */
    public SemAutorizacaoException(){
        super();
    }
    public SemAutorizacaoException(String mensagem){
        super(mensagem);
    }
    public String getMensagem() {
        return "Não tem autorização!\n";
    }
}