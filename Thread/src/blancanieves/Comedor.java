package blancanieves;

import java.util.ArrayList;

public class Comedor {

	private int sillasDisponibles;
	private int enanoSinComida;

	public Comedor() {
		this.sillasDisponibles = 4;
		this.enanoSinComida = 0;
	}

	public synchronized void sentarse(Enanito e) throws InterruptedException {

		while (sillasDisponibles < 1) {
			System.out.println("Enano: " + e.getId() + " espera lugar en la mesa");
			this.wait();
		}
		System.out.println("Enano: " + e.getId() + " se sienta a la mesa");
		enanoSinComida++;
		sillasDisponibles--;
		this.notifyAll();
	}

	public synchronized void EsperarComida(Enanito e) throws InterruptedException {
		while (enanoSinComida > 0) {
			System.out.println("Enano: " + e.getId() + " espera un plato para comer");
			this.wait();
		}
	}

	public void comiendo(Enanito e) {
		System.out.println("El enano: " + e.getId() + " esta comiendo");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException ex) {
		
		}
	}

	public synchronized void terminarDeComer(Enanito e) {
		System.out.println("El enano: " + e.getId() + " termina de comer");
		sillasDisponibles++;
		this.notifyAll();
	}

	public synchronized void servirComida() throws InterruptedException {
		while (enanoSinComida < 1) {
			this.wait();
		}
		System.out.println("Blanca Nieves sirve comida a los enanos");
		enanoSinComida--;
		this.notifyAll();
	}

	public void pasear() throws InterruptedException {
		System.out.println("Blanca nieves esta caminando con el principe");
		Thread.sleep(2000);
	}

	public void trabajando(Enanito e) {
		System.out.println("El enano: " + e.getId() + " esta trabajando");
	}

}
