package Recuperatorio2019;

public class Main {

	public static void main(String[] args) {
		Bar bar = new Bar();

		// Creo los bartenders en un arreglo
		Thread bartenders[] = new Thread[3];
		
		// Creo los clientes en un arreglo
		Thread clientes[] = new Thread[10];
		
		//Inicializo los bartenders como hilo
		for (int i = 0; i < bartenders.length; i++) {
			bartenders[i] = new Thread(new Bartender(bar, i));
		}

		//Inicializo los clientes como hilo
		for (int i = 0; i < clientes.length; i++) {
			clientes[i] = new Thread(new Cliente(bar, i));
		}
		

		//Start a los clientes
		for (int i = 0; i < clientes.length; i++) {
			clientes[i].start();
		}

		//Start a los bartendes
		for (int i = 0; i < bartenders.length; i++) {
			bartenders[i].start();
		}

	}

}
