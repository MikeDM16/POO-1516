
/**
 * Write a description of class Loja here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Loja extends Imoveis
{
    //Variaveis da instancia Loja
    private int numWC, numPorta;
    private double area;
    private String rua, tipoNeg;
    
    private boolean parteHabitacional;
    private Apartamento p;
    
    //construtores da instancia Loja
    public Loja(){
        this(0, 0, 0.0, null, false, new Apartamento() ); 
    }
    public Loja(int numWC, int numPorta, double area, String tipoNeg, boolean i, Apartamento p){
        this.numWC = numWC; this.numPorta = numPorta; this.tipoNeg = tipoNeg;
        this.parteHabitacional = i; this.p = p;
    }
    public Loja(Loja l){ 
        this(l.getNumWC(), l.getNumPorta(), l.getArea(), l.getTNeg(), l.getPartHab(), l.getApart()); //COLONES!!!!!
    }
    
    //mwtodos da instancia Loja
    
    public int getNumWC(){ return this.numWC; }
    public int getNumPorta(){return this.numPorta; }
    public double getArea(){ return this.area; }
    public String getTNeg(){ return this.tipoNeg; }
    public boolean getPartHab(){ return this.parteHabitacional; }
    public Apartamento getApart(){ return this.p; }
    
    public void setNumWC(int n){ this.numWC = n; }
    public void setNumPorta(int n){this.numPorta = n; }
    public void setArea(double a){ this.area = a; }
    public void setTNeg(String s){ this.tipoNeg = s; }
    public void setPartHab(boolean b){ this.parteHabitacional = b ; }
    public void setApart(Apartamento p){ this.p = p; }
   
    public boolean existeWC(){ if(numWC==0){return false;}   return true; }
    public boolean existePartHab(){return this.parteHabitacional; }
    
    public boolean equals(Loja l){
        if(l == null) {return false;}
        if(l == this) {return true;}
        if(l.getClass() != this.getClass()) {return false; }
        return ( (this.numWC==l.getNumWC()) && (this.numPorta==l.getNumPorta()) && (this.area==l.getArea()) && 
        (this.tipoNeg.equals(l.getTNeg())==true) && (this.parteHabitacional==l.getPartHab()) && (p.equals(l)==true) );
        
    }
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Superficie comercial com "+this.area+" m2 de área.\n");
        s.append("Aconselhado para o seguinte tipo de negocio:"+tipoNeg+".\n");
        if(this.numWC!=0){
            s.append("Loja com "+this.numWC+" casas de banho.\n");
        }else{
            s.append("Loja com sem casas de banho construidas.\n");
        }
        if(this.parteHabitacional==false){
            s.append("Loja sem parte habitacional.\n");
        }else{
            s.append("Loja com parte Habitacional, com as seguintes caracteristicas:\n");
            s.append( this.p.toString() );
        }
       
        return s.toString();
    }
}
