package Recuperatorio2019;

public class Bartender implements Runnable{

	private Bar bar;
	private boolean pagaron;
	private Orden orden;
	private int id;
	private int ganancia;
	
	public Bartender(Bar bar, int id) {
		this.bar = bar;
		this.id = id;
		this.pagaron = false;
		this.orden = null;
		this.ganancia = 0;
	}
	
	public synchronized void setOrden(Orden orden) {
		this.orden = orden;
		this.notify(); //Le ingresaron el pedido, entonces lo despierto
	}
	
	public synchronized void setPagaron(int plata) {
		this.ganancia += plata;
		this.pagaron = true;
		this.notify(); //Le acaban de pagar, si esta durmiendo lo despierto 
	}
	
	public void preparandoBebida(int bebida1, int bebida2) {
		synchronized(this.bar.getBebidas().get(bebida1)) {
			//Sincronizo la primer bebida
			if (bebida2 != -1) {
				//Esto quiere decir que necesita dos bebidas para poder prepararla
				synchronized(this.bar.getBebidas().get(bebida2)) {
					//Sincronizo la segunda bebida
					System.out.println("El bartender " + this.id + " esta preparando la bebida.");
					try {
						Thread.sleep(2000); //Simulo que prepara la bebida
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			else {
				//Esto quiere decir que solamente necesita una bebida para prepararla
				System.out.println("El bartender " + this.id + " esta preparando la bebida.");
				try {
					Thread.sleep(2000); //Simulo que prepara la bebida
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void run() {
		while(true) {
			Cliente siguiente = this.bar.siguienteCliente(); //El bartender atiende al siguiente cliente
			siguiente.setBartender(this); //Se presenta con el cliente
			System.out.println("El bartender " + this.id + " esta atendiendo al cliente " + siguiente.getId() + ".");
			synchronized(this) {
				while(this.orden == null) {
					try {
						this.wait(); //Mientras el cliente no le diga que quiere tomar, el bartender duerme
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			this.preparandoBebida(this.orden.getBot1(), this.orden.getBot2()); //El bartender empieza a preparar la bebida
			System.out.println("El bartender " + this.id + " le da la bebida al cliente " + siguiente.getId() + ".");
			siguiente.setTrago();
			synchronized(this) {
				while(!this.pagaron) {
					try {
						this.wait(); //Espera que le paguen por la bebida
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println("El bartender " + this.id + " atendio al cliente " + siguiente.getId() + ".");
			this.pagaron = false;
			this.orden = null;
		}
	}
	
}
