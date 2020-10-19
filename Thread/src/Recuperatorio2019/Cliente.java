package Recuperatorio2019;

public class Cliente implements Runnable {
	
	private String trago1;
	private String trago2;
	private int id;
	private Bar b;
	private int n;
	
	public Cliente(Bar b,int id) {
		this.b = b;
		this.id = id;
		this.trago1 = null;
		this.trago2 = null;
	}

	public int getId() {
		return this.id;
	}
	
	public void setCantDeTragos(int n) {
		this.n = n;
	}
	
	public int getCantDeTragos() {
		return this.n;
	}

	public void setTrago1(String trago) {
		this.trago1 = trago;
	}
	
	public void setTrago2(String trago) {
		this.trago2 = trago;
	}
	
	public String getTrago1() {
		return this.trago1;
	}
	
	public String getTrago2() {
		return this.trago2;
	}
	
	public void run() {
		
	}
	
}
