package miBarberia;

public class Barbero implements Runnable{
	
	private String nombre;
	private Barberia barberia;
	
	public Barbero(String nombre, Barberia barberia) {
		this.nombre = nombre;
		this.barberia = barberia;
	}
	
	public void run() {
		while(true) {
			try {
				Cliente siguiente = this.barberia.getSiguiente();
				System.out.println(this.nombre + " esta atendiendo a " + siguiente.getNombre() + ".");
				//Este es un tiempo para simular el tiempo que tarda en cortar el pelo
				Thread.sleep(2000);
				System.out.println(siguiente.getNombre() + " ya fue atendido.");
				siguiente.setAtendido();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
