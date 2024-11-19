package kitanda.model;

public class CestaFruta extends Produto {

    private String frutas;

    public CestaFruta(int numero, float preco, String frutas) {
        super(numero, preco);
        this.frutas = frutas;
    }

    public String getFrutas() {
        return frutas;
    }

    public void setFrutas(String frutas) {
        this.frutas = frutas;
    }


    @Override
    public void visualizar() {
        super.visualizar();
        System.out.println("Fruta: " + this.frutas);
    }
}
