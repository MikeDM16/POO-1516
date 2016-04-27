public class Loja extends Imoveis {
    // Variaveis da instancia
    private int numPorta;
    private double area;
    private String tipoNeg;
    private boolean wc, parteHabitacional;
    private Apartamento p;
    
    /**
     * Construtores para objetos da classe Loja
     */
    public Loja() {
        super();
        this.numPorta = 0;
        this.area = 0.0;
        this.tipoNeg = "n/a";
        this.wc = false;
        this.parteHabitacional = false;
    }
    public Loja(String rua, float precoPedido, float precoMin, boolean wc, int numPorta, double area, String tipoNegocio, boolean parteHabitacional, Apartamento p){
        super(rua, precoPedido, precoMin);
        this.wc = wc;
        this.numPorta = numPorta;
        this.tipoNeg = tipoNegocio;
        this.parteHabitacional = parteHabitacional;
        this.p = p;
    }
    public Loja(Loja l){ 
        super(l);
        this.wc = l.wc;
        this.numPorta = l.numPorta;
        this.tipoNeg = l.tipoNeg;
        this.parteHabitacional = l.parteHabitacional;
        this.p = l.p;
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
    public boolean getPartHab() {
        return this.parteHabitacional;
    }
    public Apartamento getApart() {
        return this.p;
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
    public void setPartHab(boolean b) {
        this.parteHabitacional = b ;
    }
    public void setApart(Apartamento p) {
        this.p = p;
    }
    
    public Loja clone() {
        return new Loja(this);
    }
    
    public boolean equals(Object obj) {
        boolean result = super.equals(obj);
        if (result == false) return false;
        Loja l = (Loja)obj;
        return (this.numPorta == l.numPorta && this.area == l.area &&
                this.tipoNeg.equals(l.tipoNeg) && this.wc == l.wc &&
                this.parteHabitacional == l.parteHabitacional &&
                this.p.equals(l.p));
        
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Área : "              + this.area + " m^2\n");
        s.append("Tipo de negócio: "    + this.tipoNeg + "\n");
        s.append("Número de porta: "    + this.numPorta + "\n");
        s.append("Tipo de negócio: "+ this.tipoNeg + "\n");
        if (this.wc == true) s.append ("WC: Sim\n");
        else s.append ("WC: Não\n");
        if (this.parteHabitacional == true) s.append ("Parte Habitacional: Sim\n");
        else s.append ("Parte Habitacional: Não\n");
        return s.toString();
    }
}
