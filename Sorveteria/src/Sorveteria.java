import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Sorveteria {

    public static void main(String[] args) {
        CarrinhoCompras carrinho = new CarrinhoCompras();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo a nossa sorveteria!");
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nMenu:");
            System.out.println("1. Ver carrinho");
            System.out.println("2. Ver sabores disponíveis");
            System.out.println("3. Comprar");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao1;

            while (true) {
                try {
                    System.out.print("Escolha uma opção: ");
                    opcao1 = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    break; // Se a leitura for bem-sucedida, sai do loop
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, insira um número inteiro válido.");
                    scanner.next(); // Limpa o buffer do scanner
                }
            }

            switch (opcao1) {
                case 1:
                    System.out.println("\nVisualizando carrinho");
                    mostrarCarrinho(carrinho);
                    break;
                case 2:
                    System.out.println("\nCardápio");
                    SaboresDisponiveis.mostrarSabores();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("\nRealizando compra");
                    boolean continuarCompra = true;
                
                    while (continuarCompra) {
                        SaboresDisponiveis.mostrarSabores();
                        // Mostrar o menu
                        System.out.println("\nMenu:");
                        System.out.println("1. Adicionar sorvete ao carrinho");
                        System.out.println("2. Excluir sorvete do carrinho");
                        System.out.println("3. Editar quantidade de sorvete no carrinho");
                        System.out.println("4. Salvar carrinho");
                        System.out.println("5. Finalizar compra");
                        System.out.println("6. Voltar para o menu");

                        // Solicitar a opção do cliente
                        System.out.print("Escolha uma opção: ");
                        int opcao2;

                        while (true) {
                            try {
                                System.out.print("Escolha uma opção: ");
                                opcao2 = scanner.nextInt();
                                scanner.nextLine(); // Limpar o buffer do scanner
                                break; // Se a leitura for bem-sucedida, sai do loop
                            } catch (InputMismatchException e) {
                                System.out.println("Por favor, insira um número inteiro válido.");
                                scanner.next(); // Limpa o buffer do scanner
                            }
                        }
                        
                        switch (opcao2) {
                            case 1:
                                // Adicionar sorvete ao carrinho
                                System.out.print("\nDigite o sabor do sorvete desejado: ");
                                String sabor = scanner.nextLine();
                                sabor = sabor.toLowerCase();

                                System.out.print("\nDigite a quantidade desejada: ");
                                int quantidade = scanner.nextInt();
                                scanner.nextLine(); // Limpar o buffer do scanner

                                carrinho.adicionarSorvete(new Sorvete(sabor, quantidade));
                                mostrarCarrinho(carrinho);
                                break;

                            case 2:
                                // Excluir sorvete do carrinho
                                System.out.print("\nDigite o índice do sorvete que deseja excluir: ");
                                int indiceExcluir = scanner.nextInt();
                                scanner.nextLine(); // Limpar o buffer do scanner
                                carrinho.excluirSorvete(indiceExcluir);
                                mostrarCarrinho(carrinho);
                                break;
                            case 3:
                                // Editar quantidade de sorvete no carrinho
                                System.out.print("\nDigite o índice do sorvete que deseja editar: ");
                                int indiceEditar = scanner.nextInt();
                                scanner.nextLine(); // Limpar o buffer do scanner
                                System.out.print("\nDigite a nova quantidade: ");
                                int novaQuantidade = scanner.nextInt();
                                scanner.nextLine(); // Limpar o buffer do scanner
                                carrinho.editarQuantidade(indiceEditar, novaQuantidade);
                                mostrarCarrinho(carrinho);
                                break;
                            case 4:
                                // Salvar carrinho
                                carrinho.salvarCarrinho();
                                System.out.println("\nCarrinho salvo com sucesso!");
                                break;
                            case 5:
                                // Tela de pagamento (finalizar compra)
                                Pagamento.mostrarTelaPagamento(carrinho.getListaSorvetes());
                                System.out.println("\nCompra finalizada. Obrigado!");
                                System.exit(0);
                                break;
                            case 6:
                                // Voltar menu
                                continuarCompra = false;
                                break;
                            default:
                                System.out.println("\nOpção inválida.");
                        }
                    }
                    break;
                case 4:
                    continuar = false;
                    System.out.println("\nObrigado por visitar nossa sorveteria!");
                    break;
                default:
                    System.out.println("\nOpção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }

    // Método para mostrar o carrinho de compras
    public static void mostrarCarrinho(CarrinhoCompras carrinho) {
        System.out.println("\nCarrinho de Compras:");
        ArrayList<Sorvete> listaSorvetes = carrinho.getListaSorvetes();
        for (int i = 0; i < listaSorvetes.size(); i++) {
            Sorvete sorvete = listaSorvetes.get(i);
            System.out.println("- Índice: " + i + ", Sabor: " + sorvete.getSabor() + ", Quantidade: " + sorvete.getQuantidade());
        }
    }
}
