package Parcial2020Lucas;

public class Tecnico implements Runnable{

	private Museo museo;
	
	public Tecnico (Museo museo) {
		this.museo = museo;
	}
	
	@Override
	public void run() {
		while (true) {
			Coche roto = museo.getCocheRoto(); //pide a museo un choche roto
			try {
				Thread.sleep((long) (2000 * Math.random() + 100)); //simula que arregla el coche
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			System.out.println("El tecnico arreglo un coche");
			roto.arreglado(); //le avisa al choche que puede seguir andando
		}
	}

}
