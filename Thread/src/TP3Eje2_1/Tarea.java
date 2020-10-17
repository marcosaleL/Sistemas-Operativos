package TP3Eje2_1;

public class Tarea implements Runnable{

	private int n;
	
	public Tarea(int n) {
		this.n = n;
	}
	
	@Override
	public void run() {
		int idThread = (int) Thread.currentThread().getId();
		for(int i=1; i<=this.n; i++) {
			System.out.println("Buenas, soy el Thread " + idThread + " ejecutando por " + i + " vez.");
		}
		
		
	}
	
	

}
