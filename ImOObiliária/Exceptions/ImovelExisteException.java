package Exceptions;

public class ImovelExisteException extends Exception {
    /**
     * Construtores
     */
    public ImovelExisteException(){
        super();
    }
    public ImovelExisteException(String mensagem){
        super(mensagem);
    }
    public String getMensagem() {
        return "Este imóvel já existe!\n";
    }
}
