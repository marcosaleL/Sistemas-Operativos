package Recuperatorio2019;

public class Orden {
	
	private int bot1;
	private int bot2;
	private int precio;

	public Orden() {
		this.bot1 = (int) (Math.random() * 6);
		this.bot2 = -1;
		if (Math.random() > 0.5) {
			int val = (int) (Math.random() * 6);
			if (this.bot1 != val) {
				this.bot2 = val;
			}
		}
		this.precio = (int) Math.random() * 100;
	}

	public int getBot1() {
		return bot1;
	}

	public int getPrecio() {
		return precio;
	}

	public int getBot2() {
		return bot2;
	}

}