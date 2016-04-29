import java.lang.String;
import java.util.ArrayList;

public abstract class Atores {
    // variáveis de instância
    private String nome, email, password, morada, dataN, tipo;

    /**
     * Construtor para objetos da classe Atores
     */
    public Atores() {
        this.nome = "n/a";
        this.email = "n/a";
        this.password = "n/a";
        this.morada = "n/a";
        this.dataN = "n/a";
        this.tipo = "n/a";
    }
    public Atores(String nome, String email, String password, String morada, String dataN, String tipo) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.morada = morada;
        this.dataN = dataN;
        this.tipo = tipo;
    }
    public Atores(Atores a) {
        this.nome = a.nome;
        this.email = a.email;
        this.password = a.password;
        this.morada = a.morada;
        this.dataN = a.dataN;
        this.tipo = a.tipo;
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
    public String getTipo() {
        return this.tipo;
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
    public void setTipo(String t) {
        this.tipo = t;
    }
    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null) || (this.getClass() != this.getClass())) return false;
        Atores a = (Atores)obj;
        return (this.nome.equals(a.nome) && this.email.equals(a.email) &&
                this.password.equals(a.password) && this.morada.equals(a.morada) &&
                this.dataN.equals(a.dataN) && this.tipo.equals(a.tipo));
    }
    
    public String toString(Atores a) {
        StringBuilder s = new StringBuilder();
        s.append("Nome: "                 + this.getNome() + "\n");
        s.append("Email: "                + this.getEmail() + "\n");
        s.append("Morada: "               + this.getMorada() + "\n");
        s.append("Data de nascimento: "   + this.getDataN() + "\n");
        s.append("Estatuto do ator: "     + this.getTipo() + "\n");
        return s.toString();
    }
      
}
