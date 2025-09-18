# Listas Ligadas e Algoritmos de Ordenação

## Visão Geral
Este projeto implementa uma estrutura de dados de lista duplamente ligada com vários algoritmos de ordenação em Java. A implementação inclui operações fundamentais de lista e múltiplas técnicas de ordenação para fins educacionais.

## Arquitetura

### Estrutura de Classes
- **`No`**: Classe nó representando elementos individuais na lista duplamente ligada
- **`Lista`**: Classe principal implementando a lista duplamente ligada com algoritmos de ordenação
- **`Main`**: Classe de teste com testes unitários abrangentes


### Lista Dinâmica (`Lista.java`)
Implementa uma lista duplamente ligada com as seguintes operações:

#### Operações Básicas
- **`inserirNoInicio(int info)`**: Inserir no início - O(1)
- **`inserirNoFinal(int info)`**: Inserir no final - O(1)
- **`remover(int info)`**: Remover por valor - O(n)
- **`exibir()`**: Exibir todos os elementos - O(n)

#### Algoritmos de Busca
- **`buscaExaustiva(int info)`**: Busca linear - O(n)
- **`buscaBin(int info)`**: Busca binária em lista ordenada - O(log n)

#### Algoritmos de Ordenação
- **`insercaoDireta()`**: Ordenação por inserção direta - O(n²)
- **`selecaoDireta()`**: Ordenação por seleção - O(n²)
- **`bolha()`**: Ordenação bolha - O(n²)
- **`shake()`**: Ordenação cocktail shaker - O(n²)
