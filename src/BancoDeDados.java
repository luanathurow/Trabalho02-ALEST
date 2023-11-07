import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;

public class BancoDeDados {
    public void lerArquivo() throws IOException {
        String linha;
        String arquivo = "C:\\Trabalho02-ALEST\\arq\\notas_fiscais_00100.csv";
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
            System.out.println(leitor.readLine()); // pula a primeira linha do cabeçalho
            linha = leitor.readLine();
            String[] colunas = linha.split("[|]");
            String notaAtual = colunas[0];
            String notaAnterior = notaAtual;
            NotaFiscal nf = new NotaFiscal();
            nf.setNumero(colunas[0]);
            nf.setData(Date.valueOf(colunas[1]));
            nf.setCliente(colunas[2]);
            ListaItemNotaFiscal items = new ListaItemNotaFiscal();
            nf.setItens(items);
            while ((linha = leitor.readLine()) != null) {
                colunas = linha.split("[|]");
                notaAtual = colunas[0];
                if (!notaAnterior.equals(notaAtual)) {
                    nf = new NotaFiscal();
                    nf.setNumero(colunas[0]);
                    nf.setData(Date.valueOf(colunas[1]));
                    nf.setCliente(colunas[2]);
                    items = new ListaItemNotaFiscal();
                    nf.setItens(items);
                    notaAnterior = notaAtual;
                }
                ItemNotaFiscal item = new ItemNotaFiscal(
                        colunas[7],
                        colunas[8],
                        Integer.parseInt(colunas[9]),
                        Double.parseDouble(colunas[10]));
                items.adicionar(item);
                System.out.println("Item adicionado à NF " + nf.getNumero() + ": " + item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // lista.imprimirLista();
    }
}