package ClubDeFabricantesDeVino;

public class Administrador implements Runnable{

	private int id;
	private Almacen almacen;
	
	public Administrador(Almacen almacen, int id) {
		this.almacen = almacen;
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public synchronized void reponer() {
		almacen.setJarrasDisponibles(6);
		almacen.setJugoDisponible(15);
		almacen.setLevaduraDisponible(20);
		almacen.setUnidadesFermentacion(7);
		almacen.setUnidadMezcla(2);
		this.notifyAll();
	}
	
	public void run() {
		while(true) {
			while((almacen.getJarrasDisponibles() > 6) || (almacen.getUnidadesFermentacion() > 7) || (almacen.getJugoDisponible() > 15) || (almacen.getLevaduraDisponible() > 20) || 
					almacen.getUnidadMezcla() > 2) {
				try {
					this.wait(); //Si estan todos los componentes se duerme
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.reponer();
		}
	}
	
}
