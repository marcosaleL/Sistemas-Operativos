package Prefinal2014;

import java.util.Random;

public class Cliente implements Runnable{

	private Archivo archivo;
	private int id;
	
	public Cliente(int id,int hojas) {
		this.id = id;
		this.archivo = new Archivo(hojas);
	}
	
	public int getId() {
		return this.id;
	}
	
	public void run() {
		
	}
}
