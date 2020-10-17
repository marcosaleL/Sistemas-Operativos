package miBarberia;

import java.util.ArrayList;

public class Barberia {
	
	private ArrayList<Cliente> espacio;
	private String nombre;
	private int maximaCapacidad;
	
	public Barberia(String nombre, int n) {
		this.espacio = new ArrayList<Cliente>();
		this.maximaCapacidad = n;
		this.nombre = nombre;
	}
	
	public boolean sentarse(Cliente cliente) {
		synchronized(this.espacio) {
			if (this.espacio.size() == this.maximaCapacidad) {
				return false;
			}
			System.out.println(cliente.getNombre() + " se pudo sentar.");
			this.espacio.add(cliente);
			this.espacio.notify();
			return true;
		}
	}

	public Cliente getSiguiente(){
		synchronized (this.espacio) {
			while(this.espacio.isEmpty()) {
				try {
					this.espacio.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println(this.espacio.get(0).getNombre() + " se levanto para cortarse el pelo");
		return this.espacio.remove(0);
	}

}
