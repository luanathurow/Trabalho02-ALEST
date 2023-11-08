import java.io.IOException;
import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) throws IOException {
        ListaNotaFiscal listaNotaFiscal = new ListaNotaFiscal();

        try {
            BancoDeDados.lerArquivo(listaNotaFiscal);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        int op = 0;

        do {
            System.out.println("______________Menu______________");
            System.out.println("1. Consultar dados de um NF");
            System.out.println("2. Exibir numero da NF com maior valor");
            System.out.println("3. Exibir numero da NF de menor valor");
            System.out.println("4. Exibir numero da NF com mais itens");
            System.out.println("5. Listar todas as NF");
            System.out.println("6. Sair");

            System.out.print("Escolha uma opcao: ");
            String input = scanner.nextLine();

            try {
                op = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            switch (op) {
                case 1:
                    System.out.println("Você escolheu a opção 1.");
                    System.out.print("Informe o número da NF: ");
                    String num = scanner.nextLine();

                    NotaFiscal notaEncontrada = listaNotaFiscal.encontrarNotaFiscalPorNumero(num);

                    if (notaEncontrada != null) {
                        System.out.println(notaEncontrada.toString());
                    } else {
                        System.out.println("Nota fiscal não encontrada.");
                    }
                    break;
                    case 2:
                    System.out.println("Você escolheu a opção 2.");
                    String numeroMaiorValor = listaNotaFiscal.obterNumeroNotaFiscalMaiorValor();
                    if (numeroMaiorValor != null) {
                        System.out.println("Número da NF com maior valor: " + numeroMaiorValor);
                    } else {
                        System.out.println("Nenhuma nota fiscal encontrada.");
                    }
                    break;
                case 3:
                    System.out.println("Você escolheu a opção 3.");
                    String numeroMenorValor = listaNotaFiscal.obterNumeroNotaFiscalMenorValor();
                    if (numeroMenorValor != null) {
                        System.out.println("Número da NF com menor valor: " + numeroMenorValor);
                    } else {
                        System.out.println("Nenhuma nota fiscal encontrada.");
                    }
                    break;
                case 4:
                    System.out.println("Você escolheu a opção 4.");
                    String numeroMaisItens = listaNotaFiscal.obterNumeroNotaFiscalComMaisItens();
                    if (numeroMaisItens != null) {
                        System.out.println("Número da NF com mais itens: " + numeroMaisItens);
                    } else {
                        System.out.println("Nenhuma nota fiscal encontrada.");
                    }
                    break;
                case 5:
                    System.out.println("Você escolheu a opção 5.");
                    listaNotaFiscal.listarTodasNotasFiscais();
                    break;                
                case 6:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        } while (op != 6);

        scanner.close();
    }
}
