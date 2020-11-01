package Parcial2020;

import java.util.ArrayList;

public class Tecnico implements Runnable {

	private Museo museo;

	public Tecnico(Museo museo) {
		this.museo = museo;
	}

	public void simulaArreglarAuto() {
		try {
			Thread.sleep(2000); // Simula que esta reparando el autio
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			Auto autoRoto = this.museo.getAutoRoto();
			simulaArreglarAuto();
			System.out.println("El tecnico arreglo el auto " + autoRoto.getId() + ".");
			autoRoto.setArreglar();
		}
	}

}
