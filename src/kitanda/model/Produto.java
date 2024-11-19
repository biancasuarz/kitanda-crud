package kitanda.model;

public abstract class Produto {

    private int numero;
    private float preco;

    public Produto(int numero, float preco) {
        this.numero = numero;
        this.preco = preco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void excluir() {

    }

    public void visualizar() {
        System.out.println("\n\n*****************************************************");
        System.out.println("Dados do Produto: ");
        System.out.println("*****************************************************");
        System.out.println("Numero do produto: " + this.numero);
        System.out.println("Preço: " + this.preco);
    }


}
