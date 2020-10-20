package RECUPERATORIO_2019;

public class Main {
    public static void main(String[] args) {
        Bar bar = new Bar(1);
        bar.addBotella("Fernet");
        bar.addBotella("Vodka");
        bar.addBotella("Cerveza");
        bar.addBotella("Wiskhy");
        bar.addBotella("Coca-cola");
        bar.addBotella("Jugo de naranja");

        Bartender bartender1 = new Bartender(1,bar);
        Bartender bartender2 = new Bartender(2,bar);
        Bartender bartender3 = new Bartender(3,bar);

        Trago fernet = new Trago("fernet","Fernet", "Coca-cola");
        Trago destornillador = new Trago("destornillador","Vodka", "Jugo de naranja");
        Trago wiskhy = new Trago("wiskhy","Wiskhy");
        Trago wiskola = new Trago("wiskola","Wiskhy", "Coca-cola");

        Cliente c1 = new Cliente(1,bar,fernet);
        Cliente c2 = new Cliente(2,bar,wiskhy);
        Cliente c3 = new Cliente(3,bar,wiskola);
        Cliente c4 = new Cliente(4,bar,destornillador);
        Cliente c5 = new Cliente(5,bar,fernet);
        Cliente c6 = new Cliente(6,bar,wiskola);

        Thread tb1 = new Thread(bartender1);
        Thread tb2 = new Thread(bartender2);
        Thread tb3 = new Thread(bartender3);

        Thread tc1 = new Thread(c1);
        Thread tc2 = new Thread(c2);
        Thread tc3 = new Thread(c3);
        Thread tc4 = new Thread(c4);
        Thread tc5 = new Thread(c5);
        Thread tc6 = new Thread(c6);

        tb1.start();
        tb2.start();
        tb3.start();

        tc1.start();
        tc2.start();
        tc3.start();
        tc4.start();
        tc5.start();
        tc6.start();

    }

}
