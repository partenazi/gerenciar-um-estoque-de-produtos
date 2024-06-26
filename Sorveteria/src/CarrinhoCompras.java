
import java.util.ArrayList;

// Classe para gerenciar o carrinho de compras
class CarrinhoCompras {
    private ArrayList<Sorvete> carrinho;

    public CarrinhoCompras() {
        this.carrinho = new ArrayList<>();
    }

    // Adicionar um sorvete ao carrinho
    public void adicionarSorvete(Sorvete sorvete) {
        carrinho.add(sorvete);
    }

    // Adicionar uma lista de sorvetes ao carrinho
    public void adicionarSorvetes(ArrayList<Sorvete> sorvetes) {
        carrinho.addAll(sorvetes);
    }

    // Excluir sorvete do carrinho
    public void excluirSorvete(int indice) {
        carrinho.remove(indice);
    }

    // Editar quantidade de sorvete no carrinho
    public void editarQuantidade(int indice, int novaQuantidade) {
        carrinho.get(indice).setQuantidade(novaQuantidade);
    }

    // Salvar carrinho (pode ser implementado para salvar em um arquivo, por exemplo)
    public void salvarCarrinho() {
        
    }

    // Obter lista de sorvetes no carrinho
    public ArrayList<Sorvete> getListaSorvetes() {
        return carrinho;
    }
}
