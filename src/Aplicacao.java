
import java.io.IOException;
import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) throws IOException {
        BancoDeDados bancoDeDados = new BancoDeDados();
        ListaItemNotaFiscal lista = new ListaItemNotaFiscal();

        try {
            bancoDeDados.lerArquivo();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        int op;

        do {
            System.out.println("______________Menu______________");
            System.out.println("1. Consultar dados de um NF");
            System.out.println("2. Exibir numero da NF com maior valor");
            System.out.println("3. Exibir numero da NF de menor valor");
            System.out.println("4. Exibir numero da NF com mais itens");
            System.out.println("5. Listar todas as NF");
            System.out.println("6. Sair");

            System.out.print("Escolha uma opcao: ");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Você escolheu a opcao 1.");
                    System.out.print("Informe o numero da NF: ");
                    scanner.nextLine();
                    String num = scanner.nextLine();

                    ItemNotaFiscal itemEncontrado = lista.encontrarNotaPorNumero(num);

                    if (itemEncontrado != null) {
                        System.out.println(itemEncontrado.toString());
                    } else {
                        System.out.println("Nota fiscal nao encontrada.");
                    }
                    break;
                case 2:
                    System.out.println("Você escolheu a opcao 2.");
                    break;
                case 3:
                    System.out.println("Você escolheu a opcao 3.");
                    break;
                case 4:
                    System.out.println("Você escolheu a opcao 4.");
                    break;
                case 5:
                    System.out.println("Você escolheu a opção 5.");
                    lista.imprimirTodaLista();
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