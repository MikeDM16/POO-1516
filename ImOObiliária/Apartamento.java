import java.lang.String;

public class Apartamento extends Imovel implements Habitavel {
    // variáveis de instância
    private String tipo, andar;
    private double area;
    private int numPorta, quartos, wc;
    private boolean garagem;
        
    /**
     * Construtores para objetos da classe Apartamento
     */
    public Apartamento() {
        super();
        this.tipo = "n/a";
        this.area = 0.0;
        this.numPorta = 0;
        this.andar = "n/a";
        this.quartos = 0;
        this.wc = 0;
        this.garagem = false;
    }
    public Apartamento(int count, String prop, String rua, float precoPedido, float precoMin, String tipo, double area, int porta, String andar, int quartos, int wc, boolean garagem){
        super(count, prop, rua, precoPedido, precoMin);
        this.tipo = tipo;
        this.area = area;
        this.numPorta = porta;
        this.andar = andar;
        this.quartos = quartos;
        this.wc = wc;
        this.garagem = garagem;
        this.geraReferencia(count);
    }
    public Apartamento (Apartamento a){
        super(a);
        this.tipo = a.tipo;
        this.area = a.area;
        this.numPorta = a.numPorta;
        this.andar = a.andar;
        this.quartos = a.quartos;
        this.wc = a.wc;
        this.garagem = a.garagem;
        this.setReferencia(a.getId());
    }
    
    /**
     * Métodos de instância da classe Apartamento
     */
    public int getNumero() {
        return this.numPorta;
    }
    public String getAndar() {
        return this.andar;
    }
    public int getQuartos() {
        return this.quartos;
    }
    public int getWC() {
        return this.wc;
    }
    public boolean getGaragem() {
        return this.garagem;
    }
    public String getTipo() {
        return this.tipo;
    }
    public double getArea() {
        return this.area;
    }
    
    public void setNumero(int n) {
        this.numPorta = n;
    }
    public void setAndar(String a) {
        this.andar = a;
    }
    public void setQuartos(int q) {
        this.quartos = q;
    }
    public void setWC(int wc) {
        this.wc = wc;
    }
    public void setGaragem( boolean g) {
        this.garagem = g;
    }
    public void setTipo(String t) {
        this.tipo = t;
    }
    public void setArea(double a) {
        this.area = a;
    }
        
    public Apartamento clone() {
        return new Apartamento(this);
    }
    
    public boolean equals (Object obj){
        boolean result = super.equals(obj);
        if (result == false) return false;
        Apartamento a = (Apartamento)obj;
        return (this.tipo.equals(a.tipo) && this.area == a.area &&
                this.numPorta == a.numPorta && this.andar.equals(a.andar) &&
                this.quartos == a.quartos && this.wc == a.wc &&
                this.garagem == a.garagem);
    }
    
    public String toString () {
        StringBuilder s = new StringBuilder();
        s.append("\t\tAPARTAMENTO\n");
        s.append("Referência: "                 + this.getId() + "\n");
        s.append("Estado: "                     + this.getEstado() + "\n");
        s.append("Rua: "                        + this.getRua() + "\n");
        s.append("Preço pedido: "               + this.getPrecoPedido() + "\n");
        s.append ("Tipo: "                      + this.tipo + "\n");
        s.append ("Area total :"                + this.area + "\n" );
        s.append ("Numero de Quartos :"         + this.quartos + "\n" );
        s.append ("Numero de WCs :"             + this.wc + "\n" );
        s.append ("Numero de porta e Andar: "   + this.area + " " + this.andar + " \n" );
        if (this.garagem == true) s.append ("Garagem: Sim\n");
        else s.append ("Garagem: Não\n");
        return s.toString();
    }
}
