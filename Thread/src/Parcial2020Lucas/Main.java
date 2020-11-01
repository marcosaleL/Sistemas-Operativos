package Parcial2020Lucas;

public class Main {

	public static void main(String[] args) {

		Museo museo = new Museo ();
		Thread tecnico = new Thread (new Tecnico(museo));
		tecnico.start();	
		Thread coche1 = new Thread (new Coche(museo));
		coche1.start();
		Thread coche2 = new Thread (new Coche(museo));
		coche2.start();
		Thread coche3 = new Thread (new Coche(museo));
		coche3.start();
		Thread coche4 = new Thread (new Coche(museo));
		coche4.start();	
		Thread visitante1 = new Thread (new Visitante(museo,1));
		visitante1.start();
		Thread visitante2 = new Thread (new Visitante(museo,2));
		visitante2.start();
		Thread visitante3 = new Thread (new Visitante(museo,3));
		visitante3.start();
		Thread visitante4 = new Thread (new Visitante(museo,4));
		visitante4.start();
		Thread visitante5 = new Thread (new Visitante(museo,5));
		visitante5.start();
		Thread visitante6 = new Thread (new Visitante(museo,6));
		visitante6.start();
		Thread visitante7 = new Thread (new Visitante(museo,7));
		visitante7.start();
		Thread visitante8 = new Thread (new Visitante(museo,8));
		visitante8.start();
	}

}
