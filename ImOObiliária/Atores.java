import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;

public class Atores
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String nome, email, password, morada, dataN;

    /**
     * Construtor para objetos da classe Atores
     */
    public Atores(String n, String e, String p, String m, String d) {
        this.nome = n;
        this.email = e;
        this.password = p;
        this.morada = m;
        this.dataN = d;
    }
    public Atores(Atores a) {
        this.nome = a.nome;
        this.email = a.email;
        this.password = a.password;
        this.morada = a.morada;
        this.dataN = a.dataN;
    }
    
    public String getNome() {
        return this.nome;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPass() {
        return this.password;
    }
    public String getMorada() {
        return this.morada;
    }
    public String getDataN() {
        return this.dataN;
    }
    
    public void setNome(String n) {
        this.nome = n;
    }
    public void setEmail(String e) {
        this.email = e;
    }
    public void setPass(String p) {
        this.password = p;
    }
    public void setMorada(String m) {
        this.morada = m;
    }
    public void setDataN(String d) {
        this.dataN = d;
    }
    
    public Atores clone() {
        return new Atores(this.nome, this.email, this.password, this.morada, this.dataN);
    }
}
