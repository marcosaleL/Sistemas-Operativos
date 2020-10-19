package Recuperatorio2019_Berni;

public class Cliente implements Runnable {
	
	private Bar bar;
	private Bartender bartender = null;
	private boolean tieneTrago = false;
	private Orden orden;
	private int id;

	public Cliente(Bar b, int i) {
		this.bar = b;
		this.orden = new Orden();
		this.id = i;
	}

	public int getId() {
		return id;
	}

	public synchronized void setTrago() {
		this.tieneTrago = true;
		this.notify();
	}

	public synchronized void setBartender(Bartender b) {
		this.bartender = b;
		this.notify();
	}

	public void run() {
		bar.Entrar(this);
		synchronized (this) {
			while (bartender == null) {
				try {
					// System.out.println("El cliente " + this.id + " entró al bar y está esperando
					// que lo atiendan");
					this.wait();
				} catch (InterruptedException e) {
				}
			}
		}
		bartender.setOrden(orden);
		synchronized (this) {
			while (tieneTrago == false) {
				try {
					this.wait();
				} catch (InterruptedException e) {
				}
			}
		}
		bartender.pagar(orden.getPrecio());
		System.out.println("El cliente " + this.getId() + " ya tomó su trago y se fue del bar");
	}
}