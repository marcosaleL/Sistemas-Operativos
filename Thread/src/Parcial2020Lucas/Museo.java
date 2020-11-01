package Parcial2020Lucas;

import java.util.ArrayList;

public class Museo {

	private ArrayList<Visitante> cola;
	private ArrayList <Coche> cochesRotos;
	
	public Museo() {
		this.cola = new ArrayList<Visitante>();
		this.cochesRotos = new ArrayList<Coche>();
	}

	public synchronized void pasear(Visitante visitante) {
		this.cola.add(visitante); //se pone en la fila y avisa que llego por si hay algun choche esperando
		System.out.println("El visitante: "+visitante.getId()+" se puso en la cola");
		this.notifyAll();
	}
	
	public synchronized ArrayList<Visitante> getVisitantes() {
		ArrayList<Visitante> visitantes = new ArrayList<Visitante>();
		while (this.cola.size()<4) { //intenta tomar de a 4 visitantes en el caso de no poder espera
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		visitantes.add(this.cola.remove(0)); //toma los 4 visitantes tomando en orden siempre el primero que llego
		visitantes.add(this.cola.remove(0));
		visitantes.add(this.cola.remove(0));
		visitantes.add(this.cola.remove(0));
		return visitantes;
	}
	
	public synchronized Coche getCocheRoto () {
		while (this.cochesRotos.isEmpty()) { //pregunta si hay coches para arrelgar, si no lo hay se queda esperando
			try {
				this.wait(); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return this.cochesRotos.remove(0); //si hay algun coche para arreglar lo toma
	}
	
	public synchronized void seRompio(Coche coche) {
		this.cochesRotos.add(coche); //el coche avisa que se rompio y espera a ser antedido
		this.notifyAll();
	}
}
