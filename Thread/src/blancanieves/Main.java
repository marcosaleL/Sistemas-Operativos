package blancanieves;

import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		Comedor comedor = new Comedor();
        Thread blanca = new Thread(new Blancanieves(comedor));
        
        Thread enanos[] = new Thread[7];

        for (int i = 0; i < enanos.length; i++) {
            enanos[i] = new Thread(new Enanito(comedor, i));
        }

        for (int i = 0; i < enanos.length; i++) {
            enanos[i].start();
        }
        blanca.start();
	}

}
