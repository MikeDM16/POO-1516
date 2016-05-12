import java.lang.String;
import java.util.ArrayList;
import java.io.*;

public abstract class Utilizador implements Serializable {
    // variáveis de instância
    private String nome, email, password, morada, dataN;

    /**
     * Construtor para objetos da classe Utilizador
     */
    public Utilizador() {
        this.nome = "n/a";
        this.email = "n/a";
        this.password = "n/a";
        this.morada = "n/a";
        this.dataN = "n/a";
    }
    public Utilizador(String nome, String email, String password, String morada, String dataN) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.morada = morada;
        this.dataN = dataN;
    }
    public Utilizador(Utilizador a) {
        this.nome = a.nome;
        this.email = a.email;
        this.password = a.password;
        this.morada = a.morada;
        this.dataN = a.dataN;
    }
    
    /**
     * Métodos de instância da classe Utilizador
     */
    public String getNome() {
        return this.nome;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
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
    
    public abstract Utilizador clone();
    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null) || (this.getClass() != this.getClass())) return false;
        Utilizador a = (Utilizador)obj;
        return (this.nome.equals(a.nome) && this.email.equals(a.email) &&
                this.password.equals(a.password) && this.morada.equals(a.morada) &&
                this.dataN.equals(a.dataN));
    }
    
    public String toString(Utilizador a) {
        StringBuilder s = new StringBuilder();
        s.append("Nome: "                 + this.getNome() + "\n");
        s.append("Email: "                + this.getEmail() + "\n");
        s.append("Morada: "               + this.getMorada() + "\n");
        s.append("Data de nascimento: "   + this.getDataN() + "\n");
        return s.toString();
    }
}
