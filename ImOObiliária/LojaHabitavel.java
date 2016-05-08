public class LojaHabitavel extends Loja {
    // Variaveis da instancia
    private Apartamento p;
    
    /**
     * Construtores para objetos da classe LojaHabitavel
     */
    public LojaHabitavel() {
        super();
        this.setReferencia("n/a");
    }
    public LojaHabitavel(String rua, float precoPedido, float precoMin, boolean wc, int numPorta, double area, String tipoNegocio, Apartamento p) {
        super(rua, precoPedido, precoMin, wc, numPorta, area, tipoNegocio);
        this.p = p;
        this.geraReferencia(Imoobiliaria.getCount());
    }
    public LojaHabitavel(LojaHabitavel l){ 
        super(l);
        this.p = l.p;
        this.setReferencia(l.getReferencia());
    }
    
    /**
     * Métodos de instância da classe LojaHabitavel
     */
    public Apartamento getApart() {
        return this.p;
    }
    
    public void setApart(Apartamento p) {
        this.p = p;
    }
    
    public LojaHabitavel clone() {
        return new LojaHabitavel(this);
    }
    
    public boolean equals(Object obj) {
        boolean result = super.equals(obj);
        if (result == false) return false;
        LojaHabitavel l = (LojaHabitavel)obj;
        return (this.p.equals(l.p));
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder("Parte habitável da Loja:\n");
        s.append(this.p.toString());
        return s.toString();
    }
}
