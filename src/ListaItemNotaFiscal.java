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

    public ItemNotaFiscal[] getItens() {
        if (quantidade == 0) {
            return null; // Retorna null se a lista estiver vazia
        }
    
        ItemNotaFiscal[] itens = new ItemNotaFiscal[quantidade];
        ItemNotaFiscal aux = inicio;
        int index = 0;
    
        while (aux != null) {
            itens[index] = aux;
            aux = aux.proximo;
            index++;
        }
    
        return itens;
    }
    
}