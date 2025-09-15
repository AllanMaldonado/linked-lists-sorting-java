# Algoritmos de Ordenação em Listas Ligadas

## Visão Geral
Este projeto implementa uma **lista duplamente ligada** em Java que contém diversos **algoritmos clássicos de ordenação**.  
O foco é demonstrar como diferentes técnicas podem ser aplicadas diretamente em listas encadeadas.

## Arquitetura
- **`No`**: Classe nó representando elementos individuais na lista duplamente ligada
- **`Lista`**: Classe principal implementando a lista duplamente ligada com algoritmos de ordenação
- **`Main`**: Classe de teste com testes unitários abrangentes

### 📌 Ordenações Básicas
- **Bubble Sort (`bolha`)**  
  Percorre a lista repetidamente, trocando elementos vizinhos fora de ordem.  
- **Shake Sort (`shake`)**  
  Variação do Bubble Sort que percorre a lista em ambas as direções.  

### 📌 Ordenações por Inserção
- **Insertion Sort (`insercaoDireta`)**  
  Insere cada elemento em sua posição correta em uma parte já ordenada.  
- **Insertion Sort Binário (`insercaoBin`)**  
  Versão otimizada do Insertion Sort utilizando busca binária para localizar a posição de inserção.  

### 📌 Ordenação por Seleção
- **Selection Sort (`selecaoDireta`)**  
  Seleciona repetidamente o menor (ou maior) elemento e o coloca na posição correta.  

### 📌 Ordenações Avançadas
- **QuickSort sem pivô (`quickSemPivo` / `quickSP`)**  
  Variação do QuickSort que não utiliza pivô explícito.  
- **QuickSort com pivô (`quickComPivo`)**  
  Implementação tradicional do QuickSort, utilizando um pivô para particionar a lista.  
- **HeapSort (`heap`)**  
  Constrói uma estrutura de heap a partir da lista e organiza os elementos.  
- **ShellSort (`shell`)**  
  Generalização do Insertion Sort que compara elementos distantes e reduz os intervalos gradualmente.  

## Objetivo
O projeto serve como recurso **educacional**, permitindo estudar e comparar a eficiência de diferentes algoritmos de ordenação aplicados a listas ligadas.  

