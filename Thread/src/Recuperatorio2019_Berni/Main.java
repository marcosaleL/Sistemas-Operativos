package Recuperatorio2019_Berni;

public class Main {

	public static void main(String[] args) {
		Bar b = new Bar();
		for (int i = 0; i < 3; i++) {
			Bartender bt = new Bartender(b, i);
			Thread tbt = new Thread(bt);
			tbt.start();
		}
		for (int i = 0; i < 10; i++) {
			Cliente c = new Cliente(b, i);
			Thread tc = new Thread(c);
			tc.start();
		}

	}

}
