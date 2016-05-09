package Exceptions;

public class EstadoInvalidoException extends Exception {
    /**
     * Construtores
     */
    public EstadoInvalidoException(){
        super();
    }
    public EstadoInvalidoException(String mensagem){
        super(mensagem);
    }
    public String getMensagem() {
        return "Estado é inválido!\n";
    }
}
