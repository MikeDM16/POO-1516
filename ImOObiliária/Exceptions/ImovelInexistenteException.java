package Exceptions;

public class ImovelInexistenteException extends Exception {
    /**
     * Construtores
     */
    public ImovelInexistenteException(){
        super();
    }
    public ImovelInexistenteException(String mensagem){
        super(mensagem);
    }
    public String getMensagem() {
        return "Este imóvel não existe!\n";
    }
}
