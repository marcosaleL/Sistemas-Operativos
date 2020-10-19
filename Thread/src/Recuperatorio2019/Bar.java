package Recuperatorio2019;

import java.util.ArrayList;

public class Bar {

	private int cantBartender;
	private ArrayList<String> bebidas;
	private int clienteEsperando;
	
	public Bar() {
		//el enunciado dice que hay tres bartender
		this.cantBartender = 3;
		this.clienteEsperando = 0;
		this.bebidas = new ArrayList<String>();
		this.bebidas.add("Cerveza");
		this.bebidas.add("Whisky");
		this.bebidas.add("Fernet");
		this.bebidas.add("Vodka");
		this.bebidas.add("Coca cola");
		this.bebidas.add("Jugo de naranja");
	}
	
	
	
	
}
