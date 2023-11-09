# Trabalho02-ALEST

## Aplicação
A aplicação é um programa que lida com notas fiscais. Ela permite a leitura de dados a partir de um arquivo CSV e fornece várias funcionalidades para manipular e consultar informações relacionadas a notas fiscais.

## Classe `NotaFiscal`
A classe `NotaFiscal` representa uma nota fiscal. Ela armazena informações como número, data, cliente, endereço, itens da nota e outros detalhes relacionados a uma nota fiscal. Esta classe também contém métodos para acessar e modificar essas informações. Além disso, ela fornece uma representação em forma de string da nota fiscal.

## Classe `ListaNotaFiscal`
A classe `ListaNotaFiscal` é responsável por gerenciar uma lista de notas fiscais. Ela permite a adição de notas fiscais à lista, calcula o valor total de todas as notas fiscais, encontra notas fiscais por número e fornece funcionalidades como encontrar a nota com maior e menor valor, bem como a nota com mais itens. Além disso, ela pode listar todas as notas fiscais presentes na lista.

## Classe `ListaItemNotaFiscal`
A classe `ListaItemNotaFiscal` representa uma lista de itens de uma nota fiscal. Ela permite a adição de itens à lista e fornece métodos para obter a quantidade de itens na lista e uma lista de itens em forma de array.

## Classe `ItemNotaFiscal`
A classe `ItemNotaFiscal` representa um item de uma nota fiscal. Cada item contém informações como número do item, descrição, quantidade e valor unitário. A classe fornece métodos para calcular o valor total do item e uma representação em forma de string do item.

## Classe `BancoDeDados`
A classe `BancoDeDados` contém um método para ler dados de um arquivo CSV e preencher a lista de notas fiscais a partir desses dados. Isso permite a carga inicial das notas fiscais na aplicação a partir de um arquivo externo.