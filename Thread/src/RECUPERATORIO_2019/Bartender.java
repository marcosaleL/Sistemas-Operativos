package RECUPERATORIO_2019;

import java.util.concurrent.SubmissionPublisher;

public class Bartender implements Runnable{

    private int id;
    private Bar bar;

    public Bartender(int id, Bar bar) {
        this.id = id;
        this.bar = bar;
    }

    public void prepararTrago(Trago trago){
        try {
            System.out.println("El bartender esta preparando el trago " + trago.getNombreTrago() );
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String botella1 = trago.getBotella1();
        this.bar.getBotella(botella1);
        this.bar.addBotella(botella1);
        String botella2 = trago.getBotella2();
        if (botella2 != null){
            this.bar.getBotella(botella2);
            this.bar.addBotella(botella2);
        }
        System.out.println("El trago" + trago.getNombreTrago() +" fue preparado");
    }

    @Override
    public void run() {
        while (true){
            Cliente cliente = this.bar.getCliente();
            System.out.println("El cliente: " + cliente.getId() + " va a ser atendido" );
            this.prepararTrago(cliente.getTrago());
            System.out.println("El bartender " + this.id + " esta cobrando a " + cliente.getId());
            cliente.setAtendido();
        }
    }
}
