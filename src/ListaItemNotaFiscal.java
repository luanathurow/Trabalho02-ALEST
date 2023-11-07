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

    public ItemNotaFiscal encontrarNotaPorNumero(String numero) {
        ItemNotaFiscal atual = inicio;
        while (atual != null) {
            if (atual.getItemNumero().equalsIgnoreCase(numero)) {
                return atual;
            }
            atual = atual.proximo;
        }
        return null;
    }

    public void imprimirTodaLista() {
        ItemNotaFiscal itemAtual = inicio;
        while (itemAtual != null) {
            System.out.println(itemAtual.toString());
            itemAtual = itemAtual.proximo;
        }
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

    public void adicionar(NotaFiscal nf) {
    }
}