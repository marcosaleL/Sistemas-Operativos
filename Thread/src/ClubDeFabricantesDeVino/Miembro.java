package ClubDeFabricantesDeVino;

public class Miembro implements Runnable {
	
	private int id;
	private Almacen almacen;
	
	public Miembro(Almacen almacen, int id) {
		this.almacen = almacen;
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}

	public void mezclaInicial() {
		synchronized(this) {
			while((almacen.getJarrasDisponibles() < 2) || (almacen.getUnidadesFermentacion() < 1) || (almacen.getJugoDisponible() < 1) || (almacen.getLevaduraDisponible() < 1)) {
				try {
					this.wait(); //El miembro se duerme por que no tiene los ingredientes necesarios
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("El miembro " + this.id + " esta preparando la primer mezcla.");
			int jarras = almacen.getJarrasDisponibles() - 2;
			int fermentacion = almacen.getUnidadesFermentacion() - 1;
			int jugos = almacen.getJugoDisponible() - 1;
			int levadura = almacen.getLevaduraDisponible() - 1;
			almacen.setJarrasDisponibles(jarras); 
			almacen.setJugoDisponible(jugos);
			almacen.setLevaduraDisponible(levadura);
			almacen.setUnidadesFermentacion(fermentacion);
		}
	}
	
	public void mezclaFinal() {
		synchronized(this) {
			while((almacen.getJarrasDisponibles() < 6) || (almacen.getUnidadesFermentacion() < 7) || (almacen.getJugoDisponible() < 15) || (almacen.getLevaduraDisponible() < 20)) {
				try {
					this.wait(); //El miembro se duerme por que no tiene los ingredientes necesarios
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("El miembro " + this.id + " esta preparando la segunda mezcla.");
			int jarras = almacen.getJarrasDisponibles() - 6;
			int fermentacion = almacen.getUnidadesFermentacion() - 7;
			int jugos = almacen.getJugoDisponible() - 15;
			int levadura = almacen.getLevaduraDisponible() - 20;
			almacen.setJarrasDisponibles(jarras);
			almacen.setJugoDisponible(jugos);
			almacen.setLevaduraDisponible(levadura);
			almacen.setUnidadesFermentacion(fermentacion);
		}
	}
	
	public void run() {
			synchronized(this) {
				while(almacen.estaOcupadaLaPrimeraEstacion()) {
					try {
						this.wait(); //El miembro espera hasta que este libre la primera estacion
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			almacen.entroPrimeraEstacion(this); //Entra el miembro a la primera estacion.
			this.mezclaInicial();
			almacen.setPrimeraEstacion(); //Miembro deja la estacion
			try {
				Thread.sleep(2000); //Simula el tiempo de 4 semanas
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(this) {
				while(almacen.estaOcupadaLaSegundaEstacion()) {
					try {
						this.wait(); //El miembro espera ha que se libere la segunda estacion
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			almacen.entroSegundaEstacion(this); //Entra el miembro a la segunda estacion.
			this.mezclaFinal();
			almacen.setSegundaEstacion(); //Miembro deja la estacion
			try {
				Thread.sleep(2000); //Simulo que todos prueben el vino
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			almacen.adminRepone();
	}
	
}
