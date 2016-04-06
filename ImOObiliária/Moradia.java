/**
 * Write a description of class Moradia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Moradia
{
    // instance variables - replace the example below with your own
    private int tipo;
    private double areaImplantacao;
    private double areaTotal;
    private double areaTerrInvol;
    private int nQuartos;
    private int nWC;
    private int nPorta;

    /**
     * Constructor for objects of class Moradia
     */
    public Moradia(){
     this(0,0.0,0.0,0.0,0,0,0);
    }
    public Moradia(int t, double ai, double at, double ati, int nq, int nwc, int np){
    tipo=t; areaImplantacao=ai; areaTotal=at; areaTerrInvol=ati; nQuartos=nq; nWC=nwc; nPorta=np;
    }
    public Moradia(Moradia moradia){
    tipo=moradia.getTipo();
    areaImplantacao=moradia.getAreaImp();
    areaTotal=moradia.getAreaT();
    areaTerrInvol=moradia.getAreaTI();
    nQuartos=moradia.getNQuartos();
    nWC=moradia.getNWC();
    nPorta=moradia.getNPorta();
    }
    
    //Métodos de instância
    
    public int getTipo(){
        return tipo;
    }
    public double getAreaImp(){
        return areaImplantacao;
    }
    public double getAreaT(){
        return areaTotal;
    }
    public double getAreaTI(){
        return areaTerrInvol;
    }
    public int getNQuartos(){
        return nQuartos;
    }
    public int getNWC(){
        return nWC;
    }
    public int getNPorta(){
        return nPorta;
    }
    
    
    public void setTipo(int t){
        tipo=t;
    }
    public void setAreaImp(double ai){
        areaImplantacao=ai;
    }
    public void setAreaT(double at){
        areaTotal=at;
    }
    public void setAreaTI(double ati){
       areaTerrInvol=ati;
    }
    public void setNQuartos(int nq){
    nQuartos=nq;
    }
    public void setNWC(int nwc){
    nWC=nwc;
    }
    public void setNPorta(int np){
    nPorta=np;
    }
    
    
    
    public Moradia clone(){
    return new Moradia(this.getTipo(), this.getAreaImp(), this.getAreaT(), this.getAreaTI(), this.getNQuartos(), this.getNWC(), this.getNPorta());
    }
    
    public String toString(){
    StringBuilder s = new StringBuilder();
    s.append("O tipo da moradia é o: "+this.tipo+".\n");
    s.append("A sua área de implantação é "+this.areaImplantacao+" m2.\n");
    s.append("Tem de área total coberta "+this.areaTotal+" m2.\n");
    s.append("O terreno envolvente tem "+this.areaTerrInvol+" m2.\n");
    s.append("Tem "+this.nQuartos+" quartos. \n");
    s.append("Tem "+this.nWC+" WC's. \n");
    s.append("O seu número de porta é "+this.nPorta+".\n");
    return s.toString();
    }
    
    public boolean equals(Moradia moradia){
    if (moradia!=null)
     return((this.getTipo()==moradia.getTipo()) && (this.getAreaImp()==moradia.getAreaImp()) && (this.getAreaT()==moradia.getAreaT()) && 
     (this.getAreaTI()==moradia.getAreaTI()) && (this.getNQuartos()==moradia.getNQuartos()) && (this.getNWC()==moradia.getNWC()) && (this.getNPorta()==moradia.getNPorta()));
    return false;
    } 
}
