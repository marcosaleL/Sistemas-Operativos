package Filosofos;

import java.util.concurrent.Semaphore;

public class Mesa {

	private Semaphore cubiertos[]; //Es un arreglo de semaforos, aca estan los cubiertos
	private int lugares;

	public Mesa(int n) {
		lugares = n;
		cubiertos = new Semaphore[lugares]; 
		for (int p = 0; p < cubiertos.length; p++) {
			cubiertos[p] = new Semaphore(1); //Cada cubierto puede ser accedido por un filosofo
		}
	}

	public void comer(Filosofo filosofo) {
		
		//creo variales de los cubierto que tiene disponible un filosofo para mejor comprension
		Semaphore cubiertoIzq = cubiertos[filosofo.getLugar()]; 
		Semaphore cubiertoDer = cubiertos[(filosofo.getLugar() + 1) % lugares]; 

		boolean t1 = cubiertoIzq.tryAcquire(); //Obtengo si esta disponible el cubierto izquierdo
		boolean t2 = cubiertoDer.tryAcquire(); //Obtengo si esta disponible el cubierto derecho

		if (t1 && t2) {
			//Si estan disponibles ocupo los cubiertos
			try {
				System.out.println("Filosofo " + filosofo.getLugar() + " esta comiendo.");
				Thread.sleep(3000);
				System.out.println("Filosofo " + filosofo.getLugar() + " termina de comer.");
			} catch (InterruptedException ex) {
			}
			//Una vez que los uso, los dejo libres
			cubiertoIzq.release();
			cubiertoDer.release();
		} else if (t1) {
			//Si no tengo los dos cubiertos dejo el izquierdo libre
			cubiertoIzq.release();

		} else if (t2) {
			//Si no tengo los dos cubiertos dejo el derecho libre
			cubiertoDer.release();
		}

	}
}