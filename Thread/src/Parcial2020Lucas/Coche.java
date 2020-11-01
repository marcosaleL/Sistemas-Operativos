package Parcial2020Lucas;

import java.util.ArrayList;

public class Coche implements Runnable{

	private Museo museo;
	private ArrayList <Visitante> visitantes;	
	private boolean funciona;
	
	public Coche (Museo museo) {
		this.museo = museo;
		this.funciona=true;
		this.visitantes = new ArrayList<Visitante>();
	}
	
	@Override
	public void run() {
		while (true) {
			visitantes.addAll(museo.getVisitantes()); //toma los 4 visitantes que esten esperando
			System.out.println("Los visitantes estan dando una vuelta");
			try {
				Thread.sleep((long) (2000 * Math.random() + 100)); //simulo la vuelta
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			double probabilidad =  Math.random() * 100; 
			if (probabilidad<80) { //en el caso de que se cumpla esta probabilidad va a entrar en estado de arreglo
				this.funciona=false;
				System.out.println("Se rompio un coche");
				museo.seRompio(this);
				esperarArreglo();
			}
			try {
				Thread.sleep((long) (2000 * Math.random() + 100)); //simulo que sigue la vuelta
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int i=0; i<visitantes.size(); i++) {
				this.visitantes.get(i).notificarPaseo(); //le notifica a los visitantes que termino el paseo y se pueden ir
			}
		}
	}
	
	public synchronized void esperarArreglo() {
		while(!(this.funciona)) { //mientras que no este arreglado tiene que esperar
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void arreglado () {
		this.funciona=true; //una vez arreglado se le notifica el arreglo para que continue la vuelta
		this.notify();
	}

}
