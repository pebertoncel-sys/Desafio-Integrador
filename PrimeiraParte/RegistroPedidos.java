import java.util.Locale;
import java.util.Scanner;


public class RegistroPedidos {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.US);

        int quantidade = 0;
        double total = 0;
        double maior = 0;
        double menor = 0;
        int continuar = 1;

        System.out.println("=== SISTEMA DE PEDIDOS ===");

        do {
            System.out.print("\nNome do cliente: ");
            String nome = entrada.nextLine();

            double valor = 0;
            while (valor <= 0) {
                System.out.print("Valor da compra: ");
                String valorDigitado = entrada.nextLine().replace(",", ".");

                try {
                    valor = Double.parseDouble(valorDigitado);
                    if (valor <= 0) {
                        System.out.println("O valor precisa ser maior que zero.");
                    }
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
                if (valor > maior) {
                    maior = valor;
                }
                if (valor < menor) {
                    menor = valor;
                }
            }

            System.out.println("Pedido de " + nome + " cadastrado.");
            System.out.println("\nCadastrar novo pedido?");
            System.out.println("1 - Sim");
            System.out.println("2 - Nao");
            System.out.print("Escolha: ");

            String escolha = entrada.nextLine();
            try {
                continuar = Integer.parseInt(escolha);
            } catch (NumberFormatException erro) {
                continuar = 2;
            }
        } while (continuar == 1);

        double media = total / quantidade;

        System.out.println("\n===== RELATORIO FINAL =====");
        System.out.println("Quantidade de pedidos: " + quantidade);
        System.out.printf("Valor total vendido: R$ %.2f%n", total);
        System.out.printf("Ticket medio: R$ %.2f%n", media);
        System.out.printf("Maior compra: R$ %.2f%n", maior);
        System.out.printf("Menor compra: R$ %.2f%n", menor);

        entrada.close();
    }
}
