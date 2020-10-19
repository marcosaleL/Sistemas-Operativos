package Recuperatorio2019;

import java.util.ArrayList;

public class Bar {

	private ArrayList<String> bebidas;
	private ArrayList<Cliente> clientes;
	
	public Bar() {
		//Desde 0 hasta 5
		this.bebidas = new ArrayList<String>();
		this.bebidas.add("Cerveza");
		this.bebidas.add("Whisky");
		this.bebidas.add("Fernet");
		this.bebidas.add("Vodka");
		this.bebidas.add("Coca cola");
		this.bebidas.add("Jugo de naranja");
		
		this.clientes = new ArrayList<Cliente>();
	}
	
	//Sincronizo la entrada de clientes así van entrando de a uno
	public synchronized void entraCliente(Cliente c) {
		this.clientes.add(c);
		this.notify();
	}
	
	//Sincronizo a los bartenders para que no se peleen si dos quieren el siguiente cliente
	public synchronized Cliente siguienteCliente() {
		while(this.clientes.isEmpty())
			try {
				this.wait(); //en caso de que no haya clientes se duerme el bartender
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return this.clientes.remove(0);
	}
	
	public ArrayList<String> getBebidas(){
		return this.bebidas;
	}
	
}
