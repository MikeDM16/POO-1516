
/**
 * Escreva a descrição da classe Terreno aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Terreno {
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String proposito;
    private float diametroCanal;
    private int kWh;
    private boolean redeEletr, esgoto;

    /**
     * Construtor para objetos da classe Terreno
     */
    public Terreno() {
        this.proposito = "n/a";
        this.diametroCanal = 0;
        this.kWh = 0;
        this.redeEletr = true;
        this.esgoto = true;
    }
    public Terreno(String p, float d, int k, boolean r, boolean e) {
        this.proposito = p;
        this.diametroCanal = d;
        this.kWh = k;
        this.redeEletr = r;
        this.esgoto = e;
    }
    public Terreno(Terreno t) {
        this.proposito = t.getProp();      
        this.diametroCanal = t.getDiam();
        this.kWh = t.getKWH();
        this.redeEletr = t.getRede();
        this.esgoto = t.getEsgoto();
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
    
    public Terreno clone(Terreno t) {
        return (new Terreno(t.proposito, t.diametroCanal, t.kWh, t.redeEletr, this.esgoto));
    }
    public boolean equals(Terreno t) {
        return (this.proposito == t.getProp() && this.diametroCanal == t.getDiam() &&
                this.kWh == t.getKWH() && this.redeEletr == t.getRede() && this.esgoto == t.getEsgoto());
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Tipo de imóvel: Terreno\n");
        s.append("Propósito da construção: ");
        s.append(this.proposito + "\n");
        s.append("Diâmetro do canal: ");
        s.append(this.diametroCanal + "\n");
        s.append("Valor de kWh máximo ");
        s.append(this.kWh + "\n");
        s.append("Tem rede elétrica? ");
        if (this.getRede() == true) s.append("Sim\n");
        else s.append("Não\n");
        s.append("Tem acesso à rede de esgotos? ");
        if (this.getEsgoto() == true) s.append("Sim\n");
        else s.append("Não\n");
        System.out.println(s);
        return s.toString();
    }
}
