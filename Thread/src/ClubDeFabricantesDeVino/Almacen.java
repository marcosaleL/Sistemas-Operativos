package ClubDeFabricantesDeVino;

import java.util.ArrayList;

public class Almacen {
	
	private ArrayList<Miembro> miembros;
	private int jarrasDisponibles = 6;
	private int levaduraDisponible = 20;
	private int jugoDisponible = 15;
	private int unidadesFermentacion = 7;
	private int unidadMezcla = 2;
	private Administrador administrador;
	private boolean primeraEstacionOcupada;
	private boolean segundaEstacionOcupada;
	
	public Almacen() {
		this.primeraEstacionOcupada = false;
		this.segundaEstacionOcupada = false;
		this.miembros = new ArrayList<Miembro>();
		this.administrador = null;
	}
	
	//Un miembro entra a la primera estacion
	public synchronized void entroPrimeraEstacion(Miembro m) {
		this.miembros.add(m);
		this.primeraEstacionOcupada = true;
		this.notify();
	}
	
	//Miembro entra a la segunda estacion
	public synchronized void entroSegundaEstacion(Miembro m) {
		this.miembros.add(m);
		this.segundaEstacionOcupada = true;
		this.notify();
	}
	
	public void addAdministrador(Administrador a) {
		this.administrador = a;
	}
	
	public boolean estaOcupadaLaPrimeraEstacion() {
		if(!this.miembros.isEmpty())
			this.miembros.remove(0);
		return this.primeraEstacionOcupada;
	}
	
	public boolean estaOcupadaLaSegundaEstacion() {
		if(!this.miembros.isEmpty())
			this.miembros.remove(0);
		return this.segundaEstacionOcupada;
	}
	
	//Miembro deja la primera estacion
	public synchronized void setPrimeraEstacion() {
		this.primeraEstacionOcupada = false;
		this.notify();
	}
	
	//Miembro deja la segunda estacion
	public synchronized void setSegundaEstacion() {
		this.segundaEstacionOcupada = false;
		this.notify();
	}

	public int getJarrasDisponibles() {
		return jarrasDisponibles;
	}

	public synchronized void setJarrasDisponibles(int n) {
		this.jarrasDisponibles = n;
		this.notify();
	}

	public int getLevaduraDisponible() {
		return levaduraDisponible;
	}

	public synchronized void setLevaduraDisponible(int n) {
		this.levaduraDisponible = n;
		this.notify();
	}

	public int getJugoDisponible() {
		return jugoDisponible;
	}

	public synchronized void setJugoDisponible(int n) {
		this.jugoDisponible = n;
		this.notify();
	}

	public int getUnidadesFermentacion() {
		return unidadesFermentacion;
	}

	public synchronized void setUnidadesFermentacion(int n) {
		this.unidadesFermentacion = n;
		this.notify();
	}

	public int getUnidadMezcla() {
		return unidadMezcla;
	}

	public synchronized void setUnidadMezcla(int n) {
		this.unidadMezcla = n;
		this.notify();
	}
	
	public void adminRepone() {
		administrador.reponer();
	}
}
