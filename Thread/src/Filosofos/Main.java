package Filosofos;

public class Main {

	public static void main(String[] args) {
		int cant = 5;
		
		//Creo la mesa donde van a comer
		Mesa mesa = new Mesa(cant);
		
		//Creo un arreglo de hilos donde estan los filosofos
		Thread filosofos[] = new Thread[cant];
		
		//A cada hilo lo asocio a un filosofo
		for(int i=0; i<5; i++) {
			filosofos[i] = new Thread(new Filosofo(mesa,i));
		}
		
		//Le doy a start a cada filosofo
		for(int i=0; i<5; i++) {
			filosofos[i].start();
		}

	}
}
