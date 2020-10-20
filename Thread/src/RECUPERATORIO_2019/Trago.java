package RECUPERATORIO_2019;

public class Trago {

    private String nombreTrago;
    private String botella1;
    private String botella2;

    public Trago(String nombreTrago, String botella1, String botella2) {
        this.nombreTrago = nombreTrago;
        this.botella1 = botella1;
        this.botella2 = botella1;
    }

    public Trago(String nombreTrago, String botella1) {
        this.nombreTrago = nombreTrago;
        this.botella1 = botella1;
        this.botella2 = null;
    }

    public String getNombreTrago() {
        return nombreTrago;
    }

    public String getBotella1() {
        return botella1;
    }

    public String getBotella2() {
        return botella2;
    }
}
