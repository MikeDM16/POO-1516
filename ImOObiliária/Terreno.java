public class Terreno extends Imovel {
    // variáveis de instância
    private String proposito;
    private float diametroCanal;
    private int kWh, lote;
    private boolean redeEletr, esgoto;

    /**
     * Construtor para objetos da classe Terreno
     */
    public Terreno() {
        super();
        this.proposito = "n/a";
        this.diametroCanal = 0;
        this.kWh = 0;
        this.redeEletr = false;
        this.esgoto = false;
        this.lote = 0;
        this.setReferencia("n/a");
    }
    public Terreno(int count, String prop, String rua, float precoPedido, float precoMin, String proposito, float diametroCanal, int kWh, boolean redeEletrica, boolean esgoto, int lote) {
        super(count, prop, rua, precoPedido, precoMin);
        this.proposito = proposito;
        this.diametroCanal = diametroCanal;
        this.kWh = kWh;
        this.redeEletr = redeEletrica;
        this.esgoto = esgoto;
        this.lote = lote;
        this.geraReferencia(count);
    }
    public Terreno(Terreno t) {
        super(t);
        this.proposito = t.getProp();      
        this.diametroCanal = t.getDiam();
        this.kWh = t.getKWH();
        this.redeEletr = t.getRede();
        this.esgoto = t.getEsgoto();
        this.lote = t.lote;
        this.setReferencia(t.getId());
    }
    
    /**
     * Métodos de instância da classe Terreno
     */
    public String getProp() {
        return this.proposito;
    }
    public float getDiam() {
        return this.diametroCanal;
    }
    public int getKWH() {
        return this.kWh;
    }
    public boolean getRede() {
        return this.redeEletr;
    }
    public boolean getEsgoto() {
        return this.esgoto;
    }
    public int getLote() {
        return this.lote;
    }
    
    public void setProp(String s) {
        this.proposito = s;
    }
    public void setDiam(float d) {
        this.diametroCanal = d;
    }
    public void setKWH(int kwh) {
        this.kWh = kwh;
    }
    public void setRede(boolean r) {
        this.redeEletr = r;
    }
    public void setEsgoto(boolean e) {
        this.esgoto = e;
    }
    
    public Terreno clone() {
        return new Terreno(this);
    }
    
    public boolean equals(Object obj) {
        boolean result = super.equals(obj);
        if (result == false) return false;
        Terreno t = (Terreno)obj;
        return (this.proposito.equals(t.proposito) && this.diametroCanal == t.diametroCanal &&
                this.kWh == t.kWh && this.redeEletr == t.redeEletr && 
                this.esgoto == t.esgoto);
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\t\tTERRENO\n");
        s.append("Referência: "                 + this.getId() + "\n");
        s.append("Estado: "                     + this.getEstado() + "\n");
        s.append("Rua: "                        + this.getRua() + "\n");
        s.append("Preço pedido: "               + this.getPrecoPedido() + "\n");
        s.append("Propósito da construção: "    + this.proposito + "\n");
        s.append("Diâmetro do canal: "          + this.diametroCanal + "\n");
        s.append("Valor de kWh máximo: "        + this.kWh + "\n");
        if (this.getRede() == true) s.append("Rede elétrica: Sim\n");
        else s.append("Rede elétrica: Não\n");
        if (this.getEsgoto() == true) s.append("Acesso à rede de esgotos: Sim\n");
        else s.append("Acesso à rede de esgotos: Não\n");
        return s.toString();
    }
}
