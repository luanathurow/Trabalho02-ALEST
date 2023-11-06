public class ListaItemNotaFiscal {
    // lista simplesmente encadeada para guardar itens de uma nota fiscal
    private ItemNotaFiscal inicio;
    private ItemNotaFiscal fim;
    private int quantidade;

    public void adicionar(ItemNotaFiscal item) {
        if (quantidade == 0) {
            inicio = item;
            fim = item;
        } else {
            fim.proximo = item;
            fim = item;
        }
        quantidade++;
    }

    public String encontrarNotaPorNumero(String numero) {
        ItemNotaFiscal current = inicio;
        while (current != null) {
            if (current.temNumero(numero)) {
                return current.toString();
            }
            current = current.proximo;
        }
        return null;
    }

    @Override
    public String toString() {
        String s = "";
        ItemNotaFiscal aux = inicio;
        while (aux != null) {
            s = s + aux + "\n";
            aux = aux.proximo;
        }
        return s;
    }

    public int getQuantidade() {
        return quantidade;
    }
}