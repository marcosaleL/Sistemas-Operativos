package miBarberia;

public class Cliente implements Runnable{
	
	private String nombre;
	private Barberia barberia;
	private boolean atendido;
	
	public Cliente(String nombre, Barberia barberia) {
		this.nombre = nombre;
		this.barberia = barberia;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public synchronized void setAtendido() {
		this.atendido = true;
		this.notify();
	}
	
	public synchronized void esperaCorte(){
		while(!this.atendido) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void run() {
		System.out.println( this.nombre + " llega a la barberia.");
		boolean pudoSentarse = this.barberia.sentarse(this);
		if (!pudoSentarse) {
			System.out.println(this.nombre + " no se pudo sentar en la barberia y se fue.");
			return;
		}
		System.out.println(this.nombre + " espera en la barberia por su corte.");
		this.esperaCorte();
		System.out.println(this.nombre + " ya fue atendido.");
	}

}
