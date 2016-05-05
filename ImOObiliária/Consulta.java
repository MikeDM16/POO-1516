import java.util.GregorianCalendar;

public class Consulta {
    // variáveis de instância
    private GregorianCalendar data;
    private String emailUser;
    private String referenciaImovel;

    /**
     * Construtor para objetos da classe Consulta
     */
    public Consulta(String referenciaImovel) {
        this.data = new GregorianCalendar();
        this.emailUser = null;
        this.referenciaImovel = referenciaImovel;
    }
    
    public Consulta(String email, String referenciaImovel) {
        this.data = new GregorianCalendar();
        this.emailUser = email;
        this.referenciaImovel = referenciaImovel;
    }
}
