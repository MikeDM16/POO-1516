public class Loja extends Imovel {
    // Variaveis da instancia
    private int numPorta;
    private double area;
    private String tipoNeg;
    private boolean wc;
    
    /**
     * Construtores para objetos da classe Loja
     */
    public Loja() {
        super();
        this.numPorta = 0;
        this.area = 0.0;
        this.tipoNeg = "n/a";
        this.wc = false;
        this.setReferencia("n/a");
    }
    public Loja(int count, String prop, String rua, float precoPedido, float precoMin, boolean wc, int numPorta, double area, String tipoNegocio) {
        super(count, prop, rua, precoPedido, precoMin);
        this.wc = wc;
        this.numPorta = numPorta;
        this.area = area;
        this.tipoNeg = tipoNegocio;
        this.geraReferencia(count);
    }
    public Loja(Loja l){ 
        super(l);
        this.wc = l.wc;
        this.numPorta = l.numPorta;
        this.area = l.area;
        this.tipoNeg = l.tipoNeg;
        this.setReferencia(l.getReferencia());
    }
    
    /**
     * Métodos de instância da classe Loja
     */
    public boolean getWC() {
        return this.wc;
    }
    public int getNumPorta() {
        return this.numPorta;
    }
    public double getArea() {
        return this.area;
    }
    public String getTNeg() {
        return this.tipoNeg;
    }
    
    public void setWC(boolean n) {
        this.wc = n;
    }
    public void setNumPorta(int n) {
        this.numPorta = n;
    }
    public void setArea(double a) {
        this.area = a;
    }
    public void setTNeg(String s) {
        this.tipoNeg = s;
    }
    
    public Loja clone() {
        return new Loja(this);
    }
    
    public boolean equals(Object obj) {
        boolean result = super.equals(obj);
        if (result == false) return false;
        Loja l = (Loja)obj;
        return (this.numPorta == l.numPorta && this.area == l.area &&
                this.tipoNeg.equals(l.tipoNeg) && this.wc == l.wc);
        
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Estado: "             + this.getEstado() + "\n");
        s.append("Rua: "                + this.getRua() + "\n");
        s.append("Preço pedido: "       + this.getPrecoPedido() + "\n");
        s.append("Área : "              + this.area + " m^2\n");
        s.append("Tipo de negócio: "    + this.tipoNeg + "\n");
        s.append("Número de porta: "    + this.numPorta + "\n");
        s.append("Tipo de negócio: "    + this.tipoNeg + "\n");
        if (this.wc == true) s.append ("WC: Sim\n");
        else s.append ("WC: Não\n");
        return s.toString();
    }
}
