
import java.util.Random;

public class Descontos {
    // Método para aplicar um cupom de desconto aleatório
    public static double[] aplicarDesconto(double totalCompra) {
        // Gerar um número aleatório entre 5% e 20%
        Random random = new Random();
        double descontoPercentual = random.nextDouble() * (0.20 - 0.05) + 0.05;

        // Calcular o valor do desconto
        double desconto = totalCompra * descontoPercentual;

        // Aplicar o desconto ao total da compra
        double totalComDesconto = totalCompra - desconto;

        // Retornar o total da compra com desconto e a porcentagem do desconto aplicado
        return new double[]{totalComDesconto, descontoPercentual};
    }
}
