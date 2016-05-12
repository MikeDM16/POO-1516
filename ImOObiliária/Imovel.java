import java.lang.String;
import java.io.*;

public abstract class Imovel implements Serializable {
    // variáveis de instância
    private String ref, proprietario;
    private String rua;
    private float precoPedido, precoMin;
    private int consultas;
    private String estado;

    /**
     * Construtores para objetos da classe Imovel
     */
    public Imovel() {
        this.rua = "n/a";
        this.precoPedido = 0;
        this.precoMin = 0;
        this.consultas = 0;
        this.estado = "n/a";
        this.proprietario = "n/a";
    }
    public Imovel(int count, String prop, String rua, float precoPedido, float precoMin) {
        this.rua = rua;
        this.precoPedido = precoPedido;
        this.precoMin = precoMin;
        this.consultas = 0;
        this.estado = "Em venda";
        this.proprietario = prop;
    }
    public Imovel(Imovel i) {
        this.rua = i.rua;
        this.precoPedido = i.precoPedido;
        this.precoMin = i.precoMin;
        this.consultas = i.consultas;
        this.estado = i.estado;
        this.proprietario = i.proprietario;
    }
    
    /**
     * Métodos de instância da classe Imovel
     */
    public String getRua() {
        return this.rua;
    }
    public float getPrecoPedido() {
        return this.precoPedido;
    }
    public float getPrecoMin() {
        return this.precoMin;
    }
    public String getId() {
        return this.ref;
    }
    public int getConsultas() {
        return this.consultas;
    }
    public String getEstado() {
        return this.estado;
    }
    public String getProprietario() {
        return this.proprietario;
    }
    
    public void setRua(String r) {
        this.rua = r;
    }
    public void setPrecoPedido(float p) {
        this.precoPedido = p;
    }
    public void setPrecoMin(float p) {
        this.precoMin = p;
    }
    public void incConsulta() {
        this.consultas++;
    }
    public void setReferencia(String ref) {
        this.ref = ref;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void geraReferencia(int count) {
        StringBuilder sb = new StringBuilder();
        switch (this.getClass().getName()) {
            case "Moradia":
                Moradia m = (Moradia)this;
                sb.append("Mor-" + count);
                break;
            case "Apartamento":
                Apartamento a = (Apartamento)this;
                sb.append("Apar-" + count);
                break;
            case "Loja":
                Loja l = (Loja)this;
                sb.append("Loj-" + count);
                break;
            case "LojaHabitavel":
                LojaHabitavel lh = (LojaHabitavel)this;
                sb.append("LojH-" + count);
                break;
            case "Terreno":
                Terreno t = (Terreno)this;
                sb.append("Terr-" + count);
                break;
        }
        this.ref = sb.toString();
    }
    
    public abstract Imovel clone();
    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null) || (this.getClass() != this.getClass())) return false;
        Imovel i = (Imovel)obj;
        return (this.rua.equals(i.rua) && this.precoPedido == i.precoPedido && 
                this.precoMin == i.precoMin);
    }
}
