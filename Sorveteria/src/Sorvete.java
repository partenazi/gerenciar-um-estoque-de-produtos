
// Classe para representar um sorvete
class Sorvete {
    private String sabor;
    private int quantidade;
    private double preco;

    public Sorvete(String sabor, int quantidade) {
        this.sabor = sabor;
        this.quantidade = quantidade;
    }

    // Getters e Setters

    public String getSabor() {
        return sabor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
