import java.util.Scanner;

public class AgroJava {
    private static final int DIAS_DA_SEMANA = 7;
    private static final int LINHAS = 4;
    private static final int COLUNAS = 4;
    private static final double LIMITE_UMIDADE = 30.0;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in) // ERRO INTENCIONAL: falta ponto e vírgula
        double[] chuvas = new double[DIAS_DA_SEMANA] // ERRO INTENCIONAL: falta ponto e vírgula
        double[][] umidade = new double[LINHAS][COLUNAS];
        boolean dadosCadastrados = false;
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro(entrada, "Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    cadastrarDados(entrada, chuvas, umidade);
                    dadosCadastrados = true;
                    System.out.println("Dados cadastrados com sucesso!");
                    break;
                case 2:
                    if (dadosCadastrados) {
                        exibirMapa(umidade);
                    } else {
                        System.out.println("Cadastre os dados primeiro.");
                    }
                    break;
                case 3:
                    if (dadosCadastrados) {
                        exibirAlertas(umidade);
                    } else {
                        System.out.println("Cadastre os dados primeiro.");
                    }
                    break;
                case 4:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);

        entrada.close();
    }

    private static void exibirMenu() {
        System.out.println("\n===== AGROJAVA =====");
        System.out.println("1 - Cadastrar Dados");
        System.out.println("2 - Exibir Mapa do Campo");
        System.out.println("3 - Relatório de Alertas de Irrigação");
        System.out.println("4 - Sair");
    }

    private static void cadastrarDados(Scanner entrada, double[] chuvas, double[][] umidade) {
        System.out.println("\n--- Registro de Chuvas ---");
        for (int dia = 0; dia < chuvas.length; dia++) {
            chuvas[dia] = lerDouble(entrada, "Chuva do dia " + (dia + 1) + " (mm): ");
        }

        double soma = 0;
        double maiorChuva = chuvas[0];
        int diaMaisChuvoso = 1;
        for (int dia = 0; dia < chuvas.length; dia++) {
            soma += chuvas[dia];
            if (chuvas[dia] > maiorChuva) {
                maiorChuva = chuvas[dia];
                diaMaisChuvoso = dia + 1;
            }
        }
        System.out.printf("Média semanal de chuva: %.2f mm%n", soma / chuvas.length);
        System.out.printf("Dia com maior chuva: dia %d (%.2f mm)%n", diaMaisChuvoso, maiorChuva);

        System.out.println("\n--- Mapeamento de Umidade ---");
        for (int linha = 0; linha < umidade.length; linha++) {
            for (int coluna = 0; coluna < umidade[linha].length; coluna++) {
                umidade[linha][coluna] = lerDouble(entrada,
                        "Umidade do talhão [" + (linha + 1) + "][" + (coluna + 1) + "] (%): ");
            }
        }
    }

    private static void exibirMapa(double[][] umidade) {
        System.out.println("\n--- Mapa de Umidade do Campo ---");
        for (double[] linha : umidade) {
            for (double valor : linha) {
                System.out.printf("%8.2f%%", valor);
            }
            System.out.println();
        }
    }

    private static void exibirAlertas(double[][] umidade) {
        System.out.println("\n--- Alertas de Irrigação ---");
        boolean encontrouAlerta = false;
        for (int linha = 0; linha < umidade.length; linha++) {
            for (int coluna = 0; coluna < umidade[linha].length; coluna++) {
                if (umidade[linha][coluna] < LIMITE_UMIDADE) {
                    System.out.printf("Talhão [linha %d][coluna %d] precisa de irrigação: %.2f%%%n",
                            linha + 1, coluna + 1, umidade[linha][coluna]);
                    encontrouAlerta = true;
                }
            }
        }
        if (!encontrouAlerta) {
            System.out.println("Nenhum talhão precisa de irrigação.");
        }
    }

    private static int lerInteiro(Scanner entrada, String mensagem) {
        System.out.print(mensagem);
        while (!entrada.hasNextInt()) {
            System.out.println("Digite um número inteiro válido.");
            entrada.next();
            System.out.print(mensagem);
        }
        return entrada.nextInt();
    }

    private static double lerDouble(Scanner entrada, String mensagem) {
        System.out.print(mensagem);
        while (!entrada.hasNextDouble()) {
            System.out.println("Digite um valor numérico válido.");
            entrada.next();
            System.out.print(mensagem);
        }
        return entrada.nextDouble();
    }
}
