package edu.eci.cvds.game;

import java.util.ArrayList;
import java.util.Random;

//import javax.faces.bean.ApplicationScoped; 
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
import javax.faces.bean.*;

@ManagedBean(name = "guessBeans")
//@ApplicationScoped
@SessionScoped
public class Adivinador{
    private int numero;
    private int intentosRealizados;
    private int premio;
    private String estado;
    private ArrayList<Integer> historial;
	
    public Adivinador(){
        historial = new ArrayList<Integer>();
        Random rand = new Random();
        numero = rand.nextInt(10)+1;
	intentosRealizados = 0;
	estado = "No gano";
	premio = 0;
    }

    public int getIntentosRealizados(){
        return intentosRealizados;
    }
    
    public void guess(int x){
        intentosRealizados++;
        if (numero != x){
            premio-=10000;
        }else{
            if (intentosRealizados==1){
                premio+=100000;
            }
            estado = this.getGano();
        }
        historial.add(x);
    }
	
    public String getGano() {
        return "Gano, el premio es de "+ premio;
    }
    
    public void restart(){
        historial = new ArrayList<Integer>();
	Random rand = new Random();
        numero = rand.nextInt(10)+1;
	intentosRealizados=0;
	estado = "No gano";
	premio = 0;
    }
    
    public int getPremio(){
        return premio;
    }
	
    public String getEstado(){
        return estado;
    }
    
    public int getNumero(){
        return numero;
    }

    public void setNumero(int num){
        numero=num;
    }

    public ArrayList<Integer> getHistorial(){
        return historial;
    }
}
