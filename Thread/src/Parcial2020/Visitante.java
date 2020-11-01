package Parcial2020;

import java.util.ArrayList;

public class Visitante implements Runnable {

	private Museo museo;
	private int id;
	private boolean bajar;

	public Visitante(Museo museo, int id) {
		this.museo = museo;
		this.id = id;
		this.bajar = false;
	}

	public int getId() {
		return this.id;
	}

	public synchronized void setBajar() {
		this.bajar = true;
		this.notify(); //Es notificado de que se tiene que bajar del auto
	}
	
	public void simulaPaseo() {
		try {
			Thread.sleep(2000); //Simula paseo
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		this.museo.entraVisitante(this);
		simulaPaseo();
		synchronized(this) {
			while(!bajar) {
				try {
					this.wait(); //Se queda esperando hasta que le digan que se tiene que bajar
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("El visitante " + this.id + " se retira del museo.");
	}

}
