import java.lang.String;

public class Moradia extends Imovel {
    // variáveis de instância
    private String tipo;
    private double areaImplantacao, areaTotal, areaTerrEnvol;
    private int nQuartos, nWC, nPorta;

    /**
     * Construtores para objetos da classe Moradia
     */
    public Moradia() {
        super();
        this.tipo = "n/a";
        this.areaImplantacao = 0.0;
        this.areaTotal = 0.0;
        this.areaTerrEnvol = 0.0;
        this.nQuartos = 0;
        this.nWC = 0;
        this.nPorta = 0;
        this.setReferencia("n/a");
    }
    public Moradia(String rua, float precoPedido, float precoMin, String tipo, double ai, double at, double ate, int nq, int nwc, int np){
        super(rua, precoPedido, precoMin);
        this.tipo = tipo;
        this.areaImplantacao = ai;
        this.areaTotal = at;
        this.areaTerrEnvol = ate;
        this.nQuartos = nq;
        this.nWC = nwc;
        this.nPorta = np;
        this.geraReferencia(Imoobiliaria.getCount());
    }
    public Moradia(Moradia m) {
        super(m);
        this.tipo = m.tipo;
        this.areaImplantacao = m.areaImplantacao;
        this.areaTotal = m.areaTotal;
        this.areaTerrEnvol = m.areaTerrEnvol;
        this.nQuartos = m.nQuartos;
        this.nWC = m.nWC;
        this.nPorta = m.nPorta;
        this.setReferencia(m.getReferencia());
    }
    
    /**
     * Métodos de instância da classe Moradia
     */
    public String getTipo () {
        return this.tipo;
    }
    public double getAreaImp() {
        return this.areaImplantacao;
    }
    public double getAreaT() {
        return this.areaTotal;
    }
    public double getAreaTI() {
        return this.areaTerrEnvol;
    }
    public int getNQuartos() {
        return this.nQuartos;
    }
    public int getNWC() {
        return this.nWC;
    }
    public int getNPorta() {
        return this.nPorta;
    }
    
    public void setTipo(String t) {
        this.tipo = t;
    }
    public void setAreaImp(double ai) {
        this.areaImplantacao = ai;
    }
    public void setAreaT(double at) {
        this.areaTotal = at;
    }
    public void setAreaTI(double ati) {
       this.areaTerrEnvol = ati;
    }
    public void setNQuartos(int nq) {
        this.nQuartos = nq;
    }
    public void setNWC(int nwc) {
        this.nWC = nwc;
    }
    public void setNPorta(int np) {
        this.nPorta = np;
    }
    
    public Moradia clone() {
        return new Moradia(this);
    }
    
    public boolean equals(Object obj){
        boolean result = super.equals(obj);
        if (result == false) return false;
        Moradia m = (Moradia)obj;
        return (this.tipo.equals(m.tipo) && this.areaImplantacao == m.areaImplantacao &&
                this.areaTotal == m.areaTotal && this.areaTerrEnvol == m.areaTerrEnvol &&
                this.nQuartos == m.nQuartos && this.nWC == m.nWC &&
                this.nPorta == m.nPorta);
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Referência: "                 + this.getReferencia() + "\n");
        s.append("Estado: "                     + this.getEstado() + "\n");
        s.append("Rua: "                        + this.getRua() + "\n");
        s.append("Preço pedido: "               + this.getPrecoPedido() + "\n");
        s.append("Tipo: "                       + this.tipo + "\n");
        s.append("Area de implantação: "        + this.areaImplantacao + " m^2\n");
        s.append("Área total coberta "          + this.areaTotal + " m^2\n");
        s.append("Área do terreno envolvente "  + this.areaTerrEnvol + " m^2\n");
        s.append("Número de quartos: "          + this.nQuartos + "\n");
        s.append("Número de WC's: "             + this.nWC + "\n");
        s.append("Número de porta: "            + this.nPorta + "\n");
        return s.toString();
    }
}
