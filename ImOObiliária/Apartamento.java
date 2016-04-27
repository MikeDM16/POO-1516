
/**
 * Escreva a descrição da classe Apartamento aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

import java.lang.String;

public class Apartamento extends Imoveis {
    // variáveis de instância
    private int numPorta,andar,quartos, wc, tipo;
    private boolean garagem;
    private double area;
    
    /**
     * COnstrutor para objetos da classe Apartamento
     */
    public Apartamento(){
        this(0,0,0,0,false,0, 0.0);
    }
    
    public Apartamento(int porta, int andar, int quartos, int wc , boolean garagem, int tipo, double area){
        this.numPorta= porta;
        this.andar = andar;
        this.quartos= quartos;
        this.wc= wc;
        this.garagem= garagem;
        this.tipo=tipo;
        this.area=area;
    }
    
    public Apartamento (Apartamento a){
        this (a.getNumero(), a.getAndar(), a.getQuartos(), a.getWC (), a.getGaragem(), a.getTipo(), a.getArea());
    }

    //Metodos de Instancia
    
    public int getNumero(){
        return this.numPorta;
    }
      
    public int getAndar(){
        return this.andar;
    }
    
    public int getQuartos(){
        return this.quartos;
    }
    
    public int getWC(){
        return this.wc;
    }
    
    public boolean getGaragem(){
        return this.garagem;
    }
    
    public int getTipo(){
        return this.tipo;
    }
    
    public double getArea(){
        return this.area;
    }
    
    //SETS 
    
    public void setNumero(int n){
        this.numPorta=n;
    }
      
    public void setAndar(int a){
        this.andar=a;
    }
    
    public void setQuartos(int q){
        this.quartos=q;
    }
   
    public void setWC(int wc){
        this.wc =wc;
    }
    
    public void setGaragem( boolean g){
        this.garagem=g;
    }
    
    public void setTipo(int t){
        this.tipo=t;
    }
    
    public void setArea(double a){
        this.area=a;
    }
    
    /**
     * Exemplo de método - substitua este comentário pelo seu próprio
     * 
     * @param  y   exemplo de um parâmetro de método
     * @return     a soma de x com y 
     */
    
    
    public Apartamento clone(Apartamento a){
        return (new Apartamento(a.getNumero(),a.getAndar(),a.getQuartos(), a.getWC(), a.getGaragem(), a.getTipo(),a.getArea()));
    }
    
    public boolean equals (Apartamento a){
        return (this.getNumero()==a.getNumero() && this.getAndar()==a.getAndar() && this.getQuartos()==a.getQuartos() && this.getWC()==a.getWC()
                && this.getTipo()==a.getTipo() && this.getArea()==a.getArea());    
    }
    
    public String toString (){
        StringBuilder s = new StringBuilder();
        s.append ("Tipo: " + this.tipo+ "\n");
        s.append ("Area total :" +this.area+"\n" );
        s.append ("Numero de Quartos :" +this.quartos+"\n" );
        s.append ("Numero de WCs :" +this.wc+"\n" );
        s.append ("Numero de porta e Andar: " +this.area+" "+this.andar+" \n" );
        if (this.garagem == true) s.append ("Garagem: Sim.\n");
        else s.append ("Garagem: Não.\n");
        return s.toString();
    }
}
