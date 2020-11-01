package Parcial2020;

import java.util.ArrayList;

public class Auto implements Runnable {

	private boolean averiado;
	private Museo museo;
	private ArrayList<Visitante> visitantes;
	private int id;

	public Auto(Museo museo, int id) {
		this.averiado = false;
		this.id = id;
		this.museo = museo;
		this.visitantes = new ArrayList<Visitante>();
	}

	public int getId() {
		return this.id;
	}
	
	public void simulaPaseo() {
		try {
			Thread.sleep(2000); //Simula paseo
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void setArreglar() {
		this.averiado = false;
		this.notifyAll(); //Notifico al auto que ya esta arreglado
	}
	
	public synchronized void esperarArreglo() {
		while(this.averiado)
			try {
				this.wait(); //Mientras el auto este roto espera a que lo reparen
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void run() {
		while (true) {
			this.visitantes = this.museo.getGrupo(this); //Agarro los visitantes
			System.out.println("El auto " + this.id + " esta paseando.");
			simulaPaseo(); //Simula el paseo
			double probabilidad =  Math.random() * 100; 
			if (probabilidad < 80) { //en el caso de que se cumpla esta probabilidad el auto se ha roto
				this.averiado = true;
				System.out.println("Se rompio el auto " + this.id + ".");
				this.museo.autoRoto(this);
				esperarArreglo();
			}
			for(Visitante v : visitantes) {
				v.setBajar();
			}
			this.visitantes.clear();
		}
	}

}
