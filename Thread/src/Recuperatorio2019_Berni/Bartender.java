package Recuperatorio2019_Berni;

public class Bartender implements Runnable {
	
	private Bar bar;
	private boolean pagaron = false;
	private Orden orden = null;
	private int id;

	public Bartender(Bar b, int i) {
		this.bar = b;
		this.id = i;
	}

	public int getId() {
		return id;
	}

	public synchronized void setOrden(Orden o) {
		this.orden = o;
		this.notify();
	}

	public synchronized void pagar(int plata) {
		// ver que se hace con la plata, creo que no es importante en el problema.
		this.pagaron = true;
		this.notify();
	}

	public void mezclar(int b1, int b2) {
		synchronized (bar.getBotellas().get(b1)) {
			if (b2 != -1) {
				synchronized (bar.getBotellas().get(b2)) {
					try {
						System.out.println("El bartender " + this.id + " está mezclando el ingrediente "
								+ bar.getBotellas().get(b1) + " y " + bar.getBotellas().get(b2));
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			} else {
				try {
					System.out.println("El bartender " + this.id + " está mezclando los ingredientes "
							+ bar.getBotellas().get(b1));
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
		}
	}
	// Al terminar el mezclar ya se liberan las botellas utilizadas.

	public void run() {
		while (true) {
			Cliente act = bar.siguiente();
			act.setBartender(this);
			System.out.println("El cliente " + act.getId() + " está siendo atendido por el bartender " + this.getId());
			synchronized (this) {
				while (orden == null) {
					try {
						this.wait();
					} catch (InterruptedException e) {
					}
				}
			}
			this.mezclar(orden.getBot1(), orden.getBot2());
			try {
				System.out.println("El bartender " + this.id + " está preparando su trago al cliente " + act.getId());
				Thread.sleep(1000);// simulo preparar trago
			} catch (InterruptedException e) {
			}
			act.setTrago();
			synchronized (this) {
				while (!pagaron) {
					try {
						this.wait();
					} catch (InterruptedException e) {
					}
				}
				pagaron = false;
				orden = null;
				System.out.println("El bartender " + this.id + " terminó de atender al cliente " + act.getId());
			}
		}
	}
}