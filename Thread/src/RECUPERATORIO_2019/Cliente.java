package RECUPERATORIO_2019;

public class Cliente implements Runnable{

    private int idCliente;
    private Bar bar;
    private Trago trago;
    private boolean atendido = false;

    public Cliente(int idCliente, Bar bar, Trago trago) {
        this.idCliente = idCliente;
        this.bar = bar;
        this.trago = trago;
    }

    public int getId(){
        return this.idCliente;
    }

    public Trago getTrago(){
        return this.trago;
    }

    private synchronized void esperar(){
        System.out.println("El cliente "+ this.idCliente + " esta esperando");
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void setAtendido(){
        System.out.println("Me atendieron " + this.idCliente + " y me voy");
        this.atendido = true;
        this.notify();
    }

    @Override
    public void run() {
        System.out.println("El cliente llego " + this.idCliente + " al bar...");
        this.bar.addCliente(this);
        this.esperar();
    }
}
