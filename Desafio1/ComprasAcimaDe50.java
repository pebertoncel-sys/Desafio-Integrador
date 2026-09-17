import java.util.Scanner;


public class ComprasAcimaDe50 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int quantidade = 0;
        int acimaDe50 = 0;
        double total = 0;
        double maior = 0;
        double menor = 0;
        int continuar = 1;

        System.out.println("=== SISTEMA DE PEDIDOS ===");

        do {
            System.out.print("Nome do cliente: ");
            String nome = entrada.nextLine();
            double valor = 0;

            while (valor <= 0) {
                System.out.print("Valor da compra: ");
                try {
                    valor = Double.parseDouble(entrada.nextLine().replace(",", "."));
                    if (valor <= 0) {
                        System.out.println("O valor precisa ser maior que zero.");
                    }
                } catch (NumberFormatException erro) {
                    System.out.println("Digite um valor valido.");
                }
            }

            quantidade++;
            total += valor;
            if (valor > 50) {
                acimaDe50++;
            }
            if (quantidade == 1) {
                maior = valor;
                menor = valor;
            } else {
                if (valor > maior) maior = valor;
                if (valor < menor) menor = valor;
            }

            System.out.println("Pedido de " + nome + " cadastrado.");
            System.out.print("Cadastrar novo pedido? 1 - Sim | 2 - Nao: ");
            try {
                continuar = Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException erro) {
                continuar = 2;
            }
        } while (continuar == 1);

        System.out.println("\n===== RELATORIO FINAL =====");
        System.out.println("Quantidade de pedidos: " + quantidade);
        System.out.printf("Valor total vendido: R$ %.2f%n", total);
        System.out.printf("Ticket medio: R$ %.2f%n", total / quantidade);
        System.out.printf("Maior compra: R$ %.2f%n", maior);
        System.out.printf("Menor compra: R$ %.2f%n", menor);
        System.out.println("Compras acima de R$ 50,00: " + acimaDe50);
        entrada.close();
    }
}
