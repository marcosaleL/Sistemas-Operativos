package Parcial2020;

import java.util.ArrayList;

public class Museo {

	private ArrayList<Auto> autosRotos;
	private ArrayList<Visitante> visitantes;
	private Tecnico tecnico;

	public Museo() {
		this.tecnico = null;
		this.autosRotos = new ArrayList<Auto>();
		this.visitantes = new ArrayList<Visitante>();
	}
	
	public void setTecnico(Tecnico t) {
		this.tecnico = t;
	}
	
	//Sincronizo como entran los visitantes
	public synchronized void entraVisitante(Visitante v) {
		this.visitantes.add(v);
		System.out.println("El visitante " + v.getId() + " esta en la cola esperando por un auto.");
		this.notifyAll(); //Notifico por si hay algún auto esperando
	}
	
	//Sincronizo que los autos cargen a los visitantes
	public synchronized ArrayList<Visitante> getGrupo(Auto a){
		while(this.visitantes.size()<4) {
			try {
				this.wait(); //Si hay menos de cuatro visitantes, el auto espera
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ArrayList<Visitante> grupo = new ArrayList<Visitante>();
		for(int i=0; i<4;i++) {
			System.out.println("El visitante " + this.visitantes.get(0).getId() + " esta subiendo al auto " + a.getId() + ".");
			grupo.add(this.visitantes.remove(0));
		}
		return grupo; //Suben 4 visitantes al auto
	}
	
	public synchronized void autoRoto(Auto a) {
		this.autosRotos.add(a);
		System.out.println("El auto " + a.getId() + " esta en la fila para ser reparado.");
		this.notifyAll(); //Notifico al mecanico que hay un auto roto
	}

	public synchronized Auto getAutoRoto() {
		while(this.autosRotos.isEmpty())
			try {
				this.wait(); //Como no hay autos el tecnico descansa
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println("El auto " + this.autosRotos.get(0).getId() + " va a ser reparado.");
		return this.autosRotos.remove(0);
	}

}
