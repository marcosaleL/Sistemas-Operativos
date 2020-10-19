package Recuperatorio2019;

public class Cliente implements Runnable {

	private int id;
	private Bar bar;
	private Orden orden;
	private Bartender bartender;
	private boolean tenerTrago;

	public Cliente(Bar b, int id) {
		this.bar = b;
		this.id = id;
		this.orden = new Orden();
		this.bartender = null;
		this.tenerTrago = false;
	}

	public int getId() {
		return this.id;
	}

	public synchronized void setBartender(Bartender b) {
		this.bartender = b;
		this.notify(); // Lo despierto por si no tiene un bartender
	}

	public synchronized void setTrago() {
		this.tenerTrago = true;
		this.notify(); // Lo despierto por que ahora tiene el trago
	}

	public void run() {
		while (true) {
			this.bar.entraCliente(this);// Entro al bar
			System.out.println("El cliente " + this.id + " entro al bar y espera para que lo atiendan.");
			synchronized (this) {
				while (this.bartender == null) {
					try {
						this.wait(); // El cliente duerme mientras tanto por que no tiene bartender
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			this.bartender.setOrden(this.orden); // Le doy al bartender el pedido
			synchronized (this) {
				while (!this.tenerTrago) {
					try {
						this.wait(); // Mientras no el bartender no le de trago, el cliente duerme
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			this.bartender.setPagaron(this.orden.getPrecio()); // Le pago la bebida
			System.out.println("El cliente " + this.id + " ya recibio su bebida y se fue de la barra.");
			this.bartender = null; // Reseteo todo para el siguiente loop
			this.tenerTrago = false; // Reseteo todo para el siguiente loop
			this.orden = new Orden(); // Reseteo todo para el siguiente loop
		}
	}

}
