package RECUPERATORIO_2019;

import java.util.LinkedList;
import java.util.List;

public class Bar {

    private int id;
    private List<String> botellas = new LinkedList<>();
    private List<Cliente>  clientes = new LinkedList<>();

    public Bar(int id) {
        this.id = id;
    }

    public synchronized void addCliente(Cliente c){
          this.clientes.add(c);
          this.notify();
    }

    public synchronized Cliente getCliente(){
        while (this.clientes.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.clientes.remove(0);
    }

    public void addBotella(String botella){
        synchronized (this.botellas){
            this.botellas.add(botella);
            this.botellas.notify();
        }
    }

    public String getBotella(String b){
        synchronized (this.botellas){
            while (!this.botellas.contains(b)){
                try {
                    this.botellas.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.botellas.notify();
            return b;
        }
    }


}
