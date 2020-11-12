package Parcial2020;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Museo museo = new Museo();
        Tecnico t = new Tecnico(museo);
        
        museo.setTecnico(t);
        
        Thread tecnico = new Thread(t);
        tecnico.start();
        
        Thread visitantes[] = new Thread[20];
        
        //Creo los hilos de los visitantes
        for(int i=0; i<visitantes.length; i++) {
        	visitantes[i] = new Thread(new Visitante(museo,i));
        }
        
        Thread autos[] = new Thread[5];
        
        //Creo los hilos de los autos
        for(int i=0; i<autos.length; i++) {
        	autos[i] = new Thread(new Auto(museo,i));
        }
        
        //Inicializo los hilos
        for(int i=0; i<visitantes.length; i++) {
        	visitantes[i].start();
        	if(i<autos.length) {
        		autos[i].start();
        	}
        }
    }
}
