package Recuperatorio2019_Berni;

import java.util.ArrayList;

public class Bar {
	
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private ArrayList<String> botellas = new ArrayList<>();

	public Bar() {
		// suponiendo: de 0 a 5: (cerveza,whisky,fernet,vodka,coca,jugo de naranja)
		botellas.add("cerveza");
		botellas.add("whisky");
		botellas.add("fernet");
		botellas.add("vodka");
		botellas.add("coca");
		botellas.add("jugonaranja");
	}

	public ArrayList<String> getBotellas() {
		return botellas;
	}

	public synchronized void Entrar(Cliente c) { // sincronizo para que puedan entrar de a 1 los clientes
		clientes.add(c);
		this.notify();
	}

	public synchronized Cliente siguiente() { // sincronizo porque dos Bartenders pueden acceder a buscar siguiente
												// cliente al mismo tiempo.

		while (clientes.isEmpty()) {
			try {
				this.wait(); // DUERME EL TH BARTENDER
			} catch (InterruptedException e) {
			}
		}
		Cliente act = clientes.remove(0);
		return act;
	}
}