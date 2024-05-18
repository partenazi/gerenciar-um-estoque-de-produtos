package Sorveteria;

import java.util.ArrayList;

public class Pagamento {
    // Método para calcular o total da compra
    public static double calcularTotal(ArrayList<Sorvete> carrinho) {
        double total = 0.0;
        for (Sorvete sorvete : carrinho) {
            total += sorvete.getQuantidade();
        }
        return total;
    }

    // Método para apresentar a tela de pagamento
    public static void mostrarTelaPagamento(ArrayList<Sorvete> carrinho) {
        System.out.println("\nTela de Pagamento:");
        System.out.println("Itens no Carrinho:");
    
        double total = 0.0;
    
        for (Sorvete sorvete : carrinho) {
            String sabor = sorvete.getSabor();
            int quantidade = sorvete.getQuantidade();
            double precoUnitario;
    
            // Determinar o preço do sorvete com base no sabor
            switch (sabor.toLowerCase()) {
                case "morango":
                    precoUnitario = SaboresDisponiveis.getPrecoMorango();
                    break;
                case "chocolate":
                    precoUnitario = SaboresDisponiveis.getPrecoChocolate();
                    break;
                case "baunilha":
                    precoUnitario = SaboresDisponiveis.getPrecoBaunilha();
                    break;
                default:
                    precoUnitario = 0.0; // Preço padrão caso o sabor não seja reconhecido
                    break;
            }
    
            double precoTotal = quantidade * precoUnitario;
            total += precoTotal; // Adicionar o preço total do sorvete ao total da compra
    
            System.out.println("- " + sabor + ", Quantidade: " + quantidade + ", Preço unitário: R$" + precoUnitario + ", Preço total: R$" + precoTotal);
        }
    
        System.out.println("Total da Compra: R$" + total);
    }
    
    
}

