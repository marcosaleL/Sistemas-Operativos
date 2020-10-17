package miBarberia;

public class Main {

	public static void main(String[] args) {
		//Creo la barberia
		Barberia barberia = new Barberia("Tijeras y navajas",5);
		//Creo al barbero como hilo
		Thread barbero = new Thread(new Barbero("Abel", barberia));
		//Pongo a trabajar al barbero
		barbero.start();
		
		//Creo a los clientes como hilo
		Thread maxi = new Thread(new Cliente("Maximiliano",barberia));
		Thread ale = new Thread(new Cliente("Alejandro",barberia));
		Thread pancho = new Thread(new Cliente("Pancho",barberia));
		Thread fulano = new Thread(new Cliente("Fulano",barberia));
		Thread mengano = new Thread(new Cliente("Mengano",barberia));
		Thread juan = new Thread(new Cliente("Juan",barberia));
		Thread pedro = new Thread(new Cliente("Pedro",barberia));
		Thread matias = new Thread(new Cliente("Matias",barberia));
		Thread joaquin = new Thread(new Cliente("Joaquin",barberia));
		Thread marcos = new Thread(new Cliente("Marcos",barberia));
		
		//Hago que los clientes vayan llegando a la barberia
		maxi.start();
		ale.start();
		pancho.start();
		fulano.start();
		mengano.start();
		juan.start();
		pedro.start();
		matias.start();
		joaquin.start();
		marcos.start();
	}

}
