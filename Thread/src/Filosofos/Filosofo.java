package Filosofos;

public class Filosofo implements Runnable {

	private Mesa miMesa;
	private int lugar;

	public Filosofo(Mesa m, int n) {
		miMesa = m;
		lugar = n;
	}

	public int getLugar() {
		return this.lugar;
	}

	//Funcion para simular que el filosofo esta pensando
	public void pensar() {
		try {
			System.out.println("Filosofo " + this.lugar + " estoy pensando");
			Thread.sleep(3000);
		} catch (InterruptedException ex) {
		}
	}

	public void run() {
		while (true) {
			miMesa.comer(this);
			pensar();
		}
	}
}