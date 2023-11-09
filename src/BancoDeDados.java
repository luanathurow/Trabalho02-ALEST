import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;

public class BancoDeDados {
    public static void lerArquivo(ListaNotaFiscal exemploListaNF) throws IOException {
        String linha;
        String arquivo = "C:\\Trabalho02-ALEST-main\\arq\\notas_fiscais_00100.csv";
        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
        NotaFiscal nf = null;

        try {
            leitor.readLine(); 
            
            while ((linha = leitor.readLine()) != null) {
                String[] colunas = linha.split("[|]");
                String numeroNota = colunas[0];
                
                if (nf == null || !nf.getNumero().equals(numeroNota)) {
                    nf = new NotaFiscal();
                    nf.setNumero(numeroNota);
                    nf.setData(Date.valueOf(colunas[1]));
                    nf.setCliente(colunas[2]);
                    nf.setEndereco(colunas[3]);
                    
                    ListaItemNotaFiscal items = new ListaItemNotaFiscal();
                    nf.setItens(items);
                    
                    exemploListaNF.adicionar(nf);
                }
                
                ItemNotaFiscal item = new ItemNotaFiscal(
                    colunas[7],
                    colunas[8],
                    Integer.parseInt(colunas[9]),
                    Double.parseDouble(colunas[10])
                );
                
                nf.getItens().adicionar(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            leitor.close();
        }
    }
}
