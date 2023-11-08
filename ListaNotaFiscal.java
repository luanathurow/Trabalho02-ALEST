public class ListaNotaFiscal {
    private NotaFiscal inicio;
    private NotaFiscal fim;
    private int quantidade;
    public ListaNotaFiscal() {
        inicio = new NotaFiscal();
        fim = new NotaFiscal();
        inicio.setProximo(fim);
        fim.setAnterior(inicio);
    }
    public void adicionar(NotaFiscal nf) {
        if (quantidade == 0) {
            inicio = nf;
            fim = nf;
        } else {
            nf.setAnterior(fim);  
            fim.setProximo(nf);   
            fim = nf;             
        }
        quantidade++;
    }
    

    public NotaFiscal encontrarNotaFiscalPorNumero(String numero) {
        NotaFiscal atual = inicio;
        while (atual != null) {
            String numeroNota = atual.getNumero();
            if (numeroNota != null && numeroNota.equalsIgnoreCase(numero)) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }
    
    public String obterNumeroNotaFiscalMaiorValor() {
        NotaFiscal atual = inicio;
        double maiorValor = 0;
        String numeroMaiorValor = null;
    
        while (atual != null) {
            double valorTotal = calcularValorTotalNota(atual);
            if (valorTotal > maiorValor) {
                maiorValor = valorTotal;
                numeroMaiorValor = atual.getNumero();
            }
            atual = atual.getProximo();
        }
    
        return numeroMaiorValor;
    }
    
    private double calcularValorTotalNota(NotaFiscal nota) {
        ListaItemNotaFiscal itens = nota.getItens();
        ItemNotaFiscal[] listaItens = itens.getItens();
        double valorTotal = 0;
    
        for (ItemNotaFiscal item : listaItens) {
            valorTotal += item.getValorTotalItem();
        }
    
        return valorTotal;
    }
    
    public String obterNumeroNotaFiscalMenorValor() {
        NotaFiscal atual = inicio;
        double menorValor = Double.MAX_VALUE;
        String numeroMenorValor = null;
    
        while (atual != null) {
            double valorTotal = calcularValorTotalNota(atual);
            if (valorTotal < menorValor) {
                menorValor = valorTotal;
                numeroMenorValor = atual.getNumero();
            }
            atual = atual.getProximo();
        }
    
        return numeroMenorValor;
    }
    
    public String obterNumeroNotaFiscalComMaisItens() {
        NotaFiscal atual = inicio;
        int maiorQuantidadeItens = 0;
        String numeroMaisItens = null;
    
        while (atual != null) {
            int quantidadeItens = contarItensNota(atual);
            if (quantidadeItens > maiorQuantidadeItens) {
                maiorQuantidadeItens = quantidadeItens;
                numeroMaisItens = atual.getNumero();
            }
            atual = atual.getProximo();
        }
    
        return numeroMaisItens;
    }
    
    private int contarItensNota(NotaFiscal nota) {
        ListaItemNotaFiscal itens = nota.getItens();
        ItemNotaFiscal[] listaItens = itens.getItens();
        return listaItens.length;
    }
    
    public void listarTodasNotasFiscais() {
        NotaFiscal atual = inicio;
    
        while (atual != null) {
            System.out.println(atual.toString());
            atual = atual.getProximo();
        }
    }
    
    
}