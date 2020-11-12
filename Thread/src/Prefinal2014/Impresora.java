package Prefinal2014;

import java.util.ArrayList;

public class Impresora {

	private ArrayList<Archivo> archivos;
	
	public Impresora() {
		this.archivos = new ArrayList<Archivo>();
	}
	
	public synchronized void addArchivo(Archivo a) {
		this.archivos.add(a);
	}
	
}
