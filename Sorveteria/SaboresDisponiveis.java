package Sorveteria;

// Classe para mostrar os sabores disponíveis e seus preços
public class SaboresDisponiveis {
    // Preços dos sabores
    private static double precoMorango = 3.50;
    private static double precoChocolate = 3.00;
    private static double precoBaunilha = 2.50;

    // Método para mostrar os sabores disponíveis
    public static void mostrarSabores() {
        System.out.println("\nSabores disponíveis:");
        System.out.println("- Morango - 3.50");
        System.out.println("- Chocolate - 3.00");
        System.out.println("- Baunilha - 2.50");
    }

    // Métodos para obter os preços dos sabores
    public static double getPrecoMorango() {
        return precoMorango;
    }

    public static double getPrecoChocolate() {
        return precoChocolate;
    }

    public static double getPrecoBaunilha() {
        return precoBaunilha;
    }
}
