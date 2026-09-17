import java.util.Scanner;


public class MenuPedidos {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int quantidade = 0;
        double total = 0;
        double maior = 0;
        double menor = 0;
        int opcao = 0;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Cadastrar Pedido");
            System.out.println("2 - Exibir Relatorio");
            System.out.println("3 - Encerrar Sistema");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException erro) {
                opcao = 0;
            }

            if (opcao == 1) {
                System.out.print("Nome do cliente: ");
                String nome = entrada.nextLine();
                double valor = 0;

                while (valor <= 0) {
                    System.out.print("Valor da compra: ");
                    try {
                        valor = Double.parseDouble(entrada.nextLine().replace(",", "."));
                        if (valor <= 0) System.out.println("O valor precisa ser maior que zero.");
                    } catch (NumberFormatException erro) {
                        System.out.println("Digite um valor valido.");
                    }
                }

                quantidade++;
                total += valor;
                if (quantidade == 1) {
                    maior = valor;
                    menor = valor;
                } else {
                    if (valor > maior) maior = valor;
                    if (valor < menor) menor = valor;
                }
                System.out.println("Pedido de " + nome + " cadastrado.");
            } else if (opcao == 2) {
                if (quantidade == 0) {
                    System.out.println("Nenhum pedido cadastrado.");
                } else {
                    System.out.println("\n===== RELATORIO FINAL =====");
                    System.out.println("Quantidade de pedidos: " + quantidade);
                    System.out.printf("Valor total vendido: R$ %.2f%n", total);
                    System.out.printf("Ticket medio: R$ %.2f%n", total / quantidade);
                    System.out.printf("Maior compra: R$ %.2f%n", maior);
                    System.out.printf("Menor compra: R$ %.2f%n", menor);
                }
            } else if (opcao == 3) {
                System.out.println("Sistema encerrado.");
            } else {
                System.out.println("Opcao invalida.");
            }
        } while (opcao != 3);

        entrada.close();
    }
}
