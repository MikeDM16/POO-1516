import java.util.GregorianCalendar;
import java.lang.String;
import java.io.*;

public class Consulta implements Serializable {
    // variáveis de instância
    private GregorianCalendar data;
    private String emailUser;
    private String referenciaImovel;

    /**
     * Construtor para objetos da classe Consulta
     */
    public Consulta(String referenciaImovel) {
        this.data = new GregorianCalendar();
        this.emailUser = "Sem email";
        this.referenciaImovel = referenciaImovel;
    }
    
    public Consulta(String email, String referenciaImovel) {
        this.data = new GregorianCalendar();
        this.emailUser = email;
        this.referenciaImovel = referenciaImovel;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(referenciaImovel + "\t\t" + 
                  data.get(data.DAY_OF_MONTH) + "/" + (data.get(data.MONTH) + 1) + "/" + data.get(data.YEAR) + " " + 
                  data.get(data.HOUR_OF_DAY) + "H" + data.get(data.MINUTE) + "m" + data.get(data.SECOND) + "s" + "\t" +
                  emailUser);
        return sb.toString();
    }
}
