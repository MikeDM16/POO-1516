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
    public String SemAutorizacaoException() {
        return "Não tem autorização para inicar sessão!\n";
    }
}