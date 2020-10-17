package blancanieves;

public class Blancanieves implements Runnable {

	private Comedor comedor;

	public Blancanieves(Comedor c) {
		this.comedor = c;
	}

	public void run() {
		while (true) {
			try {
				this.comedor.pasear();
				this.comedor.servirComida();
			} catch (InterruptedException ex) {

			}
		}
	}

}
