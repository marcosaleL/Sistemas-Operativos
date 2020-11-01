package Parcial2020Lucas;

public class Visitante implements Runnable {

	private Museo museo;
	private boolean paseo;
	private int id; // le puse un id solo para poder visualizar como funciona

	public Visitante(Museo museo, int id) {
		this.museo = museo;
		this.paseo = false;
		this.id = id;
	}

	@Override
	public void run() {
		this.museo.pasear(this); // entra a el museo a hacer la cola
		esperar();
		System.out.println("Termino el paseo y se fue el visitante: " + this.id);
	}

	public int getId() {
		return this.id; // esta solo para poder visualizar como funciona y en que orden
	}

	public synchronized void esperar() {
		while (!paseo) { // mientras que no haya terminado el paseo se queda esperando
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void notificarPaseo() {
		this.paseo = true; // una vez terminado el paseo notifica que se puede ir
		this.notify();
	}
}
