import java.lang.String;

public class Imoveis {
    // variáveis de instância
    private int ref;
    private String rua;
    private float precoPedido, precoMin;

    /**
     * Construtores para objetos da classe Imoveis
     */
    public Imoveis() {
        this.rua = "n/a";
        this.precoPedido = 0;
        this.precoMin = 0;
        this.ref = 0;
    }
    public Imoveis(String rua, float precoPedido, float precoMin, int ref) {
        this.rua = rua;
        this.precoPedido = precoPedido;
        this.precoMin = precoMin;
        this.ref = ref;
    }
    public Imoveis(Imoveis i) {
        this.rua = i.rua;
        this.precoPedido = i.precoPedido;
        this.precoMin = i.precoMin;
        this.ref = i.ref;
    }
    
    /**
     * Métodos de instância da classe Imoveis
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
    
    public void setRua(String r) {
        this.rua = r;
    }
    public void setPrecoPedido(float p) {
        this.precoPedido = p;
    }
    public void setPrecoMin(float p) {
        this.precoMin = p;
    }
    
    public Imoveis clone() {
        return new Imoveis(this);
    }
    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null) || (this.getClass() != this.getClass())) return false;
        Imoveis i = (Imoveis)obj;
        return (this.rua.equals(i.rua) && this.precoPedido == i.precoPedido && 
                this.precoMin == i.precoMin);
    }
    
    public String toString(Imoveis i) {
        StringBuilder s = new StringBuilder();
        s.append("Rua: "            + this.getRua() + "\n");
        s.append("Preço pedido: "   + this.getPrecoPedido() + "\n");
        return s.toString();
    }
}
