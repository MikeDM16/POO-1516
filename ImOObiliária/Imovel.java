import java.lang.String;

public abstract class Imovel {
    // variáveis de instância
    private String ref;
    private String rua;
    private float precoPedido, precoMin;
    private int consultas;

    /**
     * Construtores para objetos da classe Imovel
     */
    public Imovel() {
        this.rua = "n/a";
        this.precoPedido = 0;
        this.precoMin = 0;
        this.ref = "n/a";
        this.consultas = 0;
    }
    public Imovel(String rua, float precoPedido, float precoMin, String ref) {
        this.rua = rua;
        this.precoPedido = precoPedido;
        this.precoMin = precoMin;
        this.ref = ref;
        this.consultas = 0;
    }
    public Imovel(Imovel i) {
        this.rua = i.rua;
        this.precoPedido = i.precoPedido;
        this.precoMin = i.precoMin;
        this.ref = i.ref;
        this.consultas = i.consultas;
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
    public String getReferencia() {
        return this.ref;
    }
    public int getConsultas() {
        return this.consultas;
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
    public void addConsulta() {
        this.consultas++;
    }
    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null) || (this.getClass() != this.getClass())) return false;
        Imovel i = (Imovel)obj;
        return (this.rua.equals(i.rua) && this.precoPedido == i.precoPedido && 
                this.precoMin == i.precoMin);
    }
    
    public String toString(Imovel i) {
        StringBuilder s = new StringBuilder();
        s.append("Rua: "            + this.getRua() + "\n");
        s.append("Preço pedido: "   + this.getPrecoPedido() + "\n");
        return s.toString();
    }
}
