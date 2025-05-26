import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
	public static DecimalFormat df = new DecimalFormat("######.######");
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int escolha;
        String pergunta;

        do {
            System.out.println("Escolha uma opção:\n"
			+ "1- Ver as cotações atuais.\n"
			+ "2- Converter Moedas.\n"
			+ "0- Sair");

            escolha = sc.nextInt();

            if (escolha == 1) {
                exibirMoeda();
            } else if (escolha == 2) {
                escolherMoeda(sc);
            } else if (escolha != 0) {
                System.out.println("Opção inválida!");
            }

            System.out.println("Deseja continuar? Escreva apenas sim ou não!");
            sc.nextLine();
            pergunta = sc.nextLine().toLowerCase();

        } while (pergunta.equals("sim"));
        System.out.println("Encerrando programa...");
        sc.close();
    }

    public static void exibirMoeda() {
        System.out.println("\nCotações atuais:\n"
		+ "1 Bitcoin = 620000 Reais\n"
		+ "1 Real = 1 Real\n"
		+ "1 Dólar = 5.67 Reais\n");
    }

    public static void escolherMoeda(Scanner sc) {
        int escolhaMoeda;

        do {
            System.out.println("\nEscolha a moeda que deseja converter:\n"
			+ "1- Bitcoin\n"
			+ "2- Real\n"
			+ "3- Dólar\n"
			+ "0- Retornar");

            escolhaMoeda = sc.nextInt();

            if (escolhaMoeda >= 1 && escolhaMoeda <= 3) {
                System.out.println("\nEscolha a moeda de destino:\n"
                        + "1- Bitcoin\n"
                        + "2- Real\n"
                        + "3- Dólar");

                int destinoMoeda = sc.nextInt();
                if (destinoMoeda >= 1 && destinoMoeda <= 3) {
                    converterMoeda(escolhaMoeda, destinoMoeda, sc);
                } else {
                    System.out.println("Moeda inválida!");
                }
            } else if (escolhaMoeda != 0) {
                System.out.println("Escolha inválida!");
            }
        } while (escolhaMoeda != 0);
    }

    public static void converterMoeda(int origem, int destino, Scanner sc) {
        System.out.println("Insira o valor que você quer converter:");
        float valor = sc.nextFloat();

        float[] conversao = {620000f, 1f, 5.67f};
        float resultado = valor * (conversao[origem - 1] / conversao[destino - 1]);

        System.out.println("Resultado: " + df.format(resultado));
    }
}