import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Pagamento {
    // Método para calcular o total da compra
    public static double calcularTotal(ArrayList<Sorvete> carrinho) {
        double total = 0.0;
        for (Sorvete sorvete : carrinho) {
            total += sorvete.getQuantidade() * obterPrecoSorvete(sorvete.getSabor());
        }
        return total;
    }

    // Método para aplicar o desconto e atualizar o preço dos sorvetes
    public static void aplicarDesconto(ArrayList<Sorvete> carrinho) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDeseja aplicar um cupom de desconto? (sim/não): ");
        String opcaoCupom = scanner.nextLine();
        if (opcaoCupom.equalsIgnoreCase("sim")) {
            // Gerar uma porcentagem de desconto aleatória entre 5% e 20%
            Random random = new Random();
            int porcentagemDesconto = random.nextInt(16) + 5;

            // Calcular o total antes do desconto
            double totalAntesDesconto = calcularTotal(carrinho);

            // Aplicar desconto
            double desconto = totalAntesDesconto * (porcentagemDesconto / 100.0);

            // Calcular o novo total após o desconto
            double novoTotalCompra = totalAntesDesconto - desconto;

            // Exibir o desconto e o novo total
            System.out.println("Cupom de Desconto Aplicado: " + porcentagemDesconto + "%");
            System.out.println("Total da Compra após Desconto: R$" + novoTotalCompra);
        }
    }

    // Método para apresentar a tela de pagamento
    public static void mostrarTelaPagamento(ArrayList<Sorvete> carrinho) {
        System.out.println("\nTela de Pagamento:");
        System.out.println("Itens no Carrinho:");

        // Variável para armazenar o total da compra antes do desconto
        double totalAntesDesconto = 0.0;

        for (Sorvete sorvete : carrinho) {
            String sabor = sorvete.getSabor();
            int quantidade = sorvete.getQuantidade();
            double precoUnitario = obterPrecoSorvete(sorvete.getSabor()); // Obter preço unitário do sorvete
            double precoTotal = quantidade * precoUnitario; // Calcular preço total do sorvete
            totalAntesDesconto += precoTotal; // Adicionar ao total da compra antes do desconto
            System.out.println("- " + sabor + ", Quantidade: " + quantidade + ", Preço unitário: R$" + precoUnitario + ", Preço total: R$" + precoTotal);
        }

        // Aplicar desconto, se desejado
        aplicarDesconto(carrinho);
    }

    // Método para obter o preço do sorvete pelo sabor
    private static double obterPrecoSorvete(String sabor) {
        switch (sabor.toLowerCase()) {
            case "morango":
                return SaboresDisponiveis.obterPrecoMorango();
            case "chocolate":
                return SaboresDisponiveis.obterPrecoChocolate();
            case "baunilha":
                return SaboresDisponiveis.obterPrecoBaunilha();
            default:
                return 0.0; // Preço padrão caso o sabor não seja reconhecido
        }
    }
}
