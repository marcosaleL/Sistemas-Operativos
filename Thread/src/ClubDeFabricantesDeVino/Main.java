package ClubDeFabricantesDeVino;

public class Main {

	public static void main(String[] args) {

		Almacen almacen = new Almacen();
		
		Administrador administrador = new Administrador(almacen,1);

		almacen.addAdministrador(administrador);
		
		Thread admin = new Thread(administrador);
		
		Thread miembros[] = new Thread[8];
		
		for(int i=0; i<8; i++) {
			miembros[i] = new Thread(new Miembro(almacen,i)); 
		}
		
		for(int i=0; i<8; i++) {
			miembros[i].start();
		}
		
		admin.start();

	}

}
