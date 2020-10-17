package blancanieves;

public class Enanito implements Runnable {

	private Comedor comedor;
	private int id;

	public Enanito(Comedor comedor, int i) {
        this.comedor = comedor;
        id = i;
    }
	
	public int getId() {
		return this.id;
	}

	public void run() {

		while (true) {
			try {
				this.comedor.sentarse(this);
				this.comedor.EsperarComida(this);
				this.comedor.comiendo(this);
				this.comedor.terminarDeComer(this);
				this.comedor.trabajando(this);
			} catch (InterruptedException ex) {

			}
		}

	}

}
